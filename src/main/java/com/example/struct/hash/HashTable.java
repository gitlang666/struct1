package com.example.struct.hash;

/**
 * 新建一个hash表
 * @param <T>
 */
public class HashTable<T extends GetValue> {

    private Object[] arr=new Object[10];

    /**
     * 添加数据
     * @param t
     */
    public void add(T t){
        int surplus=t.getValue()%10;
        if(arr[surplus]==null){
            arr[surplus]=t;
        }else {
            T node=(T)arr[surplus];
            node.append(t);
        }
    }

    /**
     * 遍历数据
     */
    public void show(){
        for (Object o : arr) {
            if(o==null){
                System.out.println("null");
            }else {
                T node=(T)o;
                node.show();
            }
        }
    }

    /**
     * 查找数据
     * @param key
     * @return
     */
    public T get(int key){
        int surplus=key%10;
        T node=(T)arr[surplus];
        if (node==null){
            return node;
        }
        node=(T)node.getNode(key);
        return node;
    }

    /**
     * 删除一个元素
     * @param t
     */
    public void delete(T t){
        int surplus=t.getValue()%10;
        T node=(T)arr[surplus];
        if(node.getValue()==t.getValue()){
            arr[surplus]=null;
        }else {
            node.delete(t);
        }
    }

}
