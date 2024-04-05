package ru.javarush.vasilev.cryptoanalizer;

//import javafx.application.Application;
//import javafx.scene.Scene;
//import javafx.scene.control.Label;
//import javafx.scene.layout.StackPane;
//import javafx.stage.Stage;

import ru.javarush.vasilev.cryptoanalizer.Cypher;

import java.io.File;
import java.io.IOException;

//public class CryptoAnalizer extends Application {
//    @Override
//    public void start(Stage stage) throws Exception {
//        String javaVersion = System.getProperty("java.version");
//        String javafxVersion = System.getProperty("javafx.version");
//        Label l = new Label("Hello, JavaFX " + javafxVersion + " running on Java " + javaVersion);
//        Scene scene = new Scene(new StackPane(l), 640, 480);
//        stage.setTitle("Главное окно");
//        stage.setScene(scene);
//        stage.show();
//    }
public class CryptoAnalizer{
    public static void main(String... args){
        try {
            Cypher.encrypt(new File("D:/test/src.txt"), new File("D:/test/dst.txt"), 1);
        }
        catch(IOException e){
            System.out.print(e.getStackTrace());
        }
//        launch();
    }
}