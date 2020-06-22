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
    //用户注册信息 需要字段可自行添加
    private static UserBean user1 = new UserBean(1, "superHe", "22a43fbe3267faa448639dad376737ae", "18311156750");
    private static UserBean user2 = new UserBean(2, "superLiang", "82168999052d2ed053392d3bb65492dd", "18903100844");

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
