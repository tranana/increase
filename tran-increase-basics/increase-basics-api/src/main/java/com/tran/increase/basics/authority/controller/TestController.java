package com.tran.increase.basics.authority.controller;

import com.tran.increase.basics.authority.service.AuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author luxiangqian
 * 2022/2/19
 */
@Controller
@ResponseBody
@RequestMapping("/")
public class TestController {


    @Autowired
    private AuthorityService authorityService;

    @RequestMapping("/get")
    public String session(){
        return authorityService.get();
    }

}
