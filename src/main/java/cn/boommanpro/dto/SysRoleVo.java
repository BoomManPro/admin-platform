package cn.boommanpro.dto;

import lombok.Data;

/**
 * @author <a href="mailto:boommanpro@gmail.com">BoomManPro</a>
 * @data 2019/6/8 17:51
 * @since 1.0.0
 */
@Data
public class SysRoleVo {
    private Integer roleNo;


    private String name;


    private String description;

    private boolean checked;
}
