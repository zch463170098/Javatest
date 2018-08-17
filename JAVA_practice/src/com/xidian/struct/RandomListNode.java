package com.xidian.struct;


// 与剑指offer上面不同，这里需要将变量设置为public 才可以被调用
public class RandomListNode {
    public int label;
    public RandomListNode next = null;
    public RandomListNode random = null;

    public RandomListNode(int label) {
        this.label = label;
    }
}
