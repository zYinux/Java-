package com.zyinux.structure.queue;

/**
 * @program: JavaStructure
 * @author: zYinux
 * @content: 顺序存储的循环队列,由于空出一个位置来进行满队列判断，所以当实际存储数据量为size-1
 * @create: 2018-10-25 09:14
 **/
public class SqQueue<E> extends ZQueue<E> {

    private int len;

    private Object[] queue;

    private int size;

    private int font=0,rear=0;

    public SqQueue(int size) {
        this.size = size;
        queue=new Object[this.size];
    }

    @Override
    public void en(E elem){
        if ((rear+1)%size==font){
            throw new RuntimeException("队列已满");
        }
        queue[rear]=elem;
        rear=(rear+1)%size;
        len++;
    }

    @Override
    public int getSize(){
        return len;
    }

    @Override
    public E de(){
        if (rear==font){
            throw new RuntimeException("队列为空");
        }

        E r= (E) queue[font];
        font=(font+1)%size;
        len--;
        return r;

    }
}
