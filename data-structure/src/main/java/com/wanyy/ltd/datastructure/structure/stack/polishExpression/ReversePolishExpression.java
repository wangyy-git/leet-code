package com.wanyy.ltd.datastructure.structure.stack.polishExpression;

import com.wanyy.ltd.datastructure.structure.stack.Stack;

import java.util.Arrays;

/**
 * 逆波兰表达式
 * 使用后缀表达式实现运算
 */
public class ReversePolishExpression {

    public static void main(String[] args) {
        String expression = "13 4 + 5 * 6 -";
        String[] chars = expression.split(" ");
        Stack<Integer> numStack = new Stack<>();
        
        Arrays.stream(chars).forEach(ch -> {
            
            if(ch.matches("\\d+")){
                numStack.push(Integer.valueOf(ch));
            } else {
                Integer num2 = numStack.pop();
                Integer num1 = numStack.pop();
                switch (ch){
                    case "+":
                        numStack.push(num1+num2);
                        break;
                    case "-":
                        numStack.push(num1 - num2);
                        break;
                    case "*":
                        numStack.push(num1*num2);
                        break;
                    case "/":
                        numStack.push(num1/num2);
                        break;
                    default:
                        throw new RuntimeException("运算符错误！");
                }
            }
        });

        System.out.println("计算结果是 --> " + numStack.pop());
    }
}
