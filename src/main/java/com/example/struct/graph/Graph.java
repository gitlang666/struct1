package com.example.struct.graph;

import com.example.struct.clue.Node;

import javax.sound.midi.Soundbank;
import java.io.OutputStream;
import java.util.*;

public class Graph {
    private List<Vertex> vertexList=new ArrayList<>();
    //邻接矩阵
    public int[][] adMatrix;
    private int size;

    public Graph(int size) {
        this.size=size;
        this.adMatrix=new int[size][size];
        this.flag=new int[size];
    }


    public void addVertex(Vertex vertex){
        if(vertex==null) return;
        if(size>vertexList.size()){
            vertexList.add(vertex);
        }else {
            System.out.println("overflow");
        }

    }

    public void add(String one,String two,int w){
        int h=-1,v=-1;
        for (int i = 0; i < vertexList.size(); i++) {
            if(vertexList.get(i).getValue()==one && h==-1){
                h=i;
            }
            if(vertexList.get(i).getValue()==two && v==-1){
                v=i;
            }
            if(h!=-1 && v!=-1){
                break;
            }
        }
        if(h!=-1 && v!=-1){
            adMatrix[h][v]=w;
            adMatrix[v][h]=w;
        }

    }

    private int[] flag;

    /***
     * 广度优先
     * @param s
     */
    public void beradthFirst(int s){
        if(s>size){
            return;
        }
        Queue<Integer> queue=new LinkedList();
        queue.add(s);
        flag[s]=1;
        while (!queue.isEmpty()){
            int k=queue.poll();
            System.out.print(vertexList.get(k).getValue()+"  ");
            for (int i = 0; i <adMatrix[k].length ; i++) {
                if(adMatrix[k][i]!=0 && flag[i]==0){
                    queue.add(i);
                    flag[i]=1;
                }
            }
        }
        System.out.println();
    }

    public void mixPath(String s,String e){
        Queue<Integer> queue=new LinkedList<>();
        Queue<Vertex> queueV=new LinkedList<>();
        for (int i=0;i<vertexList.size();i++){
            if(vertexList.get(i).getValue().equals(s)){
                queue.add(i);
                vertexList.get(i).setP(new Vertex(""));
                queueV.add(vertexList.get(i));
                break;
            }
        }
        List<String> list=new ArrayList<>();
        list.add(s);
        int count1=1,count2=0;
        while (!queue.isEmpty()){
            int k=queue.poll();
            Vertex v=queueV.poll();
            System.out.print(v.getP().getValue()+v.getValue() + " ");
            list.add(v.getP().getValue()+v.getValue());
            if (vertexList.get(k).getValue().indexOf(e)>=0){
                break;
            }
            count1--;
            //记录每一层的个数
            for (int i=0;i<adMatrix[k].length;i++){
                if (adMatrix[k][i]!=0){
                    queue.add(i);
                    Vertex vertex=new Vertex(vertexList.get(i).getValue());
                    vertex.setP(new Vertex(v.getValue()));
                    queueV.add(vertex);
                    count2++;
                }
            }
            if(count1==0){
                System.out.println("s"+count2+" ");
                count1=count2;
                count2=0;
            }
        }
        System.out.println();
        String f=e;
        for (int i = list.size()-1; i >=0 ; i--) {
            if(i==0){
                System.out.print(list.get(i));
            }
            if(list.get(i).indexOf(f)==1){
                System.out.print(f+"<-");
                f=list.get(i).substring(0,1);
            }
        }
    }



    /**
     * 深度优先
     * @param s
     */
    public void depthFirst(int s){
        if(s>size){
            return;
        }
        Stack<Integer> stack=new Stack<>();
        stack.add(s);
        flag[s]=1;
        while (!stack.isEmpty()) {
            int k=stack.pop();
            System.out.print(vertexList.get(k).getValue() + " ");
            for (int i = 0; i < adMatrix[k].length; i++) {
                if(adMatrix[k][i]!=0 && flag[i]==0){
                    stack.add(i);
                    flag[i]=1;
                }
            }
        }
        System.out.println();
    }

    StringBuilder sb=new StringBuilder();
    Stack<Integer> stack=new Stack<>();
    List<String> strings=new ArrayList<>();

    /**
     * 深度优先
     * @param s
     * @param e
     */
    public void allPath(String s,String e){
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getValue().equals(s)){
                stack.add(i);
                break;
            }
        }
        allPath(sb,0,e);
        System.out.println(strings);
        Map<String ,Integer> wMap=new HashMap<>();
        for (String string : strings) {
            string=string.substring(0,string.length()-1);
            int w=0;
            String[] strings1=string.split(">");
            for (int i=0;i<strings1.length-1;i++){
                String p1=strings1[i];
                String p2=strings1[i+1];
                int h=-1,v=-1;
                for (int j=0;i<vertexList.size();j++){
                    if(vertexList.get(j).getValue().equals(p1)){
                        h=j;
                    }
                    if(vertexList.get(j).getValue().equals(p2)){
                        v=j;
                    }
                    if(h!=-1 && v!=-1){
                        break;
                    }
                }
                w+=adMatrix[h][v];
            }
            wMap.put(string,w);
        }
        for(Map.Entry entry:wMap.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
    public void allPath(StringBuilder stringBuilder1,int count,String e){
        count++;
        if(count>size){
            return;
        }else if(!stack.isEmpty()){
            int k=stack.pop();
            StringBuilder stringBuilder2=new StringBuilder(stringBuilder1);
            if(stringBuilder2.indexOf(vertexList.get(k).getValue())==-1){
                stringBuilder2.append(vertexList.get(k).getValue()+">");
            }else {
                return;
            }
            if(vertexList.get(k).getValue().equals(e)){
                strings.add(stringBuilder2.toString());
                return;
            }
            int j=0;
            for (int i = 0; i < adMatrix[k].length; i++) {
                if(adMatrix[k][i]!=0 && count<size ){
                    stack.add(i);
                    j++;
                }
            }
            for (int i = 0; i < j; i++) {
                allPath(stringBuilder2,count,e);
            }

        }


    }


}
