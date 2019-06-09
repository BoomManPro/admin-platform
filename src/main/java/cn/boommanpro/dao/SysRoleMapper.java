package cn.boommanpro.dao;

import cn.boommanpro.dto.SysRoleVo;
import cn.boommanpro.model.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {
    // TODO: 2018/5/3 模糊搜索 条件查询
    List<SysRole> listByPrimaryKey(SysRole sysRole);

    int setDisabledStatus(@Param("roleNo") Integer roleNo, @Param("status") Integer status);


    List<SysRoleVo> listAllSysRoleVo();
}