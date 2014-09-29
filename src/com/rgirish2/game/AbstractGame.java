package com.rgirish2.game;

/**
 * A super class representing all kinds of possible games of chess.
 * Currently empty, but should include common things like playerCount, a chess board, etc.
 * Also abstract methods like gameOver, restart, undo moves, etc. that are common across all setups.
 * @author Rishi Girish (rgirish2ATillinoisDOTedu)
 *
 */
public abstract class AbstractGame {
	/**
	 * Variables used to represent the state of the game.
	 */
	private boolean isGameOver;
	private int currentPlayerOrdinal;
	private final String [] playerNames;
	
	
	public AbstractGame(String [] playerNames) {
		this.isGameOver = false;
		this.playerNames = playerNames;
	}
	
	/**
	 * Abstract method that allows users to undo the
	 * last move in this chess game.
	 */
	public abstract boolean undoLastMove();
	
	/**
	 * Method to restart the current game for the players.
	 */
	public abstract boolean restartGame();
	
	/**
	 * The ordinal for the player whose move is next.
	 * @return The ordinal of the next player move.
	 */
	public int getCurrentPlayerOrdinal() {
		return this.currentPlayerOrdinal;
	}
	
	/**
	 * Checks whether the game is over or not based on the king.
	 * @return True if the game is over, false otherwise.
	 */
	public boolean isIsGameOver() {
		return this.isGameOver;
	}
	
	/**
	 * Sets the player ordinal whose move is next.
	 * @param currentPlayerOrdinal The ordinal for the player whose move is next.
	 */
	public void setCurrentPlayerOrdinal(int currentPlayerOrdinal) {
		this.currentPlayerOrdinal = currentPlayerOrdinal;
		return;
	}
	
	/**
	 * Sets the isGameOver for the current Game.
	 * @param isGameOver Whether the game is over or not.
	 */
	public void setIsGameOver(boolean isGameOver) {
		this.isGameOver = isGameOver;
		return;
	}
	
	/**
	 * Get the list of playerNames who are playing the current game.
	 * The order in the list is representative of the ordinal of the player.
	 * @return An array containing names of the players.
	 */
	public String [] getPlayerNames() {
		return playerNames;
	}
}
