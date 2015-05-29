package com.company;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.SortedSet;

public class Main {

    public static void main(String[] args) {
        Set<String> aList = new HashSet<String>();
        HashSet<Population> aCollection = new HashSet<Population>();
        int count =0;
        CSV thisCSVFile = new CSV(aCollection);
               try {
            thisCSVFile.readCSV();
                   aList = thisCSVFile.sortData().keySet();
            System.out.println("Top 5 Cities");
            for (String s : aList)
            {
                if(count < 6) {
                    System.out.println( s);

                }
                if(count >= (aCollection.size() - 5))
                    System.out.println("YY" + s);
                count++;
            }

            } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
