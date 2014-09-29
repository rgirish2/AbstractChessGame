package com.rgirish2.board;

import java.util.List;

import com.rgirish2.assignment1.piece.AbstractPieceSet;

/**
 * The primary abstract class that is common among all the chess boards. 
 * @author Rishi Girish (rgirish2ATillinoisDOTedu)
 *
 */
public abstract class AbstractBoard {
	protected int dimensionCount;
	protected List<Integer> dimensions;
	protected int playerCount;
	
	/**
	 * Abstract buildBoard method that is used to build a chess board 
	 * from the list of piece-set passed in.
	 * @param pieceSet The pieceSet used to build this board.
	 */
	public abstract void buildBoard(List<AbstractPieceSet> pieceSet);
	
	/**
	 * Gets the dimensions of this chess board. Should not be negative.
	 * @return the current dimension of the chess board.
	 */
	public int getDimensionCount() {
		return dimensionCount;
	}
	
	/**
	 * Get the max value of each dimension of the chess board.
	 * 
	 * It would be better to encapsulate the dimensions as a dimensions object
	 * and pass that along. 
	 * 
	 * Currently, element at each index in the list represents
	 * the max value in that dimension.
	 * 
	 * Example: List: [5, 10, 4] -> 
	 * 				X(0th)-dimension max Value: 5
	 * 				Y(1st)-dimension max Value: 10
	 * 				Z(2nd)-dimension max Value: 4
	 * And so forth for larger lists.
	 * 
	 * @return A list containing the max values for each dimensions of the board.
	 */
	public List<Integer> getDimensions() {
		return dimensions;
	}
	
	/**
	 * Returns the numbers of players associated with this game.
	 * 
	 * It would be better to keep this information with the game
	 * and not with the chess board. Chess board should be independent of the players.
	 * 
	 * @return The numbers of players currently in this game.
	 */
	public int getPlayerCount() {
		return playerCount;
	}
}
