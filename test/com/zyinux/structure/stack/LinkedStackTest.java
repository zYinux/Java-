package com.zyinux.structure.stack;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @program: JavaStructure
 * @author: zYinux
 * @content:
 * @create: 2018-10-24 20:00
 **/
public class LinkedStackTest {

    @Test
    public void test(){
        LinkedStack stack=new LinkedStack();

        for (int i = 0; i < 20; i++) {
            stack.push(i);
        }
        for (int i = 0; i < 20; i++) {
            System.out.println(stack.pop());
        }
    }

}