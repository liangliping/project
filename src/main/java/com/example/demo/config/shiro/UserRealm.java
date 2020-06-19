package com.example.demo.config.shiro;

import com.example.demo.pojo.UserBean;
import com.example.demo.service.login.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;

/**
 * Description: UserRealm <br>
 *
 * @author Liang lp
 * Date: 2020/4/30 14:02 <br>
 */
public class UserRealm extends AuthorizingRealm {


    @Autowired
    private LoginService loginService;

/*    @Autowired
    private UserService userService;*/

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑");

/*        UserBean userBean = (UserBean) SecurityUtils.getSubject().getPrincipal();
        Integer userId = userBean.getUserid();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();


        HashSet<String> roleSet = userService.findRoleSet(userId);
        System.out.println(roleSet);
        //添加资源授权字符串  角色名
        info.setRoles(roleSet);*/

        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        System.out.println("执行认证逻辑");

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();

       UserBean userBean = loginService.findUserInfoByName(username);

        //UserBean userBean = new UserBean();
        if (userBean == null) {
            return null;
        }

        return new SimpleAuthenticationInfo(userBean, userBean.getPwd(), this.getClass().getName());//放入shiro.调用CredentialsMatcher检验密码
    }

}
