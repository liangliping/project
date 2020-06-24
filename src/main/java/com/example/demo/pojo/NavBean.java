package com.example.demo.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * Description: NavBean <br>
 *
 * @author Mr.Liang
 * Date: 2020/6/22 23:43 <br>
 */
public class NavBean implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Integer id;

    /**
     * 节点名称
     */
    private String text;

    /**
     * 父节点
     */
    private Integer pid;

    /**
     * //路径
     */
    private String path;

    /**
     * //是否有子节点
     */
    private boolean selectable;

    private List<NavBean> nodes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isSelectable() {
        return selectable;
    }

    public void setSelectable(boolean selectable) {
        this.selectable = selectable;
    }

    public List<NavBean> getNodes() {
        return nodes;
    }

    public void setNodes(List<NavBean> nodes) {
        this.nodes = nodes;
    }

    public NavBean(Integer id, String text, Integer pid, String path) {
        this.id = id;
        this.text = text;
        this.pid = pid;
        this.path = path;
    }

    @Override
    public String toString() {
        return "NavBean{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", pid=" + pid +
                ", path='" + path + '\'' +
                ", selectable=" + selectable +
                ", nodes=" + nodes +
                '}';
    }
}
