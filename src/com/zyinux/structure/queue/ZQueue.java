package com.zyinux.structure.queue;

/**
 * @program: JavaStructure
 * @author: zYinux
 * @content:
 * @create: 2018-10-25 09:19
 **/
public abstract class ZQueue<E> {

    protected abstract int getSize();

    protected abstract void en(E elem);

    protected abstract E de();

}
