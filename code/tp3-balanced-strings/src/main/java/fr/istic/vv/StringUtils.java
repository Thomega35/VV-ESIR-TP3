package fr.istic.vv;

import java.util.Stack;

public class StringUtils {

    private StringUtils() {}

    public static boolean isBalanced(String str) {

        Stack<Character> stack = new Stack<Character>();
        char[] res = str.toCharArray();

        for(int i = 0 ; i < res.length ; i++) {
            
            if(res[i] == '(' || res[i] == '[' || res[i] == '{')
                stack.push(res[i]);

            else if(res[i] == ')'){

                if(stack.isEmpty()) return false;

                if(stack.peek() == '(') stack.pop();
                else return false;

            }else if(res[i] == ']'){

                if(stack.isEmpty()) return false;

                if(stack.peek() == '[') stack.pop();
                else return false;
                
            }else if(res[i] == '}'){

                if(stack.isEmpty()) return false;

                if(stack.peek() == '{') stack.pop();
                else return false;

            }
            
        }

        if(stack.isEmpty()) return true;
        else return false;

    }

}
