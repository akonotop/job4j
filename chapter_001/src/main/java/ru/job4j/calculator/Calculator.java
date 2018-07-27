package ru.job4j.calculator;

public class Calculator {
    private double result;
    
    public void add(double first, double second) {

        this.result = first + second;
    }
    
    public double getAddResult() {

        return this.result;
    }

    public void divide(double first, double second) {
        this.result = first / second;
    }
    public double getDivideResult() {
        return this.result;
    }

    public void sub(double first, double second) {
        this.result = first - second;
    }
    public double getSubResult() {
        return this.result;
    }

    public void multiply(double first, double second) {
        this.result = first * second;
    }
    public double getMultiplyResult() {
        return this.result;
    }
}