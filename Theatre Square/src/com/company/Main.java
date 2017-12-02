package com.company;

import java.util.Scanner;
import java.lang.Math;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        long n = in.nextInt();
        long m = in.nextInt();
        long a = in.nextInt();

        double l = Math.ceil((double)n/a);
        double w = Math.ceil((double)m/a);

        System.out.print((long)(l*w));
    }
}
