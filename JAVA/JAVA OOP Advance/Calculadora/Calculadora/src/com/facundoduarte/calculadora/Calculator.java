package com.facundoduarte.calculadora;

class Calculator implements java.io.Serializable {
    private double operandOne;
    private String operation;
    private double operandTwo;
    private double result;

    public Calculator() {

    }

    public Calculator(double operandOne, String operation, double operandTwo) {
        this.operandOne = operandOne;
        this.operation = operation;
        this.operandTwo = operandTwo;
    }

    public double getOperandOne() {
        return operandOne;
    }

    public void setOperandOne(double operandOne) {
        this.operandOne = operandOne;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double getOperandTwo() {
        return operandTwo;
    }

    public void setOperandTwo(double operandTwo) {
        this.operandTwo = operandTwo;
    }

    public void performOperation() {
        if (this.getOperation() == "+") {
            result = this.getOperandOne() + this.getOperandTwo();
        } else if (this.getOperation() == "-") {
            result = this.getOperandOne() - this.getOperandTwo();
        }
    }

    public double getResult() {
        return result;
    }

}
