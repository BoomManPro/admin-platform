package cn.boommanpro.dao;

import cn.boommanpro.model.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    int deleteByUserNo(int userNo);

    int setUserDisable(@Param("userNo") int userNo, @Param("status") int status);


    List<SysUser> listAll(SysUser sysUser);

    SysUser selectByLoginName(String loginName);
}