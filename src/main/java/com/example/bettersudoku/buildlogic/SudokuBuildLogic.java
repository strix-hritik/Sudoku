package com.example.bettersudoku.buildlogic;

import com.example.bettersudoku.Problem.IStorage;
import com.example.bettersudoku.Problem.SudokuGame;
import com.example.bettersudoku.UserInterface.IUserInterfaceContract;
import com.example.bettersudoku.UserInterface.logic.ControlLogic;
import com.example.bettersudoku.computationlogic.GameLogic;
import com.example.bettersudoku.persistance.LocalStorageImpl;

import java.io.IOException;

public class SudokuBuildLogic {

    public static void build(IUserInterfaceContract.View userInterface) throws IOException {
        SudokuGame initialState;
        IStorage storage = new LocalStorageImpl();

        try {

            initialState = storage.getGameData();
        } catch (IOException e) {

            initialState = GameLogic.getNewGame();
            storage.updateGameData(initialState);
        }

        IUserInterfaceContract.EventListener uiLogic = new ControlLogic(storage, userInterface);
        userInterface.setListener(uiLogic);
        userInterface.updateBoard(initialState);
    }
}

