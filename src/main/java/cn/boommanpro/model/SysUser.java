package cn.boommanpro.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import lombok.Data;

@Data
@TableName(value = "sys_user")
public class SysUser {
     @TableId(value = "user_no", type = IdType.AUTO)
    private Integer userNo;

    @TableField(value = "login_name")
    private String loginName;

    @TableField(value = "nickname")
    private String nickname;

    @TableField(value = "phone")
    private String phone;

    @TableField(value = "mail")
    private String mail;

    @TableField(value = "disabled")
    private Integer disabled;

    @TableField(value = "deleted")
    private Integer deleted;

    @TableField(value = "create_date")
    private LocalDateTime createDate;

    @TableField(value = "update_date")
    private LocalDateTime updateDate;

    @TableField(value = "last_login_date")
    private LocalDateTime lastLoginDate;

    public static final String COL_LOGIN_NAME = "login_name";

    public static final String COL_NICKNAME = "nickname";

    public static final String COL_PHONE = "phone";

    public static final String COL_MAIL = "mail";

    public static final String COL_DISABLED = "disabled";

    public static final String COL_DELETED = "deleted";

    public static final String COL_CREATE_DATE = "create_date";

    public static final String COL_UPDATE_DATE = "update_date";

    public static final String COL_LAST_LOGIN_DATE = "last_login_date";
}