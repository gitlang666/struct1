package com.example.struct;

import com.example.struct.bst.BSTree;
import com.example.struct.bst.Node;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StructApplicationTests {

    @Test
    void contextLoads() {
        int[] arr=new int[]{3,9,10,8,12,1,5,4,11,13};
        BSTree bsTree=new BSTree(new Node(7));
        for(int i:arr){
            bsTree.add(new Node(i));
        }

        bsTree.midShow();
        Node node=bsTree.select(5);
        if(node!=null){
            System.out.println("node.value="+node.value);
        }
        System.out.println("===============");
        bsTree.delete(12);
        bsTree.midShow();
    }

}
