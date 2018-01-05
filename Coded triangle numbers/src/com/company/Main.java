package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int count = 0;
        int maxscore = 0;
        String words = "";
        List<Integer> trinums = new ArrayList<>();

        try {
            words = readFile("/home/brendan.petras/Documents/dev/Coded triangle numbers/p042_words.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        words = words.replace("\"","");
        words = words.replace("\n","");

        String[] sArr = words.split(",");

        int trinum = 0;
        int index = 1;
        while(trinum <= 192)
        {
            trinum += index;
            trinums.add(trinum);
            index++;
        }



        for(int i = 0; i < sArr.length; i++)
        {
            int score = 0;
            for(int j = 0; j < sArr[i].length(); j++)
            {
                score += sArr[i].charAt(j) - 64;
            }
            if(score > maxscore)
                maxscore = score;
            if(trinums.contains(score))
                count++;
        }

        System.out.println(count);
        //System.out.println(maxscore);       //max score = 192
    }

    private static String readFile(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");

        try {
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }

            return stringBuilder.toString();
        } finally {
            reader.close();
        }
    }
}
//
//The nth term of the sequence of triangle numbers is given by,
//tn = ½n(n+1); so the first ten triangle numbers are:
//
//1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
//
//By converting each letter in a word to a number corresponding to its
//alphabetical position and adding these values we form a word value.
//For example, the word value for SKY is 19 + 11 + 25 = 55 = t10.
//If the word value is a triangle number then we shall call the word a triangle word.
//
//Using words.txt (right click and 'Save Link/Target As...'), a 16K text file
// containing nearly two-thousand common English words, how many are triangle words?