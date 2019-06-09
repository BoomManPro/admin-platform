package cn.boommanpro.dao;

import cn.boommanpro.dto.SysMenuVo;
import cn.boommanpro.model.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {
    int setSortByNo(@Param("menuNo") Integer menuNo, @Param("sort") Integer sort);

    int setDisableStatusByNo(@Param("menuNo") Integer menuNo, @Param("status") Integer status);


    List<SysMenuVo> listAllSysMenuVo();


    List<Integer> listMenuNosByRoleNo(Integer roleNo);
}