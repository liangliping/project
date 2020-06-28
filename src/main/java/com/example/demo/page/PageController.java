package com.example.demo.page;

import com.example.demo.pojo.UserBean;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Description: PageController <br>
 * 跳转页面
 *
 * @author Liang lp
 * Date: 2020/4/29 10:32 <br>
 */

@Controller
@RequestMapping("/page")
public class PageController {

    /**
     * index页面为默认页面 所以不用跳转 其他页面则需要在这里设置跳转
     * @return
     */

    /**
     * 跳转登录页面
     * @return
     */
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "/login";
    }


    @RequestMapping("/toShow")
    public String toShow(HttpServletResponse response, Model model){
        Subject subject = SecurityUtils.getSubject();
        UserBean user = (UserBean)subject.getPrincipal();
        try {
            if (null == user){
                //登陆过期，转发重新登陆
                response.sendRedirect("/toLogin");
                return null;
            }else {
                model.addAttribute("account", user.getAccount());
                return "/show";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
