package cn.boommanpro.controller;

import cn.boommanpro.common.CallResult;
import cn.boommanpro.common.StatusType;
import cn.boommanpro.model.SysUrl;
import cn.boommanpro.service.SysUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author <a href="mailto:boommanpro@gmail.com">BoomManPro</a>
 * @data 2019/6/8 17:51
 * @since 1.0.0
 */
@RestController
@RequestMapping("/sys/url")
public class SysUrlController {

    @Autowired
    private SysUrlService sysUrlService;


    //列出所有路径资源用于管理

    @GetMapping("/listAllForManage")
    public CallResult listAll(){
        return CallResult.success(sysUrlService.listAll());
    }

    //角色可用的路径资源和


    @GetMapping("/tree")
    public CallResult tree(){
        return CallResult.success(sysUrlService.getTree());
    }


    @GetMapping("/detailTree")
    public CallResult detailTree(){

        return CallResult.success(sysUrlService.getDetailTree());
    }



    @GetMapping("list")
    public CallResult list(){
        return CallResult.success(sysUrlService.listAll());
    }



    @GetMapping("/treeList")
    public CallResult treeList(String module,String data){
        return CallResult.success(sysUrlService.getUrlList(module,data));
    }


    @GetMapping("/listNosOfRole")
    public CallResult listNosOfRole(@RequestParam Integer roleNo){
        return CallResult.success(sysUrlService.listNosOfRole(roleNo));
    }

    @GetMapping("/ofRole")
    public CallResult ofRole(@RequestParam Integer roleNo){
        return CallResult.success(sysUrlService.listOfRole(roleNo));
    }

    @PostMapping("/add")
    public CallResult add(SysUrl sysUrl) {
        sysUrlService.add(sysUrl);
        return CallResult.success();
    }

    @PostMapping("/modify")
    public CallResult modify(SysUrl sysUrl) {
        sysUrlService.modify(sysUrl);
        return CallResult.success();
    }


    @PostMapping("/del")
    public CallResult del(@RequestParam Integer urlNo) {
        sysUrlService.del(urlNo);
        return CallResult.success();
    }

    @PostMapping("/setSort")
    public CallResult setSort(@RequestParam Integer no, @RequestParam Integer sort) {
        sysUrlService.setSort(no, sort);
        return CallResult.success();
    }

    @PostMapping("/disable")
    public CallResult disable(@RequestParam Integer no) {
        sysUrlService.setDisabledStatus(no, StatusType.DISABLE.getKey());
        return CallResult.success();
    }

    @PostMapping("/enable")
    public CallResult enable(@RequestParam Integer no) {
        sysUrlService.setDisabledStatus(no, StatusType.ENABLE.getKey());
        return CallResult.success();
    }
}
