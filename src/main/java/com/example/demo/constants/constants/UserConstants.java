package com.example.demo.constants.constants;

import com.example.demo.pojo.UserBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: UserConstants <br>
 *
 * @author Mr.Liang
 * Date: 2020/6/22 17:53 <br>
 */
public class UserConstants {
    //用户注册信息
    private static UserBean user1 = new UserBean(1, "superHe", "18311156750", "2bdfc2fb0b891171ed8a0cd1aa99ca95");
    private static UserBean user2 = new UserBean(2, "superLiang", "18903100844", "0cdaa36b745dc1e4243bf7b40fb79244");

    //用户注册集合
    private static List<UserBean> list = new ArrayList<UserBean>();

    static {
        list.add(user1);
        list.add(user2);
    }

    //会员集合
    public static List<UserBean> getUserBean(){
        return list;
    }
    //根据会员账号获取对象
    public static UserBean getUserBeanByAccount(String account){
        for (UserBean bean : list) {
            if (bean.getAccount().equals(account)){
                return bean;
            }
        }
        return null;
    }
    //根据会员id获取对象
    public static UserBean getUserBeanById(int id){
        for (UserBean bean : list) {
            if (bean.getId() == id){
                return bean;
            }
        }
        return null;
    }
}
