package tree;

import com.zyinux.structure.tree.Trie;
import org.junit.Assert;
import org.junit.Test;

/**
 * @program: JavaStructure
 * @author: zYinux
 * @content:
 * @create: 2018-07-12 11:12
 **/
public class TrieTest {

    Trie trie;

    @Test
    public void insertTest(){

    }

    @Test
    public void starsWithTest(){
        trie=new Trie();
        trie.insert("zyinux");
        trie.insert("zyinuz");
        trie.insert("againstsky");
        Assert.assertEquals(trie.startsWith("zyinuxz"),true);
    }

    @Test
    public void searchTest(){
        trie=new Trie();
        trie.insert("zyinux");
        trie.insert("zyinuz");
        trie.insert("againstsky");
        Assert.assertEquals(trie.search("againstsky"),true);
    }
}
