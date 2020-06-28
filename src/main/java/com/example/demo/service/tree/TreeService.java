package com.example.demo.service.tree;

import com.example.demo.pojo.NavBean;

import java.util.List;

/**
 * Description: TreeService <br>
 *
 * @author Mr.Liang
 * Date: 2020/6/22 23:46 <br>
 */
public interface TreeService {
    /**
     * 查询所有树菜单节点
     * @param pId
     * @return
     */
    List<NavBean> getTrees(int pId);
}
