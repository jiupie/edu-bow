package com.wl.user.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 角色菜单关联
 * @TableName sys_roles_menus
 */
@TableName(value ="sys_roles_menus")
@Data
public class SysRolesMenus implements Serializable {
    /**
     * 菜单ID
     */
    @TableId
    private Long menuId;

    /**
     * 角色ID
     */
    @TableId
    private Long roleId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}