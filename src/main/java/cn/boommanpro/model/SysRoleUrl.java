package cn.boommanpro.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "sys_role_url")
public class SysRoleUrl {
    @TableField(value = "role_no")
    private Integer roleNo;

    @TableField(value = "url_no")
    private Integer urlNo;

    public static final String COL_ROLE_NO = "role_no";

    public static final String COL_URL_NO = "url_no";
}