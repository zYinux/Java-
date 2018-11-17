package com.zyinux.structure.stack;

/**
 * @program: JavaStructure
 * @author: zYinux
 * @content: 两个共享同一段空间的栈
 * @create: 2018-10-24 19:35
 **/
public class ShareDateStack<E> {

    public static final int LEFT_STACK=1,RIGHT_STACK=2;

    private int size;

    Object stack[];

    int topl=-1,topr;//左边的栈的栈顶和右边栈的栈顶

    public ShareDateStack(int size) {
        this.size = size;
        topr=size;
        stack=new Object[this.size];
    }

    public ShareDateStack() {
        this(20);
    }

    public void push(E elem,int type){
        if (topl>=size-1||topr<=0||topl+1==topr){
            throw new IndexOutOfBoundsException("栈溢出");
        }
        if (type==LEFT_STACK){
            topl++;
            stack[topl]=elem;
        }else {
            topr--;
            stack[topr]=elem;
        }
    }

    public E pop(int type){
        if (type==LEFT_STACK){
            if (topl==-1){
                throw new IndexOutOfBoundsException("空栈无法取出数据,栈:"+type);
            }

            return (E) stack[topl--];

        }else {
            if (topr==size){
                throw new IndexOutOfBoundsException("空栈无法取出数据,栈:"+type);
            }
            return (E) stack[topr++];
        }
    }
}
