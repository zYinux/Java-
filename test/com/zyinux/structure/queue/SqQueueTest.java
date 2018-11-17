package com.zyinux.structure.queue;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @program: JavaStructure
 * @author: zYinux
 * @content:
 * @create: 2018-10-25 09:24
 **/
public class SqQueueTest {

    @Test
    public void test(){
        SqQueue<String> queue=new SqQueue<>(5);
        queue.en("1");
        queue.en("2");
        queue.en("3");
        queue.en("4");

        System.out.println(queue.de());
        queue.en("5");
        assert queue.getSize()==4;
    }

}