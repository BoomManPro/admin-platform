package cn.boommanpro.service;


import cn.boommanpro.common.StatusType;
import cn.boommanpro.dao.SysRoleMapper;
import cn.boommanpro.dao.SysRoleMenuMapper;
import cn.boommanpro.dao.SysRoleUrlMapper;
import cn.boommanpro.dao.SysUserRoleMapper;
import cn.boommanpro.dto.SysRoleVo;
import cn.boommanpro.model.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author <a href="mailto:boommanpro@gmail.com">BoomManPro</a>
 * @data 2019/6/8 17:51
 * @since 1.0.0
 */
@Service
public class SysRoleService {
    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysRoleUrlMapper sysRoleUrlMapper;

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    public List<SysRole> listAllForManage(SysRole sysRole){
        return sysRoleMapper.listByPrimaryKey(sysRole);
    }

    public List<Integer> listRoleNosOfUser(Integer userNo){


        return sysUserRoleMapper.listByUserNo(userNo);
    }

    public List<SysRoleVo> listAll(){
       return sysRoleMapper.listAllSysRoleVo();
    }



    public void add(SysRole sysRole) {
        // TODO: 2018/4/25 设置一些role参数
        sysRole.setDisabled(StatusType.DISABLE.getKey());
        sysRoleMapper.insert(sysRole);
    }

    public void modify(SysRole sysRole){
        sysRoleMapper.updateById(sysRole);
    }

    public void del(Integer roleNo){
        sysRoleMapper.setDisabledStatus(roleNo, StatusType.ENABLE.getKey());
    }

    public void setDisableStatus(Integer roleNo,Integer status){

    }


    public void urlMapping(Integer roleNo,List<Integer> urlNos){
        if (urlNos == null || urlNos.size() == 0) {
            return;

        }
        //清除原本映射关系
        sysRoleUrlMapper.deleteByRoleNo(roleNo);

        sysRoleUrlMapper.insertBath(roleNo,urlNos);

    }

    public void menuMapping(Integer roleNo,List<Integer> menuNos){
        if (menuNos == null || menuNos.size() == 0) {
            return;
        }
        sysRoleMenuMapper.deleteById(roleNo);
        sysRoleMenuMapper.insertBath(roleNo, menuNos);
    }

}
