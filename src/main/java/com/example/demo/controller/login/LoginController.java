package com.example.demo.controller.login;

import com.example.demo.pojo.UserBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * Description: LoginController <br>
 *
 * @author Liang lp
 * Date: 2020/4/30 10:42 <br>
 */
@Api(tags = "登陆操作接口")
@Controller
@RequestMapping("/login")
public class LoginController {


    @ApiOperation(value="根据用户名登陆宇宙无敌超级项目", notes="登陆")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userBean", value = "user用户实体对象", required = false, dataType = "User"),
            @ApiImplicitParam(name = "request", value = "request请求对象", required = false, dataType = "HttpServletRequest")
            })
    @RequestMapping(value = "/login",method = RequestMethod.POST)
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


    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    public String logout(){
        return "view/login";
    }
}
