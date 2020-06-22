package com.example.demo.controller.tree;


import com.example.demo.controller.login.LoginController;
import com.example.demo.pojo.NavBean;
import com.example.demo.service.TreeService.TreeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Description: TreeController <br>
 *
 * @author Mr.Liang
 * Date: 2020/6/22 23:38 <br>
 */
@Api(tags = "菜单树")
@Controller
@RequestMapping("/tree")
public class TreeController {

    @Autowired
    private TreeService treeService;

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @ApiOperation(value="获取导航树菜单", notes="获取导航树菜单")
    @RequestMapping(value = "/getTrees",method = RequestMethod.POST)
    @ResponseBody
    public List<NavBean> getTrees() {
        //首次查询查出所有节点
        return treeService.getTrees(0);
    }
}
