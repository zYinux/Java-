
import com.zyinux.structure.list.ArrayList;
import org.junit.Assert;
import org.junit.Test;



public class ArrayListTest {

    @Test
    public void addTest(){
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        //System.out.println(list);
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
}
