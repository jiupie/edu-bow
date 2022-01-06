package com.wl.user.dto;

import com.wl.user.domain.SysUser;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
@Data
public class UserInfo implements Serializable {
    private static final long serialVersionUID = -7657663783681647907L;

    /**
     * 系统用户信息
     */
    @ApiModelProperty("系统用户信息")
    private SysUser sysUser;
}
