package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) {
        Map<String,Integer> wordCountMap = new HashMap<>() ;

        try{
            FileReader fileReader = new FileReader("src.txt") ;
            BufferedReader bufferedReader = new BufferedReader(fileReader) ;

            String line ;
            while( (line= bufferedReader.readLine()) != null ){

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
