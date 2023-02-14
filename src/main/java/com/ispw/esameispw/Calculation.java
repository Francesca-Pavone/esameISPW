package com.ispw.esameispw;

public class Calculation {

    public double calculateSingleMemberOperations(double firstOperand, String operationToDo) {
        switch (operationToDo) {
            case "log":
                return Math.log10(firstOperand);
            case "ln":
                return Math.log(firstOperand);
            default:
                break;
        }
        return 0;
    }

    public double calculateSimpleOperations(double firstOperand, double secondOperand, String operationToDo) {
        switch (operationToDo) {

            case "÷":
                return firstOperand / secondOperand;
            case "×":
                return firstOperand * secondOperand;
            case "−":
                return firstOperand - secondOperand;
            case "+":
                return firstOperand + secondOperand;
            default:
                break;
        }
        return 0;
    }

}