package com.company;

import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) {

        //Directory variables
        String filepath = "/home/brendan.petras/SFTP/Nov.10_17/theirs/";
        String filename = "taxrate_LYV.txt";

        List<Integer> effectedColumns = new ArrayList<>();

        // Read in the file
        try {
            File file = new File(filepath + filename);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] columns;

            //Add into the List the numbers corresponding to each column with a (" ")
            while ((line = bufferedReader.readLine()) != null) {
                columns = line.split("\\|");
                for (int i = 0; i < columns.length; i++) {
                    if (columns[i].equals(" ")) {
                        effectedColumns.add(1 + i);
                    }
                }
            }

            fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            //Numerical sort of all the numbers
            Collections.sort(effectedColumns);

            //Removing duplicates
            int prev = 0;
            for(Iterator<Integer> It = effectedColumns.iterator(); It.hasNext();) {
                Integer curr = It.next();
                if(prev == curr)
                {
                    It.remove();
                }
                prev = curr;
            }

            //convert numbers in to Excel style column strings
            for (int i = 0; i < effectedColumns.size(); i++) {
                System.out.print(GetExcelColumnName(effectedColumns.get(i).intValue()) + ", ");
            }


    }

    public static String GetExcelColumnName(int columnNumber)
    {
        int dividend = columnNumber;
        String columnName = "";
        int modulo;

        while (dividend > 0)
        {
            modulo = (dividend - 1) % 26;
            columnName = (char)(65 + modulo) + columnName;
            dividend = (int)((dividend - modulo) / 26);
        }

        return columnName;
    }
}

