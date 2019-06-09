package cn.boommanpro.dao;

import cn.boommanpro.model.SysUserRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {
    int insert(SysUserRole record);

    int deleteByUserNo(int userNo);


    //如果sql中涉及到多个种类#{}就要用@Param

    //而不是参数只有一个

    int insertBatch(@Param("sysUserRoles") List<SysUserRole> sysUserRoles);

    List<Integer> listByUserNo(Integer userNo);
}