package cn.boommanpro.controller;

import cn.boommanpro.common.CallResult;
import cn.boommanpro.common.StatusType;
import cn.boommanpro.model.SysUser;
import cn.boommanpro.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author <a href="mailto:boommanpro@gmail.com">BoomManPro</a>
 * @data 2019/6/8 17:51
 * @since 1.0.0
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;


    //列出所有用户用于管理

    @GetMapping("/listAllForManage")
    public CallResult listAllForManage(SysUser sysUser) {
        return CallResult.success(sysUserService.listAllForManage(sysUser));
    }

    @PostMapping("/add")
    public CallResult add(SysUser sysUser) {
        sysUserService.add(sysUser);
        return CallResult.success();
    }

    @PostMapping("/modify")
    public CallResult modify(SysUser sysUser) {
        sysUserService.modify(sysUser);
        return CallResult.success();
    }


    @PostMapping("/del")
    public CallResult del(@RequestParam Integer userNo) {
        sysUserService.del(userNo);
        return CallResult.success();
    }

    @PostMapping("/disable")
    public CallResult disable(@RequestParam Integer userNo) {
        sysUserService.setDisableStatus(userNo, StatusType.ENABLE.getKey());
        return CallResult.success();
    }

    @PostMapping("/enable")
    public CallResult enable(@RequestParam Integer userNo) {
        sysUserService.setDisableStatus(userNo, StatusType.DISABLE.getKey());
        return CallResult.success();
    }

    //为用户设置角色映射关系

    @PostMapping("/role/map")
    public CallResult roleMap(@RequestParam Integer userNo, @RequestParam("roleNos[]") List<Integer> roleNos) {
        sysUserService.roleMapping(userNo, roleNos);
        return CallResult.success();
    }

}
