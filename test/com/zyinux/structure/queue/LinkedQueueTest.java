package com.zyinux.structure.queue;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @program: JavaStructure
 * @author: zYinux
 * @content:
 * @create: 2018-10-25 09:46
 **/
public class LinkedQueueTest {

    @Test
    public void test(){
        LinkedQueue<String> queue=new LinkedQueue<>();

        queue.en("a");
        queue.en("b");
        queue.en("c");

        queue.en("a");
        queue.en("b");
        queue.en("c");

        queue.en("a");
        queue.en("b");
        queue.en("c");
        while (queue.getSize()>0){
            System.out.println(queue.de());
        }
    }

}