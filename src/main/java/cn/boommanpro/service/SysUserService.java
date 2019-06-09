package cn.boommanpro.service;


import cn.boommanpro.common.StatusType;
import cn.boommanpro.dao.SysUserMapper;
import cn.boommanpro.dao.SysUserRoleMapper;
import cn.boommanpro.model.SysUser;
import cn.boommanpro.model.SysUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:boommanpro@gmail.com">BoomManPro</a>
 * @data 2019/6/8 17:51
 * @since 1.0.0
 */
@Service
public class SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    public List<SysUser> listAllForManage(SysUser sysUser){
        sysUser.setDeleted(StatusType.DISABLE.getKey());
        return sysUserMapper.listAll(sysUser);
    }

    public void add(SysUser sysUser){
        LocalDateTime now=LocalDateTime.now();
        sysUser.setDisabled(StatusType.DISABLE.getKey());
        sysUser.setDeleted(StatusType.DISABLE.getKey());
        sysUser.setUpdateDate(now);
        sysUser.setCreateDate(now);
        sysUserMapper.insert(sysUser);
    }

    public void modify(SysUser sysUser){
        sysUser.setCreateDate(null);
        sysUser.setUpdateDate(LocalDateTime.now());
        sysUserMapper.updateById(sysUser);
    }

    public void del(int userNo){
        sysUserMapper.deleteByUserNo(userNo);
    }

    public void setDisableStatus(int userNo,int status){
        sysUserMapper.setUserDisable(userNo, status);
    }


    //用户角色关系映射,策略是先删除用户全部角色关系,再建立角色关系

    public void roleMapping(int userNo,List<Integer> roleNos){
        List<SysUserRole> sysUserRoles = userNoRoleNos2UserRoles(userNo, roleNos);
        sysUserRoleMapper.deleteByUserNo(userNo);
        sysUserRoleMapper.insertBatch(sysUserRoles);
    }


    private List<SysUserRole> userNoRoleNos2UserRoles(int userNo,List<Integer> roleNos){
        List<SysUserRole> sysUserRoles = new ArrayList<>();
        SysUserRole sysUserRole;
        for (Integer roleNo: roleNos) {
            sysUserRole=new SysUserRole(userNo,roleNo);
            sysUserRoles.add(sysUserRole);
        }
        return sysUserRoles;
    }

}
