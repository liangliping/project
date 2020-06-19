package com.example.demo.service.login;

import com.example.demo.pojo.UserBean;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;

/**
 * Description: LoginService <br>
 *
 * @author Mr.Liang
 * Date: 2020/6/19 14:26 <br>
 */
public interface LoginService {

    /**
     * 根据账号用户
     * @param username
     * @return
     */
    UserBean findUserInfoByName(String username);
}
