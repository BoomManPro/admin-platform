package cn.boommanpro.service;


import cn.boommanpro.common.BeanUtils;
import cn.boommanpro.common.StatusType;
import cn.boommanpro.dao.SysMenuMapper;
import cn.boommanpro.dto.SysMenuTreeVo;
import cn.boommanpro.dto.SysMenuVo;
import cn.boommanpro.model.SysMenu;
import cn.boommanpro.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:boommanpro@gmail.com">BoomManPro</a>
 * @data 2019/6/8 17:51
 * @since 1.0.0
 */
@Service
public class SysMenuService {
    @Autowired
    private SysMenuMapper sysMenuMapper;

    public List<SysMenu> listAllForManage(){
        return null;
    }

    public void add(SysMenu sysMenu) {
        sysMenuMapper.insert(sysMenu);
    }

    public void del(Integer menuNo){


        //菜单删除 要将子级菜单也设置为禁用

        sysMenuMapper.setDisableStatusByNo(menuNo, StatusType.ENABLE.getKey());
    }

    public void setSort(Integer menuNo,Integer sort){
        sysMenuMapper.setSortByNo(menuNo, sort);
    }

    public void modify(SysMenu sysMenu) {
        sysMenuMapper.updateById(sysMenu);
    }
    public void setDisableStatus(Integer menuNo,Integer status){
        sysMenuMapper.setDisableStatusByNo(menuNo, status);
    }

    public List<Integer> ofRole(Integer roleNo){
        //根据所有菜单和用户菜单  拼出完整的菜单



        return sysMenuMapper.listMenuNosByRoleNo(roleNo);
    }


    public SysMenuTreeVo ofShow(SysUser sysUser){

        //
        return getTree();
    }

    public SysMenuTreeVo currentMenu(){
        return null;
    }


    public SysMenuTreeVo getTree(){
        //获取所有的MenuVo
        List<SysMenuVo> sysMenuVos = sysMenuMapper.listAllSysMenuVo();

        //menu转换为tree结构
        return menuVoList2MenuTree(sysMenuVos);
    }
    private SysMenuTreeVo menuVoList2MenuTree(List<SysMenuVo> sysMenuVos){
        SysMenuTreeVo sysMenuTreeVo = new SysMenuTreeVo();
        List<SysMenuTreeVo> children;

       //转换成树形结构算法:

        //顶层的node为null


        sysMenuTreeVo.setTitle("根");
        sysMenuTreeVo.setExpand(true);
        sysMenuTreeVo.setMenuNo(0);
        //顶层元素为null
        sysMenuTreeVo.setChildren(getChildrenList(sysMenuVos,sysMenuTreeVo.getMenuNo()));



        return sysMenuTreeVo;
    }


    public List<SysMenuTreeVo> getChildrenList(List<SysMenuVo> sysMenuVos,Integer parentNo){
        //init当前层的子级元素

        //结束条件,否则成为死循环

        List<SysMenuTreeVo> childrenList = new ArrayList<>();
        SysMenuTreeVo smt;
        for (SysMenuVo sysMenuVo: sysMenuVos) {
            if (sysMenuVo.getParentNo().equals(parentNo)){
                smt=new SysMenuTreeVo();

                switch (sysMenuVo.getType()){
                    case "GROUP":break;
                    default: smt.setExpand(true);break;
                }

                //属性复制
                BeanUtils.copyProperties(sysMenuVo,smt);
                //添加子级
                childrenList.add(smt);
                smt.setChildren(getChildrenList(sysMenuVos,smt.getMenuNo()));
            }
        }
        if (childrenList.size()==0){
            return null;
        }
        return childrenList;
    }





}
