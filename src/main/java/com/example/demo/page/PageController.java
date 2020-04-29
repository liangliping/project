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
     * 跳转首页
     * @return
     */
    @RequestMapping("/index")
    public String toIndex(){
        return "index";
    }
}
