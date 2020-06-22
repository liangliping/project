package com.example.demo.service.login;

import com.example.demo.constants.constants.UserConstants;
import com.example.demo.constants.meiju.UserEnum;
import com.example.demo.controller.login.LoginController;
import com.example.demo.dao.login.LoginDao;
import com.example.demo.pojo.UserBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Override
    public UserBean findUserInfoByName(String username) {
        UserBean bean = null;
        bean = UserConstants.getUserBeanByAccount(username);
        logger.info("根据账号{}去到的用户信息", bean.toString());
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
