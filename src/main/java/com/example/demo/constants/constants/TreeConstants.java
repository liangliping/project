package com.example.demo.constants.constants;

import com.example.demo.pojo.NavBean;
import com.example.demo.pojo.UserBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: TreeConstants <br>
 *
 * @author Mr.Liang
 * Date: 2020/6/22 23:48 <br>
 */
public class TreeConstants {

    //父节点数据结构
    private static final NavBean n1 = new NavBean(1, "核弹实验室", 0, "");
    private static final NavBean n2 = new NavBean(2, "氢弹实验室", 0, "");
    private static final NavBean n3 = new NavBean(3, "原子弹实验室", 0, "");

    //子节点结构
    private static final NavBean n10 = new NavBean(10, "核弹实验室1", 1, "#");
    private static final NavBean n11 = new NavBean(11, "核弹实验室2", 1, "#");
    private static final NavBean n20 = new NavBean(20, "氢弹实验室1", 2, "#");
    private static final NavBean n21 = new NavBean(21, "氢弹实验室2", 2, "#");
    private static final NavBean n30 = new NavBean(30, "原子弹实验室1", 3, "#");
    private static final NavBean n31 = new NavBean(31, "原子弹实验室2", 3, "#");

    //孙子节点结构（暂无孙子节点）


    //节点集合
    private static List<NavBean> trees = new ArrayList<>();

    static {
        trees.add(n1);
        trees.add(n2);
        trees.add(n3);
        trees.add(n10);
        trees.add(n11);
        trees.add(n20);
        trees.add(n21);
        trees.add(n30);
        trees.add(n31);
    }

    public static List<NavBean> getTreesAll(int pid) {
        List<NavBean> s = new ArrayList<>();
        for (NavBean tree : trees) {
            if (tree.getPid() == pid){
                s.add(tree);
            }
        }
        return s;
    }
}
