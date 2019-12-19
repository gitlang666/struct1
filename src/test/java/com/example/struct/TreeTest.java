package com.example.struct;

import com.example.struct.clue.BinaryTree;
import com.example.struct.clue.Node;
import com.example.struct.clue.OrderTree;
import com.example.struct.hfm.HFMTree;
import com.example.struct.sort.Sort;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

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
        HFMTree.quick(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
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
        tree.zipfile("D:\\dqjsfile\\pdf\\timg.jpg","D:\\dqjsfile\\pdf\\tp.zip");
    }

    @Test
    public void jyfile() {
        HFMTree tree=new HFMTree();
        tree.jyfile("D:\\dqjsfile\\pdf\\tp.zip","D:\\dqjsfile\\pdf\\tp.jpg");
    }
}
