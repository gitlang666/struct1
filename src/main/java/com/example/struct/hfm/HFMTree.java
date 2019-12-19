package com.example.struct.hfm;

import java.io.*;
import java.util.*;

public class HFMTree {
    public HFMNode root;

    public HFMTree(int[] arr) {
        this.root = HFMNode1(arr);
    }

    public HFMTree(){

    }

    private static HFMNode HFMNode1(int[] arr){
        if(arr.length==0){
            return null;
        }
        List<HFMNode> list=new ArrayList<>();
        for (int i=0;i<arr.length;i++){
            HFMNode node=new HFMNode(arr[i],new Byte(i+""));
            list.add(node);
        }
        for (;list.size()>1;){
            list.sort(HFMNode::compareTo);
            int weights=list.get(0).weights+list.get(1).weights;
            HFMNode hfmNode=new HFMNode(weights,null);
            hfmNode.leftNode=list.get(0);
            hfmNode.rightNode=list.get(1);
            list.remove(hfmNode.leftNode);
            list.remove(hfmNode.rightNode);
            list.add(hfmNode);
        }
        return list.get(0);
    }

    public void midShow(){
        root.midShow(root);
    }

    public byte[] hfmCoding(byte[] bytes){
        String coding="";
        //将数据统计
        Map<Byte,Integer> map=getMapCoding(bytes);
        //处理统计的数据
        HFMNode hfmNode=initHFMNode(map);
        this.root=hfmNode;
        //得到编码表,左节点0，右节点1
        getCodeTable(hfmNode);
        //编码
        coding=strToCode(bytes);
        //得到byte数组的编码
        byte[] resultB=getResultB(coding);
        return resultB;
    }


    public byte[] hfmDecoding(byte[] bytes,Map<Byte,String> map){
        byte[] originalCode=null;
        Map<String,Byte> deCodeMap=getDeCodeTable(map);
        //处理编码后的byte[]得到原始编码string
        String originalStr=getOriginalCode(bytes);
        //解码数据
        originalCode=getOriginalByte(originalStr,deCodeMap);
        return originalCode;
    }

    private byte[] getOriginalByte(String originalStr, Map<String,Byte> map) {
        List<Byte> list=new ArrayList<>();
        for (int i=0;i<originalStr.length();){
            int count=1;
            String str=originalStr.substring(i,i+count);
            while (map.get(str)==null){
                count+=1;
                try {
                    str=originalStr.substring(i,i+count);
                }catch (StringIndexOutOfBoundsException e){
                    System.out.println("索引出错");
                    System.exit(-1);
                }

            }
            list.add(map.get(str));
            i+=count;
        }
        byte[] bytes=new byte[list.size()];
        for(int i=0;i<list.size();i++){
            bytes[i]=list.get(i);
        }
        return bytes;
    }

    private String getOriginalCode(byte[] bytes) {
        StringBuilder stringBuilder=new StringBuilder();
        for (int i=0;i<bytes.length;i++){
            int b=bytes[i] ;
            String var;
            if(i!=bytes.length-1){
                b |=256;
                var=Integer.toBinaryString(b);
                var=var.substring(var.length()-8);
            }else {
                var=Integer.toBinaryString(b);
                if(b<0){
                    var=var.substring(var.length()-8);
                }

            }

            stringBuilder.append(var);
        }
        return stringBuilder.toString();
    }

    private Map<String, Byte> getDeCodeTable(Map<Byte, String> map) {
        Map<String,Byte> deCodeMap=new HashMap<>();
        for (Map.Entry entry:map.entrySet()){
            deCodeMap.put(entry.getValue().toString(),(Byte) entry.getKey());
        }
        return deCodeMap;
    }

    private byte[] getResultB(String coding) {
        int len=0;
        if(coding.length()%8==0){
            len= coding.length()/8;
        }else {
            len = coding.length()/8+1;
        }
        byte[] resultB=new byte[len];;
        for (int i=0;i<resultB.length;i++){
            String s=new String();
            if(i==resultB.length-1){
                s=coding.substring(i*8);
            }else {
                s=coding.substring(i*8,(i+1)*8);
            }
            resultB[i]=(byte) Integer.parseInt(s,2);
        }
        return resultB;
    }

    private String strToCode(byte[] bytes) {
        StringBuilder coding=new StringBuilder("");
        for (byte b:bytes){
            coding.append(mapCodeTable.get(new Byte(b)));
        }
        return coding.toString();
    }

   public Map<Byte,String> mapCodeTable=new HashMap<>();
    StringBuilder sb=new StringBuilder();
    private Map<Byte, String> getCodeTable(HFMNode hfmNode) {
        if (hfmNode==null){
            return null;
        }

        getCodeTable(hfmNode.leftNode,"0",sb);
        getCodeTable(hfmNode.rightNode,"1",sb);

        return mapCodeTable;
    }

    public void getCodeTable(HFMNode node,String code,StringBuilder stringBuilder){
        StringBuilder stringBuilder1=new StringBuilder(stringBuilder);
        stringBuilder1.append(code);
        if(node.value!=null){
            mapCodeTable.put(node.value,stringBuilder1.toString());
        }else {
            getCodeTable(node.leftNode,"0",stringBuilder1);
            getCodeTable(node.rightNode,"1",stringBuilder1);
        }

    }

    private Map<Byte, Integer> getMapCoding(byte[] bytes) {
        Map<Byte,Integer> map=new HashMap<>();

        for (byte b:bytes){
            Byte by=new Byte(b);
            if(map.get(by)!=null){
                map.put(by,map.get(by)+1);
            }else {
                map.put(by,1);
            }
        }
        return map;
    }

    private HFMNode initHFMNode(Map<Byte,Integer> map){
        List<HFMNode> hfmNodeList=new ArrayList<>();
        for (Map.Entry<Byte,Integer> entry: map.entrySet()){
            HFMNode node=new HFMNode(entry.getValue(),entry.getKey());
            hfmNodeList.add(node);
        }
        if(hfmNodeList.size()==0){
            return null;
        }
        while (hfmNodeList.size()>1){
            Collections.sort(hfmNodeList);
            HFMNode left=hfmNodeList.get(0);
            HFMNode right=hfmNodeList.get(1);
            HFMNode rootNode=new HFMNode(left.weights+right.weights,null);
            rootNode.leftNode=left;
            rootNode.rightNode=right;
            hfmNodeList.remove(left);
            hfmNodeList.remove(right);
            hfmNodeList.add(rootNode);
        }
        return hfmNodeList.get(0);

    }

    public void threadNode(){
        HFMNode node=root;
        while (node.leftNode!=null){
            node=node.leftNode;
        }
        root.threadNode(node,null);
    }


    public void zipfile(String path, String out) {
        try {
            FileInputStream fileInputStream=new FileInputStream(path);
            byte[] bytes=new byte[fileInputStream.available()];
            System.out.println("orinigalCode.len="+bytes.length);
            fileInputStream.read(bytes);
            byte[] hfmCode=hfmCoding(bytes);
            System.out.println("hfmCode.len="+hfmCode.length);
            FileOutputStream os=new FileOutputStream(out);
            ObjectOutputStream oos=new ObjectOutputStream(os);
            oos.writeObject(hfmCode);
            oos.writeObject(mapCodeTable);
            oos.close();
            os.close();
            fileInputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void jyfile(String path, String out) {
        try {
            FileInputStream fis=new FileInputStream(path);
            ObjectInputStream ois=new ObjectInputStream(fis);
            byte[] bytes=(byte[]) ois.readObject();
            Map<Byte,String> map= (Map<Byte, String>) ois.readObject();
            ois.close();
            fis.close();
            byte[] original=hfmDecoding(bytes,map);
            FileOutputStream fos=new FileOutputStream(out);
            fos.write(original);
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
