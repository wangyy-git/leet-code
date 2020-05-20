package com.wanyy.ltd.datastructure.structure.stack.polishExpression;

public class ExpressTest {

    public static void main(String[] args) {
        String infixExpression = "11+((2+3)*4)-5"; //7 5 * 6 -
        //ope 
        //num 7 5 * 6 8 * - 11 +
        String turn = InfixTurnToSuffixExpression.turn(infixExpression);
        System.out.println(turn);
        ReversePolishExpression.calculateSuffix(turn);
    }
}
