/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package counterofwordsfinel;

import java.util.ArrayList;
import java.util.Comparator;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author s.frolov
 */
public class CounterOfWordsFinel extends Application {
    String URL = "Ican.txt";  
    Lines file1 = new Lines(URL);
    
    Button btnPrAll = new Button("Print all!"); 
    Button btnFind = new Button("Find lines with this word: ");
    TextField txtFind = new TextField();    
    Button bntByAlphobadLines = new Button("Sorting by Alphabet all lines");
    Button btnByAlphabedWordsInLines = new Button("Sorting words in lines");
    Button bntByAlphobadLinesAndWords = new Button("Sorting by words and lines");
    Button btnCounter = new Button("Count");
    
    @Override
    public void start(Stage primaryStage) {


        btnPrAll.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println(file1);
            }
        });
        btnFind.setOnAction( new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Lines linesWithFoun = file1.findLineWithWord(txtFind.getText());
                System.out.println(linesWithFoun);
            }
        });
        
        bntByAlphobadLines.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Lines sorLines = file1.sortingLines();
                System.out.println(sorLines);
            }
        });
        
        btnByAlphabedWordsInLines.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Lines sortingLines=file1.sortingWordsInLine();
                System.out.println(sortingLines);                
            }
        });
        
        bntByAlphobadLinesAndWords.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Lines sortingLinesWords=file1.sortingWordsInLine();
                sortingLinesWords = sortingLinesWords.sortingLines();
                System.out.println(sortingLinesWords);                
            }
        });
        
        btnCounter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Startint of counting");
                Words test1 = new Words("and you and go to city but you come and back");
                System.out.println(test1.counterOfWordsInLine());
                
                file1.counterWordsInFile();
            }
        });
        
        GridPane root = new GridPane();
        root.add(btnPrAll, 0, 1);
        root.add(btnFind, 0, 2);
        root.add(txtFind, 1, 2);
        root.add(bntByAlphobadLines, 0, 3);
        root.add(btnByAlphabedWordsInLines, 0, 4);
        root.add(bntByAlphobadLinesAndWords, 0, 5);
        root.add(btnCounter, 0, 6);
        Scene scene = new Scene(root, 500, 550);
                
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
