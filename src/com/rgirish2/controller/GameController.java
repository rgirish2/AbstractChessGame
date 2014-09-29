package com.rgirish2.controller;

import com.rgirish2.assignment1.game.TwoDimensionalChessGame;
import com.rgirish2.assignment1.gui.EightByEightBoardGUI;

public class GameController {
	
	/**
	 * The control variables to allow the users to play the game.
	 */	
	private final String [] names = {"Rishi", "Neo"};
	private TwoDimensionalChessGame model;
	private EightByEightBoardGUI view;
	
	public GameController() {
		this.model = new TwoDimensionalChessGame(names);
		this.view = new EightByEightBoardGUI(model);
	    this.view.board.setVisible(true);
	}
	
	/**
	 * Primary controller for all the game movements.
	 * @param curPosX The current X position of the piece.
	 * @param curPosY The current Y position of the piece.
	 * @param newPosX The new X position of the piece.
	 * @param newPosY The new Y position of the piece.
	 * @return True if the movement was successful, False otherwise.
	 */
	public boolean gameMovementController(int curPosX, int curPosY, int newPosX, int newPosY) {
		boolean result = this.model.movePiece(curPosX, curPosY, newPosX, newPosY);
		return result;
	}
	
	/**
	 * Undo the last movement in the game and assign the correct player movement ordinal.
	 * @return True if the undo was successful, False otherwise.
	 */
	public boolean undoLastMoveController() {
		boolean result = this.model.undoLastMove();
		if (result) {
			this.view.renderView();
		}
		return result;
	}
	
	/**
	 * Exit the game being played now.
	 * @return Always returns true.
	 */
	public boolean exitGameController() {
		this.model = null;
		this.view.dispose();
		this.view.setVisible(false);
		return true;
	}
	
	/**
	 * Restart the current game with the same players.
	 * @return True if the game was successfully restarted, False otherwise.
	 */
	public boolean restartGameController() {
		boolean result = this.model.restartGame();
		this.view.renderView();
		return result;
	}
	
	/**
	 * The main method is the starting point in the GUI.
	 * @param args Nothing is passed into the main method.
	 */
	@SuppressWarnings("unused")
	public static void main(String [] args) {
		GameController gameController = new GameController();
	}
}
