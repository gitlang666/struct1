package com.example.struct.hash;

public class HashCode {
    public static long hash(String strCode){
        return strCode.length()>0?(strCode.getBytes()[strCode.getBytes().length-1]+hash(strCode.substring(0,strCode.length()-1))*31):0;
    }
}
