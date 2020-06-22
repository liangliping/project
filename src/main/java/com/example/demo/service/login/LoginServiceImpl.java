package com.example.demo.service.login;

import com.example.demo.constants.constants.UserConstants;
import com.example.demo.constants.meiju.UserEnum;
import com.example.demo.dao.login.LoginDao;
import com.example.demo.pojo.UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description: LoginServiceImpl <br>
 *
 * @author Mr.Liang
 * Date: 2020/6/19 14:26 <br>
 */
@Service
public class LoginServiceImpl implements LoginService {


    //加密后的值
    private static final String SUPER_LIANG_PWD = "0cdaa36b745dc1e4243bf7b40fb79244";
    private static final String SUPER_HE_PWD = "2bdfc2fb0b891171ed8a0cd1aa99ca95";

    @Override
    public UserBean findUserInfoByName(String username) {
        UserBean bean = null;
        bean = UserConstants.getUserBeanByAccount(username);
        return bean;
    }

    public static void main(String[] args) {
        String a = "superHe";
        List<UserBean> bean = UserConstants.getUserBean();
        for (UserBean userBean : bean) {
            if (userBean.getAccount().equals(a)) {
                System.out.println("存在");
                break;
            }
        }
    }
}
