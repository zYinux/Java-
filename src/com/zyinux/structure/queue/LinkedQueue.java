package com.zyinux.structure.queue;

/**
 * @program: JavaStructure
 * @author: zYinux
 * @content: 单链表方式实现的队列
 * @create: 2018-10-25 09:29
 **/
public class LinkedQueue<E> extends ZQueue<E>{


    private class Node<E>{

        E data;

        Node next;

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    Node<E> font,rear;

    int len;

    public LinkedQueue() {
        font=new Node<>(null,null);
        rear=new Node<>(null,null);
    }

    @Override
    protected int getSize() {
        return len;
    }

    @Override
    protected void en(E elem) {
        Node<E> node = new Node<>(elem, null);
        if (font.next==null){
            font.next=node;
            rear.next=node;
        }else {
            rear.next.next=node;
            rear.next=node;
        }
        len++;
    }

    @Override
    protected E de() {
        if (font.next==null){
            throw new RuntimeException("队列为空");
        }

        Node<E> r=font.next;
        font.next=font.next.next;
        len--;
        return r.data;
    }




}
