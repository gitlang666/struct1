package com.example.struct.queue;

public class SparseArray {
    public int[][] arrO;
    public int[][] arrS;

    public SparseArray() {
        this.arrO=new int[][]{
                {0,0,0,0,0,0,0,0,0},
                {0,0,1,0,0,0,0,0,0},
                {0,0,0,2,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0},
        };
    }

    /**
     * 得到arrO的稀疏数组，等到的稀疏数组可以恢复为原来的数组
     * @return
     */
    public int[][] save(){
        int h=1;
        for(int i=0;i<arrO.length;i++){
            for (int j=0;j<arrO[i].length;j++){
                if(arrO[i][j]!=0){
                    h++;
                }
            }
        }
        arrS=new int[h][3];
        arrS[0][0]=arrO.length;
        arrS[0][1]=arrO[0].length;
        arrS[0][2]=h-1;
        int count=1;
        for(int i=0;i<arrO.length;i++){
            for (int j=0;j<arrO[i].length;j++){
                if(arrO[i][j]!=0){
                arrS[count][0]=i;
                arrS[count][1]=j;
                arrS[count][2]=arrO[i][j];
                count++;
                }
            }
        }
        return arrS;
    }
}
