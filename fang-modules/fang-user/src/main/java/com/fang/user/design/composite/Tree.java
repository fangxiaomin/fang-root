package com.fang.user.design.composite;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;

/**
 * @description:
 * @projectName:fang-root
 * @see:com.fang.user.design.composite
 * @author:fxm
 * @createTime:2021/8/31 15:39
 * @version:1.0
 */
public class Tree {
    TreeNode root = null;

    public Tree(String name) {
        root = new TreeNode(name);
    }


    public static void main(String[] args) {
        Tree tree = new Tree("A");

        TreeNode treeNode2 = new TreeNode("B");
        TreeNode treeNode3 = new TreeNode("c");

        treeNode2.add(treeNode3);
        tree.root.add(treeNode2);

        System.out.println(tree.root.getChildren());

    }
}
