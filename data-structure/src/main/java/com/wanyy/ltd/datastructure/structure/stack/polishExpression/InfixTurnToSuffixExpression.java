package com.wanyy.ltd.datastructure.structure.stack.polishExpression;

import java.util.Stack;

/**
 * 中缀表达式转后缀
 * 1) 初始化两个栈，运算符栈s1和存储中间计算结果的栈s2；
 * 2) 从左至右扫描中缀表达式；
 * 3) 遇到操作数时，将其压入s2；
 * 4) 遇到运算符时，比较其与s1栈顶运算符的优先级：
 *     (1)	若s1为空，或者栈顶运算符为左括号(,则直接将此运算符入栈；
 *     (2)	若优先级比栈顶运算符的高，也将运算符压入s1；
 *     (3)	否则将s1栈顶的运算符弹出并压入s2中，再次转到4-1步骤中与s1中新的栈顶运算符进行比较；
 * 5) 遇到括号时：
 *     (1)	如果是左括号(,则直接压入s1；
 *     (2)	如果是右括号),则依次弹出s1栈顶的运算符，并压入s2直到遇到左括号为止，此时将这一对括号丢弃
 * 6) 重复步骤2到5，直到表达式的最右端；
 * 7) 将s1中的运算符依次弹出并压入s2；
 * 8) 依次弹出s2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式；
 */
public class InfixTurnToSuffixExpression {
    /**
     * 中缀转后缀
     */
    public static String turn(String infixExpression) {
        String[] splits = infixExpression.split("");
        Stack<String> numStack = new Stack<>();
        Stack<String> operatorStack = new Stack<>();
        
        //为了方便探寻后一位 所以用for i循环
        for (int i = 0; i < splits.length; i++) {
            String str = splits[i];
            System.out.println("当前被操作字符为： -> " + str);
            if (str.matches("\\d")){
                numStack.push(str);
                while (i+1 < splits.length && splits[i + 1].matches("\\d")) {
                    String next = numStack.pop();
                    numStack.push(next.concat(splits[i + 1]));
                    i++;
                }
            } else {
                if ("+-*/".contains(str)){
                    opOperatorStack(str,numStack,operatorStack);
                } else if ("(".equals(str)) {
                    operatorStack.push(str);
                } else if (")".equals(str)){
                    while (true){
                        if (("(").equals(operatorStack.peek())){
                            System.out.println("左侧括号被弹出 -->" + operatorStack.pop());
                            break;
                        }
                        numStack.push(operatorStack.pop());
                    }
                }
            }
        }

        System.out.println("符号栈的内容依次压入数字栈");
        while (!operatorStack.empty()){
            numStack.push(operatorStack.pop());
        }
        StringBuilder builder = new StringBuilder();
        while (!numStack.empty()){
            builder.append(" ").append(numStack.pop());
        }
        builder.reverse();
        String suffix = builder.toString();
        return suffix.substring(0,suffix.length()-1);
    }
    
    private static void opOperatorStack(String operator,Stack<String> numStack,Stack<String> operatorStack){
        if (operatorStack.empty() || ("(").equals(operatorStack.peek())){
            operatorStack.push(operator);
        } else if (comparePriority(operator,operatorStack.peek())){
            operatorStack.push(operator);
        } else if (!comparePriority(operator,operatorStack.peek())) {
            String pop = operatorStack.pop();
            numStack.push(pop);
            opOperatorStack(operator,numStack,operatorStack);
        }
    }
    private static boolean comparePriority(String operator1,String operator2){
        return OperatorPriorityEnum.getOpPriority(operator1) > OperatorPriorityEnum.getOpPriority(operator2);
    }
}
