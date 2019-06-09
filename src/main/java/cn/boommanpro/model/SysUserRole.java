package cn.boommanpro.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "sys_user_role")
public class SysUserRole {
    @TableField(value = "user_no")
    private Integer userNo;

    @TableField(value = "role_no")
    private Integer roleNo;

    public static final String COL_USER_NO = "user_no";

    public static final String COL_ROLE_NO = "role_no";
}