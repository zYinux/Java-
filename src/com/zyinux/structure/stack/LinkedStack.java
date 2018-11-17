package com.zyinux.structure.stack;

/**
 * @program: JavaStructure
 * @author: zYinux
 * @content: 以链表的方式存储的栈
 * @create: 2018-10-24 19:53
 **/
public class LinkedStack<E> {

    private class Node<E>{

        E data;

        Node next;

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    int len=0;

    Node header=null;

    public LinkedStack() {
        header=new Node(null,null);
    }

    public void push(E elem){
        Node<E> next=new Node<>(elem,null);
        if (header.next==null){
            header.next=next;
        }else {
            next.next=header.next;
            header.next=next;
        }
        len++;
    }

    public int size(){
        return len;
    }

    public E pop(){
        if (header.next==null){
            throw new RuntimeException("空栈");
        }
        len--;
        Node r=header.next;
        header.next=r.next;
        return (E) r.data;
    }
}
