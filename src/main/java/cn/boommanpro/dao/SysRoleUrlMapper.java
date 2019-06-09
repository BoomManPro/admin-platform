package cn.boommanpro.dao;

import cn.boommanpro.model.SysRoleUrl;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysRoleUrlMapper extends BaseMapper<SysRoleUrl> {
    int deleteByRoleNo(Integer roleNo);

    int insertBath(@Param("roleNo") Integer roleNo, @Param("urlNos") List<Integer> urlNos);
}