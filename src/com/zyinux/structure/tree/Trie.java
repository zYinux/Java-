package com.zyinux.structure.tree;

import java.util.HashMap;

/**
 * @program: JavaStructure
 * @author: zYinux
 * @content:
 * @create: 2018-07-12 11:04
 **/
public class Trie {


    private HashMap<Character,Trie> tree;

    private boolean isWord=false;

    /** Initialize your data structure here. */
    public Trie() {
        tree=new HashMap<>();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word==null||word.isEmpty()){
            return;
        }
        Trie node=this;
        word=word.toLowerCase();
        char[] chars=word.toCharArray();
        for (int i=0;i<chars.length;i++){
            char c=chars[i];
            if(!node.tree.containsKey(c)){
                node.tree.put(c,new Trie());
            }

            if (i==word.length()-1){
                node.isWord=true;
            }
            node=node.tree.get(c);

        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word==null||word.isEmpty()){
            return false;
        }
        Trie node=this;
        word=word.toLowerCase();
        char[] chars=word.toCharArray();
        for (int i=0;i<chars.length;i++){
            char c=chars[i];
            if (node.tree.containsKey(c)&&node.tree.get(c)!=null){
                if (i==word.length()-1&&!node.isWord){
                    return false;
                }
                node=node.tree.get(c);
            }else{
                return false;
            }
        }

        return true;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix==null||prefix.isEmpty()){
            return false;
        }
        Trie node=this;
        prefix=prefix.toLowerCase();
        char[] chars=prefix.toCharArray();
        for (int i=0;i<chars.length;i++){
            char c=chars[i];
            if (node.tree.containsKey(c)&&node.tree.get(c)!=null){
                node=node.tree.get(c);
            }else{
                return false;
            }
        }
        return true;
    }
}
