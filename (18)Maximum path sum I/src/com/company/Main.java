package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String block =  "75\n" +
                        "95 64\n" +
                        "17 47 82\n" +
                        "18 35 87 10\n" +
                        "20 04 82 47 65\n" +
                        "19 01 23 75 03 34\n" +
                        "88 02 77 73 07 63 67\n" +
                        "99 65 04 28 06 16 70 92\n" +
                        "41 41 26 56 83 40 80 70 33\n" +
                        "41 48 72 33 47 32 37 16 94 29\n" +
                        "53 71 44 65 25 43 91 52 97 51 14\n" +
                        "70 11 33 28 77 73 17 78 39 68 17 57\n" +
                        "91 71 52 38 17 14 91 43 58 50 27 29 48\n" +
                        "63 66 04 68 89 53 67 30 73 16 69 87 40 31\n" +
                        "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";

        block = block.replace("\n"," ");

        String[] arr = block.split(" ");

        List<List<Integer>> tree = new ArrayList<List<Integer>>();

        int index = 1;
        int inc = 1;

        for(int j = 0; j < 15; j++)
        {
            List row = new ArrayList<Integer>();
            for(int i = 0; i < inc; i++)
            {
                row.add(Integer.parseInt(arr[i+index-1]));
            }
            tree.add(row);
            index += inc;
            inc++;
        }

        int maxNumber = 0;
        int Imask = 0;

        while(Imask < 16384)
        {
            String m = Integer.toBinaryString(Imask);
            String mask = m;
            int curr = 75;

            for(int i = 0; i < 14 - m.length(); i++)
            {
                mask = "0"+mask;
            }

            int j = 0;
            for(int i = 1; i < 15; i++)
            {
                int LR = Integer.parseInt(""+mask.charAt(i-1));
                j += LR;

                curr += tree.get(i).get(j);
            }
            if(curr > maxNumber)
                maxNumber = curr;

            System.out.println(Imask);
            Imask++;
        }

        System.out.println(maxNumber);









    }



}
