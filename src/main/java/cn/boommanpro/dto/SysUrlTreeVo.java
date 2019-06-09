package cn.boommanpro.dto;

import lombok.Data;

import java.util.List;

/**
 * @author <a href="mailto:boommanpro@gmail.com">BoomManPro</a>
 * @data 2019/6/8 17:51
 * @since 1.0.0
 */
@Data
public class SysUrlTreeVo {


    private Integer urlNo;


    private String name;

    private String title;


    private String resource;


    private String module;

    private String operation;


    private String data;

    private boolean expand;

    private Integer sort;

    private String viewType;

    private Integer disabled;

    private String description;

    private boolean checked;

    private List<SysUrlTreeVo> children;

}
