package com.example.demo.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String toShow(){
        return "/show";
    }
}
