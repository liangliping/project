package com.example.demo.service.login;

import com.example.demo.pojo.UserBean;
import org.springframework.stereotype.Service;

/**
 * Description: LoginServiceImpl <br>
 *
 * @author Mr.Liang
 * Date: 2020/6/19 14:26 <br>
 */
@Service
public class LoginServiceImpl implements LoginService {

    //加密后的值
    private static final String pwd = "0cdaa36b745dc1e4243bf7b40fb79244";

    @Override
    public UserBean findUserInfoByName(String username) {
        UserBean bean = null;
        if ("superHe".equals(username)) {
            bean = new UserBean(1, "superHe", pwd);
        } else if ("superLiang".equals(username)) {
            bean = new UserBean(1, "superLiang", pwd);
        }
        return bean;
    }
}
