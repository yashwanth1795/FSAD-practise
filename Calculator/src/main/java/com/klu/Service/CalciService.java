package com.klu.Service;

import org.springframework.stereotype.Service;

@Service
public class CalciService {

    public int add(int a, int b) {
        return a + b;
    }

    public int sub(int a, int b) {
        return a - b;
    }

    public int mul(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {

        if (b != 0) {
            return a / b;
        } else {
            throw new ArithmeticException("Cannot divide by zero");
        }
    }
    public int Rem(int a,int b) {
    	return a%b;
    }
}
