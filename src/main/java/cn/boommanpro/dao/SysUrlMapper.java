package cn.boommanpro.dao;

import cn.boommanpro.model.SysUrl;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysUrlMapper extends BaseMapper<SysUrl> {
    List<SysUrl> listAll();

    int setDisabledStatus(@Param("urlNo") Integer urlNo, @Param("status") Integer status);

    List<SysUrl> listOfRole(Integer roleNo);

    List<Integer> listUrlNosOfRoleNo(Integer roleNo);

    List<String> getResourceListByUserNo(Integer userNo);
}