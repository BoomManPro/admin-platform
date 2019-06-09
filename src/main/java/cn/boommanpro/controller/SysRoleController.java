package cn.boommanpro.controller;


import cn.boommanpro.common.CallResult;
import cn.boommanpro.common.StatusType;
import cn.boommanpro.model.SysRole;
import cn.boommanpro.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author <a href="mailto:boommanpro@gmail.com">BoomManPro</a>
 * @data 2019/6/8 17:51
 * @since 1.0.0
 */
@RestController
@RequestMapping("/sys/role")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;


    //列所所有角色用于管理

    @GetMapping("/listAllForManage")
    public CallResult listAll(SysRole sysRole){
        return CallResult.success(sysRoleService.listAllForManage(sysRole));
    }

    //列出用户可用角色

    @GetMapping("/listOfUser")
    public CallResult listOfUser(@RequestParam Integer userNo){
        return CallResult.success(sysRoleService.listRoleNosOfUser(userNo));
    }

    @GetMapping("/list")
    public CallResult list(){
        return CallResult.success(sysRoleService.listAll());
    }


    @PostMapping("/add")
    public CallResult add(SysRole sysRole){
        sysRoleService.add(sysRole);
        return CallResult.success();
    }

    @PostMapping("/modify")
    public CallResult modify(SysRole sysRole){
        sysRoleService.modify(sysRole);
        return CallResult.success();
    }


    @PostMapping("/del")
    public CallResult del(@RequestParam Integer roleNo) {
        sysRoleService.del(roleNo);
        return CallResult.success();
    }

    @PostMapping("/disable")
    public CallResult disable(@RequestParam Integer roleNo) {
        sysRoleService.setDisableStatus(roleNo, StatusType.DISABLE.getKey());
        return CallResult.success();
    }

    @PostMapping("/enable")
    public CallResult enable(@RequestParam Integer roleNo) {
        sysRoleService.setDisableStatus(roleNo, StatusType.ENABLE.getKey());
        return CallResult.success();
    }

    @PostMapping("/menu/map")
    public CallResult menuMap(@RequestParam Integer no, @RequestParam("menuNos[]") List<Integer> menuNos){
        sysRoleService.menuMapping(no,menuNos);
        return CallResult.success();
    }

    @PostMapping("/url/map")
    public CallResult urlMap(@RequestParam Integer no, @RequestParam("urlNos[]") List<Integer> urlNos){
        sysRoleService.urlMapping(no,urlNos);
        return CallResult.success();
    }


}
