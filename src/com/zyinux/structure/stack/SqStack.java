package com.zyinux.structure.stack;

/**
 * @program: JavaStructure
 * @author: zYinux
 * @content: 以顺序表（数组）实现的栈
 * @create: 2018-10-24 17:17
 **/
public class SqStack<E> {

    private int size = 20;

    Object stack[];

    private int top=-1;

    public SqStack(int SIZE) {
        this.size = SIZE;
        stack=new Object[size];
    }

    public SqStack() {
        this(20);
    }

    public void push(E elem){
        if (top>=size-1){
            throw new IndexOutOfBoundsException("栈溢出");
        }
        top++;
        stack[top]=elem;
    }

    public E pop(){
        if (top==-1){
            throw new IndexOutOfBoundsException("空栈无法取出数据");
        }
        return (E) stack[top--];
    }
}
