package com.run.paychecksystem.entity.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * <pre>AutoToken</pre>
 *  用户认证token
 * @author <p>ADROITWOLF</p> 2021-05-07
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AutoToken {
    /**
     * Access token.
     */
    @JsonProperty("token")
    private String accessToken;

}
