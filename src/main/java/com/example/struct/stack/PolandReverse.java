package com.example.struct.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandReverse {
    public static List<String> getPolandReverse(String string){
        List<String> list1=getMidExpression(string);
        List<String> reverse=new ArrayList<>();
        Stack<String> stack=new Stack<>();
        for (String s : list1) {
            if(s.matches("^[0-9]*$")){
                reverse.add(s);
            }else if(s.equals("(")){
                stack.add(s);
            }else if(s.equals(")")){
                while (!stack.peek().equals("(")){
                    reverse.add(stack.pop());
                }
                stack.pop();
            }else {
                while (stack.size()>0 &&(Priority.getPriority(stack.peek())>=Priority.getPriority(s))){
                    reverse.add(stack.pop());
                }
                stack.add(s);
            }
        }

        while (stack.size()>0){
            reverse.add(stack.pop());
        }


        return reverse;
    }

    public static List<String> getMidExpression(String string){
        List<String> list=new ArrayList<>();
        int i=0;
        String splice="";
        char c;
        while (i<string.length()){
            if(((c=string.charAt(i))>57) || ((c=string.charAt(i))<48)){
                list.add(""+c);
                i++;
            }else {
                splice="";
                splice+=string.charAt(i);
                i++;
                while (i<string.length()&&string.charAt(i)<=57 && string.charAt(i)>=48){
                    splice+=string.charAt(i);
                    i++;
                }
                list.add(splice);
            }
        }
        System.out.println(list);
        return list;
    }

    //逆波兰计算器，遇到数入栈，遇到运算符弹两次栈，第二次弹出的数被运算数

    public static int getResult(String string){
        int result=0;
        List<String> list=getPolandReverse(string);
        Stack<String> stack=new Stack<>();
        for (String s : list) {
            if(s.matches("^[0-9]*$")){
                stack.push(s);
            }else {
                result=Cal.c(s,stack.pop(),stack.pop());
                stack.push(new String(""+result));
            }
        }
        return result;
    }
}
class Priority{
    private static final int ADD=1;
    private static final int SUB=1;
    private static final int MUL=2;
    private static final int DIV=2;

    public static int getPriority(String oper){
        switch (oper){
            case "+":
                return ADD;
            case "-":
                return SUB;
            case "*":
                return MUL;
            case "/":
                return DIV;
            default:
                System.out.println("buhefa");
                return 0;
        }
    }
}
class Cal{
    public static int c(String oper,String p1,String p2){
        switch (oper){
            case "+":
                return Integer.parseInt(p2)+Integer.parseInt(p1);
            case "-":
                return Integer.parseInt(p2)-Integer.parseInt(p1);
            case "*":
                return Integer.parseInt(p2)*Integer.parseInt(p1);
            case "/":
                return Integer.parseInt(p2)/Integer.parseInt(p1);
            default:
                System.out.println("buhefa");
                return 0;
        }
    }
}
