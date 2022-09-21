package com.run.paychecksystem.service.impl;

import com.run.paychecksystem.entity.Pay;
import com.run.paychecksystem.entity.User;
import com.run.paychecksystem.entity.vo.BaseResponse;
import com.run.paychecksystem.entity.vo.PayParams;
import com.run.paychecksystem.entity.vo.QueryParams;
import com.run.paychecksystem.mapper.PayMapper;
import com.run.paychecksystem.mapper.UserMapper;
import com.run.paychecksystem.service.PayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.weekend.WeekendSqls;

import java.util.List;
import java.util.Objects;

/**
 * <pre>PayServiceImpl</pre>
 *
 * @author <p>ADROITWOLF</p> 2022/9/7
 */
@Service
@Slf4j
public class PayServiceImpl implements PayService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    PayMapper payMapper;


    @Override
    public BaseResponse insert(PayParams payParams) {
        // 先判断该员工是不是新员工
        Example example = Example.builder(User.class).andWhere(WeekendSqls.<User>custom().andEqualTo(User::getName, payParams.getName())).build();

        User user = userMapper.selectOneByExample(example);

        // 说明该员工数据库中没有资料
        if (Objects.isNull(user)){
            user = User.builder().name(payParams.getName()).type(1).build();
            userMapper.insertSelective(user);

        }
        Pay build = Pay.builder().userId(user.getId()).dateTime(payParams.getDate()).build();

        BeanUtils.copyProperties(payParams,build);

        payMapper.insertSelective(build);

        return BaseResponse.success("新增成功");
    }

    @Override
    public BaseResponse search(QueryParams queryParams) {
        // 获取用户id
        Example example = Example.builder(User.class).andWhere(WeekendSqls.<User>custom().andEqualTo(User::getName, queryParams.getName())).build();
        User user = userMapper.selectOneByExample(example);

        Example example1 = Example.builder(Pay.class).andWhere(WeekendSqls.<Pay>custom().andEqualTo(Pay::getUserId, user.getId()).andBetween(Pay::getDateTime, queryParams.getStartDate(),queryParams.getEndDate())).build();

        List<Pay> pays = payMapper.selectByExample(example1);


        return BaseResponse.success(pays);
    }

}
