package com.wanyy.ltd.datastructure.dataStru.structure.stack.polishExpression;

import java.util.Arrays;

public enum OperatorPriorityEnum{
    multi("*",2),
    devide("/",2),
    plus("+",1),
    minus("-",1),
    error("",0);
    private String operator;
    private Integer priority;

    
    OperatorPriorityEnum(String operator, Integer priority) {
        this.operator = operator;
        this.priority = priority;
    }

    
    public static Integer getOpPriority(String operator){
        return Arrays.stream(OperatorPriorityEnum.values())
                .filter(e -> operator.equals(e.operator))
                .findFirst().orElse(error).getPriority();
    }
    
    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    
}
