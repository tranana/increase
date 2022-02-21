package com.tran.increase.basics.authority.controller;

import com.tran.increase.basics.authority.service.AuthorityService;
import com.tran.increase.basics.base.configbean.TranRedisPrefix;
import com.tran.increase.basics.base.util.TranRedisService;
import com.tran.increase.basics.constant.Constant;
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

    @Autowired
    private TranRedisService tranRedisService;


    @RequestMapping("/set")
    public String session(){
        TranRedisPrefix tranRedisPrefix = new TranRedisPrefix(Constant.REDIS_TEST_PRE);
        String test = tranRedisService.set(tranRedisPrefix, "test","你好");
        return test+"";
    }

    @RequestMapping("/get")
    public String get(){
        TranRedisPrefix tranRedisPrefix = new TranRedisPrefix(Constant.REDIS_TEST_PRE);
        String test = tranRedisService.get(tranRedisPrefix, "test",String.class);
        return test + "";
    }



}
