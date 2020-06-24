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

    /**
     * //父节点数据结构
     */
    private static final NavBean N1 = new NavBean(1, "核弹实验室", 0, "");
    private static final NavBean N2 = new NavBean(2, "氢弹实验室", 0, "");
    private static final NavBean N3 = new NavBean(3, "原子弹实验室", 0, "");

    /**
     * //子节点结构
     */
    private static final NavBean N10 = new NavBean(10, "核弹实验室1", 1, "#");
    private static final NavBean N11 = new NavBean(11, "核弹实验室2", 1, "#");
    private static final NavBean N20 = new NavBean(20, "氢弹实验室1", 2, "#");
    private static final NavBean N21 = new NavBean(21, "氢弹实验室2", 2, "#");
    private static final NavBean N30 = new NavBean(30, "原子弹实验室1", 3, "#");
    private static final NavBean N31 = new NavBean(31, "原子弹实验室2", 3, "#");

    /**
     * //孙子节点结构（暂无孙子节点）
     */


    /**
     * //节点集合
     */
    private static List<NavBean> trees = new ArrayList<>();

    static {
        trees.add(N1);
        trees.add(N2);
        trees.add(N3);
        trees.add(N10);
        trees.add(N11);
        trees.add(N20);
        trees.add(N21);
        trees.add(N30);
        trees.add(N31);
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
