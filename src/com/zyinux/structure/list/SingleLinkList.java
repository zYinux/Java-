package com.zyinux.structure.list;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * 单向链表
 * zYinux
 * @param <E>
 */
public class SingleLinkList<E> extends AbstractSequentialList<E> implements List<E>,Queue<E> {

    public static final int MAX_SIZE=Integer.MAX_VALUE-8;

    //单链表头结点
    Node head;

    //单链表尾节点，该节点可以不实现，这里实现它是为了对尾节点做操作时不需要遍历整个链表
    Node last;

    int size;

    public SingleLinkList(){
        head=new Node<>(null,null);
        last=null;
        size=0;
    }

    public void addFirst(E e){
        if (head.next==null){
            head.next = last = new Node<>(e,null);
        }else head.next = new Node<>(e, head.next);
        size++;
    }

    /**
     * 实现last Node来保存最后一个节点
     * @param e
     */
    public void addLast(E e){
        if (last==null){
            head.next=last=new Node<>(e,null);
        }else {
            Node<E> p=new Node<>(e,null);
            last.next=p;
            last=p;
        }
        size++;
    }

    public E removeFirst(){
        checkFirst();
        Node<E> p=head.next;
        head.next=p.next;
        size--;
        return p.data;
    }

    public E removeLast(){
        checkLast();
        Node<E> p=head;
        while (p.next!=last){
            if (p.next==null){
                throw new NoSuchElementException("LinkList is empty");
            }
            p=p.next;
        }
        p.next=null;
        E e= (E) last.data;
        last=p;
        size--;
        return e;
    }

    public void deleteElement(E e){

    }

    private void checkFirst(){
        if (head.next==null){
            throw new NoSuchElementException("First:null");
        }
    }

    private void checkLast(){
        if (last==null){
            throw new NoSuchElementException("last:null");
        }
    }

//    /**
//     * 这里假设没有实现last Node来保存最后一个节点的情况
//     * @param e
//     */
//    public void addLast(E e){
//        Node<E> p=head;
//        while (p.next!=null){
//            p=p.next;
//        }
//        p.next=new Node<>(e,null);
//        size++;
//    }

    public E getFirst(){
        checkFirst();
        Node<E> f=head.next;
        return f.data;
    }

    public E getLast(){
        checkLast();
        return (E) last.data;
    }



    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }



    @Override
    public boolean offer(E e) {
        return false;
    }

    @Override
    public E remove() {
        return removeFirst();
    }

    @Override
    public E poll() {
        return null;
    }

    @Override
    public E element() {
        return getFirst();
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }



    private class Node<E>{
        E data;
        Node next;

        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
    }


    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder("[");
        Node<E> p=head;
        while (p.next!=null){
            p=p.next;
            sb.append(" "+p.data+" ,");
        }
        sb.append("]");
        return sb.toString();
    }
}
