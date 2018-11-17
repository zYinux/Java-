package com.zyinux.structure.list;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;

public class ArrayList<E> extends AbstractList<E> implements Serializable,
        List<E>,RandomAccess
{

    private static final long serialVersionUID = 268345258112289218L;

    //默认的初始表长度
    private static final int DEFAULT_SIZE=500;

    //表的最大容量
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    private Object[] elements;

    private int length;//表的容量

    private int current;//实际表长



    /**
     * 创建
     */
    public ArrayList() {
        this.length=DEFAULT_SIZE;
        this.elements=new Object[length];
        this.current=0;
    }

    /**
     * 创建
     * @param length 自定义表的容量
     */
    public ArrayList(int length){
        if (length<0){
            throw new IllegalArgumentException("长度不能小于0");
        }
        this.length = length;
        this.current=0;
        this.elements=new Object[length];
    }


    /**
     * 获取指定位置的数据
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        rangeCheck(index);
        if (index>current-1) {
            throw new ArrayIndexOutOfBoundsException("siez:"+size()+" index:"+index);
        }
        return elementData(index);
    }

    @Override
    public int size() {
        return current;
    }

    @Override
    public boolean add(E e) {

        //检查插入新元素是否超出数组的容量
        ensureCapacityInternal(current + 1);
        elements[current]=e;
        current+=1;
        return true;
    }


    @Override
    public void add(int index, E element) {

        if (index>current||index<0){
            throw new IllegalArgumentException();
        }
        ensureCapacityInternal(current+1);

        System.arraycopy(elements,index,elements,index+1,current-index);

        elements[index]=element;

        current++;


    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        E oldElement= (E) elements[index];
        int moveNum=current-index-1;
        if (moveNum>0){
            System.arraycopy(elements,index+1,elements,index,moveNum);
        }
        elements[--current]=null;
        return oldElement;

    }

    private void fastRemove(int index){
        rangeCheck(index);
        int moveNum=current-index-1;
        if (moveNum>0){
            System.arraycopy(elements,index+1,elements,index,moveNum);
        }
        elements[--current]=null;
    }

    @Override
    public boolean remove(Object o) {
        int pos = indexOf(o);
        if (pos == -1){
            return false;
        }
        fastRemove(pos);
        return true;
    }

    /**
     * 这里实现的时候遇到了个问题，参考了jdk中ArrayList的写法
     * @param o
     * @return
     */
    @Override
    public int indexOf(Object o) {
        if (o==null){
            for (int i = 0; i < current; i++) {
                if (elements[i]==null)
                    return i;
            }
        }else {
            for (int i = 0; i < current; i++) {
                if (o.equals(elements[i])){
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o==null){
            for (int i = current-1 ; i >= 0 ; i--){
                if (elements[i]==null){
                    return i;
                }
            }
        }else {
            for (int i = current-1 ; i >= 0 ; i--){
                if (o.equals(elements[i])){
                    return i;
                }
            }
        }

        return -1;
    }

    /**
     *
     * @param o
     * @return 列表中与指定元素相同的所有元素所在的位置
     */
    public List<Integer> allIndexOf(Object o){
        List<Integer> indexs=new ArrayList<>();
        for (int i = 0; i < current; i++) {
            if (elements[i].equals(o)){
                indexs.add(i);
            }
        }
        return indexs;
    }


    @Override
    public boolean isEmpty() {
        return current==0;
    }

    public void clear(){
        length=DEFAULT_SIZE;
        elements=new Object[length];
        current=0;
    }


    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elements,current);
    }

    private void ensureCapacityInternal(int minCapacity){
        if (minCapacity>=length-30){
            grow(minCapacity);
        }
    }


    /**
     * 重新计算新的数组大小，并用Arrays.copy方法将数据拷贝到新生成的数组中
     * @param minCapacity
     */
    private void grow(int minCapacity) {
        int oldCapacity=elements.length;
        int newCapacity=oldCapacity+(oldCapacity>>1);

        if (newCapacity<minCapacity){
            newCapacity=minCapacity;
        }
        if (newCapacity-MAX_ARRAY_SIZE>0){
            //如果计算出的新容量大于最大数组容量，则设为最大容量
            newCapacity=hugeCapacity(newCapacity);
        }
        //System.out.println("newCapacity:"+newCapacity);
        elements= Arrays.copyOf(elements,newCapacity);
        length=elements.length;
    }

    private static int hugeCapacity(int minCapacity){
        if (minCapacity<0){
            throw new IllegalArgumentException();
        }
        return minCapacity>MAX_ARRAY_SIZE?Integer.MAX_VALUE:MAX_ARRAY_SIZE;
    }


    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder("[");
        for (int i = 0; i < current; i++) {
            sb.append(elements[i]);
            if (i!=current-1){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }



    private void rangeCheck(int index){
        if (index<0){
            throw new IllegalArgumentException("访问位置不能小于0");
        }
        if (index>current){
            throw new IndexOutOfBoundsException("index:"+index+" size:"+current);
        }
    }

    private E elementData(int index){
        return (E)elements[index];
    }


}
