package com.example.bettersudoku;

import com.example.bettersudoku.UserInterface.IUserInterfaceContract;
import com.example.bettersudoku.UserInterface.UserInterfaceImpl;
import com.example.bettersudoku.buildlogic.SudokuBuildLogic;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class SudokuApplication extends Application {
    private IUserInterfaceContract.View uiImpl;
    @Override
    public void start(Stage primaryStage) throws IOException {
       uiImpl = new UserInterfaceImpl(primaryStage);
       try {
            SudokuBuildLogic.build(uiImpl);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
   }

    public static void main(String[] args) {
        launch();
    }
}