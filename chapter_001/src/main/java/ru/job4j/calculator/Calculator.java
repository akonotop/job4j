package ru.job4j.calculator;

public class Calculator {
    private double result;
    
    public void add(double first, double second) {

        this.result = first + second;
    }
    
    public double getresult() {

        return this.result;
    }

    public void divide(double first, double second) {
        this.result = first / second;
    }


    public void sub(double first, double second) {
        this.result = first - second;
    }


    public void multiply(double first, double second) {
        this.result = first * second;
    }

}