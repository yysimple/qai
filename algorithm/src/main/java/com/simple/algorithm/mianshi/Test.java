package com.simple.algorithm.mianshi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 项目: question-study-improve
 * <p>
 * 功能描述:
 *
 * @author: WuChengXing
 * @create: 2022-11-28 21:39
 **/
public class Test {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Tree {
        private String id;
        private String name;
        private String parentId;
        private List<Tree> children;

        public Tree(String id, String name, String parentId) {
            this.id = id;
            this.name = name;
            this.parentId = parentId;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Test().listWithTree());
    }

    public List<Tree> build() {
        List<Tree> originList = new ArrayList<>();
        List<Tree> tableData = new ArrayList<>();

        originList.add(new Tree("1", "1", ""));
        originList.add(new Tree("2", "2", ""));
        originList.add(new Tree("3", "3", ""));
        originList.add(new Tree("4", "1-1", "1"));
        originList.add(new Tree("5", "2-1", "2"));
        originList.add(new Tree("6", "2-2", "2"));
        originList.add(new Tree("7", "2-2-1", "6"));
        originList.add(new Tree("8", "3-1", "3"));
        originList.add(new Tree("9", "3-1-1", "8"));
        originList.add(new Tree("10", "3-2", "3"));

        tableData.add(new Tree("6", "2-2", "2"));
        tableData.add(new Tree("7", "2-2-1", "6"));
        tableData.add(new Tree("8", "3-1", "3"));
        return originList;
    }


    public List<Tree> listWithTree() {
        List<Tree> tree = build();

        List<Tree> level1Menus = tree.stream()
                .filter(t -> "".equals(t.getParentId()))
                .map((subT) -> {
                    subT.setChildren(getChildren(subT, tree));
                    return subT;
                }).collect(Collectors.toList());
        return level1Menus;
    }

    private List<Tree> getChildren(Tree root, List<Tree> all) {
        List<Tree> children = all.stream().
                filter(categoryEntity -> categoryEntity.getParentId().equals(root.getId()))
                .map(t -> {
                    // 找到子菜单
                    t.setChildren(getChildren(t, all));
                    return t;
                }).collect(Collectors.toList());
        return children;
    }
}
