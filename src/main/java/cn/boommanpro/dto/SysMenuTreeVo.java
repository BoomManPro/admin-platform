package cn.boommanpro.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author <a href="mailto:boommanpro@gmail.com">BoomManPro</a>
 * @data 2019/6/8 17:51
 * @since 1.0.0
 */
@Data
public class SysMenuTreeVo implements Serializable {


    private static final long serialVersionUID = 5417625475557259061L;
    private Integer menuNo;

    private String title;

    private Integer parentNo;


    private boolean checked;

    private boolean expand;

    private String icon;

    private String type;

    private Integer sort;

    private Integer disabled;

    private String resource;

    private String description;


    private List<SysMenuTreeVo> children;




}
