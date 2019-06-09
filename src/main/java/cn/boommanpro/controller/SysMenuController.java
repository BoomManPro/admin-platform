package cn.boommanpro.controller;


import cn.boommanpro.common.CallResult;
import cn.boommanpro.common.StatusType;
import cn.boommanpro.model.SysMenu;
import cn.boommanpro.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author <a href="mailto:boommanpro@gmail.com">BoomManPro</a>
 * @data 2019/6/8 17:51
 * @since 1.0.0
 */
@RestController
@RequestMapping("/sys/menu")
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;


    //列出所有菜单用于管理

    @GetMapping("/listAllForManage")
    public CallResult listAllForManage() {
        return CallResult.success(sysMenuService.listAllForManage());
    }


    @GetMapping("/tree")
    public CallResult tree(){

        return CallResult.success(sysMenuService.getTree());
    }

    @GetMapping("/currentMenu")
    public CallResult currentMnu(){
        return CallResult.success(sysMenuService.currentMenu());
    }


    //角色可用的菜单和

    @GetMapping("/ofRole")
    public CallResult ofRole(@RequestParam Integer roleNo) {
        return CallResult.success(sysMenuService.ofRole(roleNo));
    }

    @PostMapping("/add")
    public CallResult add(SysMenu sysMenu) {
        sysMenuService.add(sysMenu);
        return CallResult.success();
    }

    @PostMapping("/modify")
    public CallResult modify(SysMenu sysMenu) {
        sysMenuService.modify(sysMenu);
        return CallResult.success();
    }


    @PostMapping("/del")
    public CallResult del(@RequestParam Integer menuNo) {
        sysMenuService.del(menuNo);
        return CallResult.success();
    }

    @PostMapping("/setSort")
    public CallResult setSort(@RequestParam Integer menuNo, @RequestParam Integer sort) {
        sysMenuService.setSort(menuNo, sort);
        return CallResult.success();
    }

    @PostMapping("/disable")
    public CallResult disable(@RequestParam Integer menuNo) {
        sysMenuService.setDisableStatus(menuNo, StatusType.DISABLE.getKey());
        return CallResult.success();
    }

    @PostMapping("/enable")
    public CallResult enable(@RequestParam Integer menuNo) {
        sysMenuService.setDisableStatus(menuNo, StatusType.ENABLE.getKey());
        return CallResult.success();
    }
}
