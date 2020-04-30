package com.example.demo.controller.login;

import com.example.demo.pojo.UserBean;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
    public Map userAuthentication(UserBean user){
        HashMap<String, Object> map = new HashMap<>();
        if (StringUtils.isEmpty(user.getAccount())||StringUtils.isEmpty(user.getPwd())){
            map.put("code",1);
            map.put("msg","参数不可为空");
            return map;
        }
        //只要不是空参数都可以登陆
        map.put("code",0);
        map.put("msg","认证成功");
        return map;
    }
}
