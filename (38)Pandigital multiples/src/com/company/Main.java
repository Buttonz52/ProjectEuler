package com.company;

public class Main {

    public static void main(String[] args) {

        long largest = 0;

        for (int i = 1; i < 1000000; i++)
        {
            String number = i+"";
            String pan = "";

            for (int j = 0; j < 9/number.length(); j++)
            {
                pan += (i*(j+1))+"";
            }

            long pandigit = Long.parseLong(pan);

            if(isPandigital(pan) && pandigit > largest)
                largest = pandigit;

        }

        System.out.println(largest);

    }

    private static boolean isPandigital(String number)
    {
        for (int i = 1; i <= number.length(); i++)
        {
            if(!number.contains(i+""))
                return false;
        }
        return true;
    }

}

//Take the number 192 and multiply it by each of 1, 2, and 3:
//
//192 × 1 = 192
//192 × 2 = 384
//192 × 3 = 576
//By concatenating each product we get the 1 to 9 pandigital, 192384576.
//We will call 192384576 the concatenated product of 192 and (1,2,3)
//
//The same can be achieved by starting with 9 and multiplying by 1, 2, 3, 4, and 5,
//giving the pandigital, 918273645, which is the concatenated product of 9 and (1,2,3,4,5).
//
//What is the largest 1 to 9 pandigital 9-digit number that can be formed as the
//concatenated product of an integer with (1,2, ... , n) where n > 1?
