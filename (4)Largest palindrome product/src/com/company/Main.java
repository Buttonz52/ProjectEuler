package com.company;

public class Main {

    public static void main(String[] args) {
	    int[][] searchArea = new int[999][999];

        int currLargestPalindrome = 0;

	    for(int i = 100; i < 999; i++)
        {
	        for(int j = 100; j < 999; j++)
            {
                searchArea[i][j] = i * j;
                if(checkPalindrome(i * j) == true && (i * j) > currLargestPalindrome)
                    currLargestPalindrome = i * j;
            }
        }

        System.out.println(currLargestPalindrome);
    }

    public static boolean checkPalindrome(int n)
    {
        String number = n+"";

        for(int i = 0; i < (number.length()/2); i++)
        {
            if (number.charAt(i) != number.charAt(number.length()-(i+1)))
                return false;
        }

        return true;
    }

}
