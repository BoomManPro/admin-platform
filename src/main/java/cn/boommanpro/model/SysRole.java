package cn.boommanpro.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "sys_role")
public class SysRole {
     @TableId(value = "role_no", type = IdType.AUTO)
    private Integer roleNo;

    @TableField(value = "name")
    private String name;

    @TableField(value = "disabled")
    private Integer disabled;

    @TableField(value = "description")
    private String description;

    public static final String COL_NAME = "name";

    public static final String COL_DISABLED = "disabled";

    public static final String COL_DESCRIPTION = "description";
}