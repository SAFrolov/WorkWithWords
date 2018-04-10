/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package counterofwordsfinel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;


public class Lines {
    private ArrayList<Words> lineArrayList = new ArrayList<>();
    private String URL;
    
    public Lines() {
    }

    public Lines(String URL) {
        this.URL=URL;
        BufferedReader reader = null;
        try {

            reader = new BufferedReader(new FileReader(URL));
            StringBuilder sb = new StringBuilder();
            String line = reader.readLine();
            
            while (line!=null){
                lineArrayList.add(new Words(line));                
                line = reader.readLine();
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("File not found!");;
        } catch (IOException ex) {
            System.out.println("Cannot open the file!");
        } finally {
            try {
                reader.close();
            } catch (IOException ex) {
                System.out.println("Cannot open the file!");;
            }
        }
    }
    
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Words lines : lineArrayList) {
            str.append(lines);
            str.append("\n");
        }
        return str.toString();
    }

    public void add(Words addWords){
        lineArrayList.add(addWords);
    }
    
    public Lines findLineWithWord(String strFinding){
        //words which we will find. If there are several words that arrayList needs
        Words wordsFinding = new Words(strFinding);
        ArrayList<String> strFindingArrayList = wordsFinding.getArrayListOfWords();

        //new array list with lines with looking for words
        Lines lineWithFoundWords = new Lines();
        for (String word : strFindingArrayList) {
            lineWithFoundWords.add(new Words(word + ":"));
            for (Words line : lineArrayList) {
                if(line.thereIsThisWord(word)){
                    lineWithFoundWords.add(line);
                }
            }
        }
        return lineWithFoundWords;
    }
    
    public Lines sortingWordsInLine(){
        Lines linesForSortingByWords = new Lines(this.URL);
        for (Words words : linesForSortingByWords.lineArrayList) {
            words.sortingWordsInLine();
        }
        return linesForSortingByWords;
    }
    
    public Lines sortingLines(){
        Lines linesForSortingByLine = new Lines();
        linesForSortingByLine.lineArrayList.addAll(this.lineArrayList);
        Comparator<? super Words> c = null;
        
        linesForSortingByLine.lineArrayList.sort(c);
        
        return linesForSortingByLine;
    }
    
    public void counterWordsInFile(){

    }
}
