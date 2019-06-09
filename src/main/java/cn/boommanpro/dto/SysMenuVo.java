package cn.boommanpro.dto;

import lombok.Data;

/**
 * @author <a href="mailto:boommanpro@gmail.com">BoomManPro</a>
 * @data 2019/6/8 17:51
 * @since 1.0.0
 */
@Data
public class SysMenuVo {

    private Integer menuNo;

    private String title;

    private Integer parentNo;


    private String icon;

    private String type;

    private Integer sort;

    private Integer disabled;


    private String resource;

    private String description;
}
