
import com.zyinux.structure.list.ArrayList;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;


public class ArrayListTest {

    @Test
    public void createTest(){
        ArrayList<Integer> list=new ArrayList<>(0);
        list.add(10);
        Assert.assertEquals((int)list.get(0),10);
    }

    @Test
    public void addTest(){
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        //System.out.println(list);
    }

    @Test
    public void addIndexTest(){
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        list.add(99,300);
        Assert.assertEquals(list.size(),101);
    }

    @Test
    public void isEmptyTest(){
        ArrayList list=new ArrayList();
        list.add(1);
        Assert.assertEquals(list.isEmpty(),false);
    }

    @Test
    public void indexOfTest(){
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        Assert.assertEquals(list.indexOf(null),-1);
    }

    @Test
    public void lastIndexOfTest(){
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }

        System.out.println(list.lastIndexOf(800));
    }

    @Test
    public void removeIndexTest(){
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        list.remove(3);
        System.out.println(list.toString());
        Assert.assertEquals(list.size(),9);
    }

    @Test
    public void removeObjectTest(){
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.remove(list.get(9));
        Assert.assertEquals(list.size(),9);
    }


}
