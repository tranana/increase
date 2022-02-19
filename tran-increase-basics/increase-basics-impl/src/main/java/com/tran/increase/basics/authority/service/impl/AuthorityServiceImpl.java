package com.tran.increase.basics.authority.service.impl;

import com.tran.increase.basics.authority.service.AuthorityService;
import com.tran.increase.basics.base.result.AuthorityResult;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author luxiangqian
 * 2022/2/18
 */
@Service
public class AuthorityServiceImpl implements AuthorityService {


    @Override
    public List<Map<String, Object>> getAuthorityInfo(String userID) {
        return null;
    }

    @Override
    public AuthorityResult addUserAuthority(String userID, String name) {
        return null;
    }

    @Override
    public AuthorityResult delUserAuthority(String userID, String name) {
        return null;
    }
}
