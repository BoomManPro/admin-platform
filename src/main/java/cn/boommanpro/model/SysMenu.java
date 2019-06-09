package cn.boommanpro.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "sys_menu")
public class SysMenu {
     @TableId(value = "menu_no", type = IdType.AUTO)
    private Integer menuNo;

    @TableField(value = "title")
    private String title;

    @TableField(value = "parent_no")
    private Integer parentNo;

    @TableField(value = "type")
    private String type;

    @TableField(value = "icon")
    private String icon;

    @TableField(value = "sort")
    private Integer sort;

    @TableField(value = "url_no")
    private Integer urlNo;

    @TableField(value = "disabled")
    private Integer disabled;

    @TableField(value = "description")
    private String description;

    public static final String COL_TITLE = "title";

    public static final String COL_PARENT_NO = "parent_no";

    public static final String COL_TYPE = "type";

    public static final String COL_ICON = "icon";

    public static final String COL_SORT = "sort";

    public static final String COL_URL_NO = "url_no";

    public static final String COL_DISABLED = "disabled";

    public static final String COL_DESCRIPTION = "description";
}