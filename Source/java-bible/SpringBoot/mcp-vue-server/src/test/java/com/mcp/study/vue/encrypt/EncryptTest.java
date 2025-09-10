package com.mcp.study.vue.encrypt;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author: KG
 * @description:
 * @date: Created in 18:07 2022/5/21
 * @modified by:
 */
public class EncryptTest {
    @Test
    public void testEncrypt() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode("123");
        System.out.println(encode);
    }
}
