package com.example.demo.controller.user;

import com.example.demo.constants.constants.UserConstants;
import com.example.demo.pojo.UserBean;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Description: UserController <br>
 *
 * @author Mr.Liang
 * Date: 2020/6/30 15:32 <br>
 */
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * @创建人 Mr.Liang
     * @描述 //TODO 查询所有用户列表
     * @创建时间 2020/6/30
     **/
    @ApiOperation(value = "查询所有用户列表", notes = "查询所有用户列表")
    @RequestMapping(value = "/queryUserList", method = RequestMethod.GET)
    public List<UserBean> queryUserList() {

        List<UserBean> list = UserConstants.getUserBean();
        return list;
    }

    /**
     * @创建人 Mr.Liang
     * @描述 //TODO 根据id查询用户信息
     * @创建时间 2020/6/30
     **/
    @ApiOperation(value = "根据id查询用户信息", notes = "根据id查询用户信息")
    @RequestMapping(value = "/queryUserById", method = RequestMethod.GET)
    public UserBean queryUserById(@ApiParam(name = "id", value = "用户id", required = true) int id) {
        UserBean user = UserConstants.getUserBeanById(id);
        return user;
    }
}
