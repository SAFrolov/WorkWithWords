/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package counterofwordsfinel;

import java.util.ArrayList;


public class counter {
    private String word;
    private Integer numbers;
    private ArrayList<counter> counterArrayList=new ArrayList<>();

    public counter() {
    }

    private counter(String word, Integer numbers) {
        this.word = word;
        this.numbers = numbers;
    }
    
  
    public void AddCounterToCounter(counter cnt){
        counterArrayList.addAll(cnt.getArrayList());
    }
    
    
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        for (counter object : counterArrayList) {
            str.append("Word: " + object.word + ", number: " +object.numbers + "\n"); 
        }
        return str.toString();
    }
    public ArrayList<counter> getArrayList(){
        return this.counterArrayList;
    }
    
    public void nextWord(String nextWord) {
        for (counter objectFromArrayList : counterArrayList) {
            if(objectFromArrayList.word.equals(nextWord)){
                objectFromArrayList.numbers++;
                return;
            }
        }
        counter newWord = new counter(nextWord, 1);
        counterArrayList.add(newWord);
    }
    
    
}
