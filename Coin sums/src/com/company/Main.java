package com.company;

public class Main {

    static int count = 0;
    static int coins[] = {200, 100, 50, 20, 10, 5, 2, 1};

    public static void main(String[] args) {

        System.out.println(findposs(200, 0));
    }

    public static int findposs(int money, int maxcoin)
    {

        int sum = 0;
        if (maxcoin == coins.length-1)
            return 1;

        for (int i = maxcoin; i < 8; i++)
        {
            if (money - coins[i] == 0)
                sum += 1;

            else if (money - coins[i] > 0)
                sum += findposs(money - coins[i], i);
        }
        return sum;
    }
}

//        for (int i = 0; i < 2; i++)
//        {
//            for (int j = 0; j < 3; j++)
//            {
//                for (int k = 0; k < 5; k++)
//                {
//                    for (int l = 0; l < 11; l++)
//                    {
//                        for (int m = 0; m < 21; m++)
//                        {
//                            for (int n = 0; n < 41; n++)
//                            {
//                                for (int o = 0; o < 101; o++)
//                                {
//                                    for (int p = 0; p < 201; p++)
//                                    {
//                                        int sum = (i)*200 + (j)*100 + (k)*50 + (l)*20 + (m)*10 + (n)*5 + (o)*2 + (p)*1;
//                                        if(sum == 200)
//                                            count++;
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//
//        System.out.println(count);
//    }



//In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:
//
//1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
//It is possible to make £2 in the following way:
//
//1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
//How many different ways can £2 be made using any number of coins?