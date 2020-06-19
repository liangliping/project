package com.example.demo.controller.login;

import com.example.demo.pojo.UserBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Description: LoginController <br>
 *
 * @author Liang lp
 * Date: 2020/4/30 10:42 <br>
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/login")
    @ResponseBody
    public HashMap<String, Object> login( UserBean userBean, HttpServletRequest request){

        //获取session
        HttpSession session = request.getSession();
        HashMap<String, Object> map = new HashMap<String, Object>();

        UsernamePasswordToken token = new UsernamePasswordToken(userBean.getAccount(), userBean.getPwd());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            UserBean userInfo = (UserBean) subject.getPrincipal();
            session.setAttribute(session.getId(), userInfo);
            session.setAttribute("userid",userInfo.getId());
            map.put("code", 0);
            map.put("message", "登陆成功！");

        } catch (UnknownAccountException e) {
            map.put("code", 2);
            map.put("message", "用户名不存在！");
            return map;
        } catch (IncorrectCredentialsException e){
            map.put("code", 3);
            map.put("message", "密码错误！");
            return map;
        }
        return map;
    }


    @RequestMapping("logout")
    public String logout(){
        return "view/login";
    }
}
