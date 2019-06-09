package cn.boommanpro.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "sys_url")
public class SysUrl {
     @TableId(value = "url_no", type = IdType.AUTO)
    private Integer urlNo;

    @TableField(value = "name")
    private String name;

    @TableField(value = "resource")
    private String resource;

    @TableField(value = "module")
    private String module;

    @TableField(value = "data")
    private String data;

    @TableField(value = "sort")
    private Integer sort;

    @TableField(value = "view_type")
    private String viewType;

    @TableField(value = "disabled")
    private Integer disabled;

    @TableField(value = "description")
    private String description;

    @TableField(value = "operation")
    private String operation;

    public static final String COL_NAME = "name";

    public static final String COL_RESOURCE = "resource";

    public static final String COL_MODULE = "module";

    public static final String COL_DATA = "data";

    public static final String COL_SORT = "sort";

    public static final String COL_VIEW_TYPE = "view_type";

    public static final String COL_DISABLED = "disabled";

    public static final String COL_DESCRIPTION = "description";

    public static final String COL_OPERATION = "operation";
}