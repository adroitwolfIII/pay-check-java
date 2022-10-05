package com.run.paychecksystem.mapper;

import com.run.paychecksystem.config.BaseMapper;
import com.run.paychecksystem.entity.Pay;
import com.run.paychecksystem.entity.PayRes4Manager;
import com.run.paychecksystem.entity.vo.QueryParams;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PayMapper extends BaseMapper<Pay> {
    List<PayRes4Manager> selectPay4Admin(@Param("query") QueryParams queryParams);
}
