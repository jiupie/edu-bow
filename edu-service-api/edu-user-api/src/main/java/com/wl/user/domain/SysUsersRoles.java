package com.wl.user.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 用户角色关联
 * @TableName sys_users_roles
 */
@TableName(value ="sys_users_roles")
@Data
public class SysUsersRoles implements Serializable {
    /**
     * 用户ID
     */
    @TableId
    private Long userId;

    /**
     * 角色ID
     */
    @TableId
    private Long roleId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}