package com.sbrf.reboot;

public class Calculator {
    public int getAddition(int first, int second) {
        return first + second;
    }

    public int getSubtraction(int first, int second) {
        return first - second;
    }

    public int getMultiplication(int first, int second) {
        return first * second;
    }

    public int getDivision(int first, int second) {
        return first / second;
    }

    public int getMax(int first, int second) {
        return Math.max(first, second);
    }

    public int getMin(int first, int second) {
        return Math.min(first, second);
    }

    public double getSqrt(int first) {
        return Math.sqrt(first);
    }


}
