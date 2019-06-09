package cn.boommanpro.service;


import cn.boommanpro.common.BeanUtils;
import cn.boommanpro.common.StatusType;
import cn.boommanpro.dao.SysUrlMapper;
import cn.boommanpro.dto.SysUrlTreeVo;
import cn.boommanpro.model.SysUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author <a href="mailto:boommanpro@gmail.com">BoomManPro</a>
 * @data 2019/6/8 17:51
 * @since 1.0.0
 */
@Service
public class SysUrlService {
    @Autowired
    private SysUrlMapper sysUrlMapper;


    public List<SysUrl> listAll() {
        return sysUrlMapper.listAll();
    }


    public void add(SysUrl sysUrl) {
        sysUrlMapper.insert(sysUrl);
    }

    public void modify(SysUrl sysUrl) {
        sysUrlMapper.updateById(sysUrl);
    }

    public void del(Integer urlNo) {
        sysUrlMapper.setDisabledStatus(urlNo, StatusType.ENABLE.getKey());
    }

    public void setSort(Integer urlNo, Integer sort) {

    }

    public void setDisabledStatus(Integer urlNo, Integer staus) {

    }

    public List<Integer> listNosOfRole(Integer roleNo) {
        return sysUrlMapper.listUrlNosOfRoleNo(roleNo);
    }


    public List<SysUrl> listOfRole(Integer roleNo) {
        return sysUrlMapper.listOfRole(roleNo);
    }


    //Tree生成顺序记录

    //第一步 获取顶级目录 根目录

    //第二步 获取第一级别目录 module目录

    //第三步 获取第二级别目录 data目录

    //第四步 用ajax获取具体资源信息 url


    public SysUrlTreeVo getDetailTree(){
        List<SysUrl> sysUrls = sysUrlMapper.listAll();
        return url2UrlTree(sysUrls,true);
    }


    public SysUrlTreeVo getTree() {
        List<SysUrl> sysUrls = sysUrlMapper.listAll();
        return url2UrlTree(sysUrls,false);
    }


    private SysUrlTreeVo url2UrlTree(List<SysUrl> sysUrls,boolean detail) {

        SysUrlTreeVo sysUrlTreeVo = new SysUrlTreeVo();

        sysUrlTreeVo.setTitle("根");
        sysUrlTreeVo.setExpand(true);

        //获取到moduleData  key->module   value->data列表
        Map<String, Set<String>> moduleDataMap = new HashMap<>();
        for (SysUrl sysUrl : sysUrls) {
            Set<String> stringList = moduleDataMap.get(sysUrl.getModule());
            if (stringList == null) {
                stringList = new HashSet<>();

            }
            stringList.add(sysUrl.getData());
            moduleDataMap.put(sysUrl.getModule(), stringList);
        }

        //获取module的set集合
        Set<String> set = moduleDataMap.keySet();
        //建立第一层级children
        List<SysUrlTreeVo> children = new ArrayList<>();

        //设置第一层级和第二层级关联关系
        sysUrlTreeVo.setChildren(children);

        SysUrlTreeVo sut;

        for (String moduleName : set) {
            sut = new SysUrlTreeVo();
            sut.setTitle(moduleName);
            //这里需要设置data内容
            sut.setChildren(getModuleChildren(sysUrls, moduleDataMap, moduleName,detail));
            sut.setExpand(true);
            sut.setModule(moduleName);
            children.add(sut);
        }


        return sysUrlTreeVo;
    }


    private List<SysUrlTreeVo> getModuleChildren(List<SysUrl> sysUrls, Map<String, Set<String>> moduleDataMap, String moduleName,boolean detail) {
        List<SysUrlTreeVo> moduleChildren = new ArrayList<>();
        Set<String> stringList = moduleDataMap.get(moduleName);
        SysUrlTreeVo sut;
        for (String dataName : stringList) {
            sut = new SysUrlTreeVo();
            sut.setTitle(dataName);
            sut.setModule(moduleName);
            sut.setData(dataName);
            sut.setExpand(true);
            if (detail){
                sut.setChildren(getUrlList(moduleName,dataName));
            }
            moduleChildren.add(sut);
        }
        if (moduleChildren.size()==0){
            return null;
        }
        return moduleChildren;
    }





    public List<SysUrlTreeVo> getUrlList(String moduleName, String dataName) {
        List<SysUrl> sysUrls = sysUrlMapper.listAll();

        List<SysUrlTreeVo> urlChildren = new ArrayList<>();
        SysUrlTreeVo sut;
        for (SysUrl sysUrl : sysUrls) {
            if (sysUrl.getModule().equals(moduleName)&&sysUrl.getData().equals(dataName)){
                sut = new SysUrlTreeVo();
                sut.setTitle(sysUrl.getName()+sysUrl.getResource());
                BeanUtils.copyProperties(sysUrl,sut);
                urlChildren.add(sut);
            }
        }
        if (urlChildren.size()==0){
            return null;
        }
        return urlChildren;
    }

    public List<String> getSysUserUrlList(Integer userNo){
        return sysUrlMapper.getResourceListByUserNo(userNo);
    }


}
