package com.zyinux.structure.stack;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @program: JavaStructure
 * @author: zYinux
 * @content:
 * @create: 2018-10-24 19:46
 **/
public class ShareDateStackTest {

    @Test
    public void test(){
        ShareDateStack stack=new ShareDateStack(20);

        for (int i = 0; i < 20; i++) {
            if (i<=13){
                stack.push(i,ShareDateStack.LEFT_STACK);
            }else {
                stack.push(i,ShareDateStack.RIGHT_STACK);
            }
        }
        for (int i = 0; i < 20; i++) {
            if (i<=13){
                System.out.println(stack.pop(ShareDateStack.LEFT_STACK));
            }else {
                System.out.println(stack.pop(ShareDateStack.RIGHT_STACK));
            }
        }
    }
}