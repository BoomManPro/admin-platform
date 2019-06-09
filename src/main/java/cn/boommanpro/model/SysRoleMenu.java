package cn.boommanpro.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "sys_role_menu")
public class SysRoleMenu {
    @TableField(value = "role_no")
    private Integer roleNo;

    @TableField(value = "menu_no")
    private Integer menuNo;

    public static final String COL_ROLE_NO = "role_no";

    public static final String COL_MENU_NO = "menu_no";
}