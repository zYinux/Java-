import com.zyinux.structure.list.SingleLinkList;
import org.junit.Assert;
import org.junit.Test;

public class SingelLinkListTest {

    @Test
    public void getFirstTest(){
        SingleLinkList<String> linkList=new SingleLinkList<>();
        linkList.addFirst("First");
        Assert.assertEquals(linkList.element(),"First");
    }

    @Test
    public void getLastTest(){
        SingleLinkList<String> linkList=new SingleLinkList<>();
        for (int i = 0; i < 100; i++) {
            linkList.addFirst(i+"");
        }
        System.out.println(linkList);
        Assert.assertEquals(linkList.getLast(),"0");
    }

    @Test
    public void addLastTest(){
        SingleLinkList<String> linkList=new SingleLinkList<>();
        for (int i = 0; i < 100; i++) {
            linkList.addLast(i+"");
        }
        System.out.println(linkList);
    }


    @Test
    public void removeFirstTest(){
        SingleLinkList<String> linkList=new SingleLinkList<>();
        for (int i = 0; i < 100; i++) {
            linkList.addFirst(i+"");
        }
        System.out.println(linkList);
        Assert.assertEquals(linkList.removeFirst(),"99");
        Assert.assertEquals(linkList.removeFirst(),"98");
        Assert.assertEquals(linkList.size(),98);
    }


    @Test
    public void removeLastTest(){
        SingleLinkList<String> linkList=new SingleLinkList<>();
        for (int i = 0; i < 100; i++) {
            linkList.addFirst(i+"");
        }
        Assert.assertEquals(linkList.removeLast(),"0");
        System.out.println(linkList);
        Assert.assertEquals(linkList.removeLast(),"1");
        System.out.println(linkList);
        Assert.assertEquals(linkList.size(),98);
    }
}
