package com.company;

public class Main {

    public static void main(String[] args)
    {
        int largest = 0;
        int saved = 0;
        int perimeter[] = new int[1001];

        for (int i = 1; i < perimeter.length; i++)
        {
            perimeter[i] = 0;
        }

        for(int c = 1; c < 1000; c++)
        {
            for(int b = 1; b < c; b++)
            {
                double a = Math.sqrt((c*c) - (b*b));
                if((a/1 == a) && (a+b+c <= 1000) && isRightAngled((int)a,b,c))
                    perimeter[(int)a+b+c]++;
            }
        }

        for (int i = 1; i < perimeter.length; i++)
        {
            if(perimeter[i] > largest)
            {
                largest = perimeter[i];
                saved = i;
            }
        }

        System.out.println(saved);
        System.out.println(largest);
    }

    private static boolean isRightAngled(int a, int b, int c)
    {
        if((a*a + b*b) == c*c)
            return true;
        else
            return false;
    }
}

//If p is the perimeter of a right angle triangle with integral length sides, {a,b,c},
//there are exactly three solutions for p = 120.
//
//{20,48,52}, {24,45,51}, {30,40,50}
//
//For which value of p ≤ 1000, is the number of solutions maximised?