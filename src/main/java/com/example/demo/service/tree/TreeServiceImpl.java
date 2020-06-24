package com.example.demo.service.tree;

import com.example.demo.constants.constants.TreeConstants;
import com.example.demo.pojo.NavBean;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description: TreeServiceImpl <br>
 *
 * @author Mr.Liang
 * Date: 2020/6/22 23:46 <br>
 */
@Service
public class TreeServiceImpl implements TreeService {

    /**
     * 查询所有树节点
     * @param id
     * @return
     */
    @Override
    public List<NavBean> getTrees(int id) {

        return findeTreeNode(id);
    }

    /**
     *  // 递归查询
     * @param pid
     * @return
     */
    private List<NavBean> findeTreeNode(Integer pid) {
        List<NavBean> trees = TreeConstants.getTreesAll(pid);
        for (NavBean nav : trees) {
            // 自己调用自己 传自己的id
            List<NavBean> findeTreeNode = findeTreeNode(nav.getId());
            if (findeTreeNode != null && findeTreeNode.size() > 0) {
                // 查完set到自己名下
                nav.setNodes(findeTreeNode);
            } else {
                nav.setSelectable(true);
            }
        }
        return trees;
    }

}
