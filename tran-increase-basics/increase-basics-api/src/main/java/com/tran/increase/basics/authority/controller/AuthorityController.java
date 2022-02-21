package com.tran.increase.basics.authority.controller;

import com.tran.increase.basics.authority.dto.AuthorityParamDTO;
import com.tran.increase.basics.authority.service.AuthorityService;
import com.tran.increase.basics.base.result.AuthorityDTO;
import com.tran.increase.basics.base.result.AuthorityResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 权限C层
 * @author luxiangqian
 * 2022/2/21
 */
@Controller
@ResponseBody
@RequestMapping("/authority")
public class AuthorityController  {

    @Autowired
    private AuthorityService authorityService;

    @PostMapping(value = "/getAuthorityInfo",produces = "application/json;charset=UTF-8")
    public List<AuthorityDTO> getAuthorityInfo(@RequestBody AuthorityParamDTO paramDTO) {
        return authorityService.getAuthorityInfo(paramDTO);
    }

    @PostMapping(value = "/updateUserAuthority",produces = "application/json;charset=UTF-8")
    public AuthorityResult updateUserAuthority(@RequestBody AuthorityParamDTO paramDTO) {
        return authorityService.updateUserAuthority(paramDTO);
    }


}
