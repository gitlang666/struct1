package com.example.struct;

import com.example.struct.avl.AVLTree;
import com.example.struct.bst.BSTree;
import com.example.struct.clue.BinaryTree;
import com.example.struct.clue.Node;
import com.example.struct.clue.OrderTree;
import com.example.struct.graph.Graph;
import com.example.struct.graph.Vertex;
import com.example.struct.hash.HashCode;
import com.example.struct.hash.HashTable;
import com.example.struct.hfm.HFMTree;
import com.example.struct.rb.*;
import com.example.struct.recursive.Fibonacci;
import com.example.struct.sort.Sort;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.sound.midi.Soundbank;
import java.text.SimpleDateFormat;
import java.util.*;

public class TreeTest {

    public  static Logger logger= LoggerFactory.getLogger(TreeTest.class);
    @Test
    public void name1() {
        BinaryTree tree=new BinaryTree();
        Node root=new Node(1);
        tree.setRoot(root);
        Node nodeL1=new Node(2);
        Node nodeR1=new Node(3);
        Node nodeL2=new Node(4);
        Node nodeR2=new Node(5);
        Node nodeL3=new Node(6);
        Node nodeR3=new Node(7);
        root.setLeftNode(nodeL1);
        root.setRightNode(nodeR1);
        nodeL1.setLeftNode(nodeL2);
        nodeL1.setRightNode(nodeR2);
        nodeR1.setLeftNode(nodeL3);
        nodeR1.setRightNode(nodeR3);

//        tree.beforeShow();
//        System.out.println("=========");
//        tree.midShow();
//        System.out.println("=========");
//        tree.afterShow();
//        System.out.println("=========");
//        tree.beforeDelete(4);
//        tree.beforeShow();
        tree.midClue2();
        tree.midClueShow();
        System.out.println("================");
        tree.arrayToTree(new int[]{1,2,3,4,5,6,7});
        tree.midClue2();
        tree.midClueShow();
    }

    @Test
    public void name2() {
        int[] arr={1,2,3,4,5,6,7};
        OrderTree tree=new OrderTree(arr);
        tree.beforeShow(0);
    }

    @Test
    public void name3() {
        int[] arr={9,8,4,2,8,6,5,3,7,1};
        Sort.insert(arr);
        System.out.println(Arrays.toString(arr));
    }


    /**
     * 根据指定前缀生成ID
     * @param preStr
     * @return
     */
    public static   String buildId(String preStr){
        if (StringUtils.isEmpty(preStr)){
            logger.error("buildId preStr is error, preStr = " + preStr);
            return null;
        }
        //获取UUID
        String uuid = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
        //生成后缀
        long suffix = Math.abs(uuid.hashCode() % 100000000);
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        String time = sdf.format(new Date(System.currentTimeMillis()));
        //生成前缀
        long prefix = Long.parseLong(time) * 100000000;
        String userId = preStr + String.valueOf(prefix + suffix);
        return userId;
    }
    public static String getUUID(){

        UUID uuid=UUID.randomUUID();

        String uuidStr=uuid.toString();

        return uuidStr;

    }

    @Test
    public void name4() {
        String id=buildId("def");
        System.out.println("id="+id);
        String uuidA=getUUID();
        System.out.println("uuidA="+uuidA);
    }

    @Test
    public void nemahfm(){
        int[] arr=new int[]{5,7,13,17,25,29,4,20};
        HFMTree tree=new HFMTree(arr);
        tree.midShow();
    }

    @Test
    public void namehfmcode() {
        HFMTree tree=new HFMTree();
        String str="Can you can a can as a canner can can a can!";
        byte[] bytes=str.getBytes();
        byte[] resultB=tree.hfmCoding(bytes);
        System.out.println(Arrays.toString(resultB));
        byte[] originalCode=tree.hfmDecoding(resultB,tree.mapCodeTable);
        String originalStr=new String(originalCode);
        System.out.println(originalStr);
    }

    @Test
    public void zipfile() {
        HFMTree tree=new HFMTree();
        tree.zipfile("E:\\sql文件\\dqjs.sql","E:\\sql文件\\dqjs.zip");
    }

    @Test
    public void jyfile() {
        HFMTree tree=new HFMTree();
        tree.jyfile("E:\\sql文件\\dqjs.zip","E:\\sql文件\\tp.sql");
    }

    @Test
    public void bstreeTest()
    {
        com.example.struct.bst.Node node1=new com.example.struct.bst.Node(13);
        BSTree bsTree=new BSTree(node1);
        com.example.struct.bst.Node node2=new com.example.struct.bst.Node(8);
        com.example.struct.bst.Node node3=new com.example.struct.bst.Node(15);
        com.example.struct.bst.Node node4=new com.example.struct.bst.Node(7);
        com.example.struct.bst.Node node5=new com.example.struct.bst.Node(11);
        com.example.struct.bst.Node node6=new com.example.struct.bst.Node(18);
        com.example.struct.bst.Node node7=new com.example.struct.bst.Node(16);
        bsTree.add(node2);
        bsTree.add(node3);
        bsTree.add(node4);
        bsTree.add(node5);
        bsTree.add(node6);
        bsTree.add(node7);
        bsTree.midShow();
        System.out.println("=======================");
        bsTree.imageTree();
        bsTree.midShow();
        System.out.println("=======================");
        bsTree.imageTree1();
        bsTree.midShow();
    }

    @Test
    void avlTest() {
        int[] arr=new int[]{8,5,9,4,6,3};
        int[] arr1=new int[]{8,5,9,4,7,6};
        int[] arr2=new int[]{8,5,9,4,6,7};
        int[] arr3=new int[]{8,7,13,12,15,10};
        int[] arr4=new int[]{8,7,13,11,15,12};
        int[] arr5=new int[]{8,7,13,11,15,18};
        AVLTree tree=new AVLTree();
        for (int i=0;i<arr5.length;i++){
            com.example.struct.avl.Node node=new com.example.struct.avl.Node(arr5[i]);
            tree.add(node);
        }
        System.out.println("height="+tree.getHeight());
        tree.midShow();
        System.out.println("\n=========");
        tree.delete(15);
        System.out.println("height="+tree.getHeight());
        tree.midShow();
        System.out.println();
        tree.show();
        System.out.println("\n=========");
        tree.delete(18);
        System.out.println("height="+tree.getHeight());
        tree.midShow();
        System.out.println("\n=========");
        tree.show();
        tree.depthFristShow();
    }

    @Test
    void rbtest() {
        int[] arr5=new int[]{8,7,13,11,15,18,24,25,26,27,28,29,30,31,32};
        RBTree tree=new RBTree();
        for (int i=0;i<arr5.length;i++){
            RBNode node=new RBNode(arr5[i]);
            tree.add(node);
        }

        tree.bfsShow();
    }

    @Test
    void myrbtest() {
        MyRBTree<Key, Data> myRBTree = new MyRBTree<>();
        int[] arr5=new int[]{8,7,13,11,15,18,24,25,26,27,28,29,30,31,32};
        Key key=null;
        Data data=null;
        for (int i = 0; i < arr5.length; i++) {
            if(i==1){
                key=new Key(arr5[i]);
                data=new Data(""+arr5[i]);
                myRBTree.insert(key,data);
            }else {
                myRBTree.insert(new Key(arr5[i]),new Data(""+arr5[i]));
            }

        }
//        myRBTree.printTreeLevel();
        myRBTree.delete(key);
    }

    @Test
    void testhash() {
        System.out.println(HashCode.hash("langgggggggggggggggggg"));
        System.out.println(108*31+97*31+110*31+103*31);
        HashTable<com.example.struct.hash.Node> hashtable=new HashTable<>();
        int[] arr=new int[]{15,21,23,25,35,45,65,75,12,33,43,11};
        for (int i = 0; i < arr.length; i++) {
            com.example.struct.hash.Node node1=new com.example.struct.hash.Node(arr[i]);
            hashtable.add(node1);
        }
        hashtable.show();
        com.example.struct.hash.Node node=hashtable.get(35);
        hashtable.delete(node);
        hashtable.show();
    }

    @Test
    void testGraph() {
        Vertex v1=new Vertex("A");
        Vertex v2=new Vertex("B");
        Vertex v3=new Vertex("C");
        Vertex v4=new Vertex("D");
        Vertex v5=new Vertex("E");
        Vertex v6=new Vertex("F");
        Vertex v7=new Vertex("G");
        Graph graph=new Graph(7);
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);
        graph.addVertex(v6);
        graph.addVertex(v7);
        graph.add("A","B",5);
        graph.add("A","C",7);
        graph.add("A","G",2);
        graph.add("B","G",3);
        graph.add("B","D",9);
        graph.add("C","E",8);
        graph.add("D","F",4);
        graph.add("E","G",4);
        graph.add("E","F",5);
        graph.add("F","G",6);
        for (int[] i:graph.adMatrix){
            System.out.println(Arrays.toString(i));
        }

//        graph.beradthFirst(0);
//        graph.depthFirst(0);
//        graph.mixPath("A","D");
//        graph.allPath("A","F");
        graph.minTree("A");
    }

    @Test
    void testfibonacci() {
        long s1=System.currentTimeMillis();
        System.out.println(Fibonacci.method2(48));
        long e1=System.currentTimeMillis();
        System.out.println("time="+(e1-s1));
        long s2=System.currentTimeMillis();
        System.out.println(Fibonacci.method1(48));
        long e2=System.currentTimeMillis();
        System.out.println("time="+(e2-s2));
    }


}
