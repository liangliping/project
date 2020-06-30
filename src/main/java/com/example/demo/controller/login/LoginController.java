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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
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

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @ApiOperation(value="根据用户名登陆宇宙无敌超级项目", notes="登陆")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userBean", value = "user用户实体对象", required = false, dataType = "User"),
            @ApiImplicitParam(name = "request", value = "request请求对象", required = false, dataType = "HttpServletRequest")
            })
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public HashMap<String, Object> login( UserBean userBean, HttpServletRequest request){

        if (StringUtils.isEmpty(userBean.getAccount())){
            throw new NullPointerException("Account is empty");
        }
        if (StringUtils.isEmpty(userBean.getPwd())){
            throw new NullPointerException("password is empty");
        }
        //获取session
        HttpSession session = request.getSession();
        HashMap<String, Object> map = new HashMap<String, Object>(16);

        UsernamePasswordToken token = new UsernamePasswordToken(userBean.getAccount(), userBean.getPwd());
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            UserBean userInfo = (UserBean) subject.getPrincipal();
            session.setAttribute(session.getId(), userInfo);
            session.setAttribute("userid",userInfo.getId());
            //设置单位为秒，设置为-1永不过期
            session.setMaxInactiveInterval(30*60);
            map.put("code", 0);
            map.put("message", "登陆成功！");

        } catch (UnknownAccountException e) {
            logger.info("用户{}账号不存在",userBean.getAccount());
            map.put("code", 2);
            map.put("message", "用户名不存在！");
            return map;
        } catch (IncorrectCredentialsException e){
            logger.info("用户{}密码错误",userBean.getAccount());
            map.put("code", 3);
            map.put("message", "密码错误！");
            return map;
        }
        return map;
    }


    @ApiOperation(value="退出登录", notes="退出登录")
    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    public String logout(){
        return "/login";
    }
}
