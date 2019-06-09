package cn.boommanpro.dao;

import cn.boommanpro.model.SysRoleMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {
    int insertBath(@Param("roleNo") Integer roleNo, @Param("menuNos") List<Integer> menuNos);
}