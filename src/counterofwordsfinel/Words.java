/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package counterofwordsfinel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Words implements Comparable<Words>{
    private String words;
    private ArrayList<String> wordsArrayList = new ArrayList<>();

    public Words(String words) {
        this.words = words;           
        StringTokenizer strTok = new StringTokenizer(this.words, " ,.://!?");
        while(strTok.hasMoreTokens()){
            wordsArrayList.add(strTok.nextToken());
        } 
    }

    public Words() {
    }

    public void toWordsArrayList(){
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (String string : wordsArrayList) {
            str.append(string);
            str.append(" ");
        }
        return str.toString();
    }

    @Override
    public int compareTo(Words o) {
        int theFirst=0,theSecond=0;
        char [] charArrayTheFirst = wordsArrayList.get(0).toLowerCase().toCharArray();
        char [] charArrayTheSecond = o.wordsArrayList.get(0).toLowerCase().toCharArray();
        
        for (int i = 0; i < Math.min(charArrayTheFirst.length, charArrayTheSecond.length); i++) {
            if (charArrayTheFirst[i]!=charArrayTheSecond[i]) {
                theFirst = (int)charArrayTheFirst[i];
                theSecond = (int)charArrayTheSecond[i];
                break;
            }
        }
            return theFirst-theSecond;
     }
    
    public ArrayList<String> getArrayListOfWords(){
        return this.wordsArrayList;
    }
    
    public boolean thereIsThisWord(String strFinding){
        boolean flag = false;
        strFinding=strFinding.toLowerCase();
        for (String word : wordsArrayList) {
            word=word.toLowerCase();
            if (word.equals(strFinding)){
                flag=true;
                break;
            }
        }
        return flag;
    }
    
    
    public void sortingWordsInLine(){
        for (int i = 0; i < wordsArrayList.size(); i++) {
            wordsArrayList.set(i, wordsArrayList.get(i).toLowerCase());
        }
        Comparator<? super String> c = null;
        wordsArrayList.sort(c);
    }
    
    public counter counterOfWordsInLine(){
        counter newCounterOfTheWords = new counter();
        for (String string : wordsArrayList) {
            newCounterOfTheWords.nextWord(string.toLowerCase());
        }
        return newCounterOfTheWords;
    }
}
