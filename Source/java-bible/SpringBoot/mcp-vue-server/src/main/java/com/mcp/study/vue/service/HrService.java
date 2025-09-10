package com.mcp.study.vue.service;

import com.mcp.study.vue.mapper.HrMapper;
import com.mcp.study.vue.model.Hr;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: KG
 * @description:
 * @date: Created in 17:42 2022/5/21
 * @modified by:
 */
@Service
public class HrService implements UserDetailsService {

    @Resource
    private HrMapper hrMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 根据用户名, 查找是否存在这个人
        Hr hr = hrMapper.loadUserByUsername(username);
        if (hr == null) {
            throw new UsernameNotFoundException("用户不存在");
        }

        return hr;
    }
}
