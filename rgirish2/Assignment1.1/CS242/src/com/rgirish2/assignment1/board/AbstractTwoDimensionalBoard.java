package com.rgirish2.assignment1.board;

import java.util.ArrayList;

import com.rgirish2.assignment1.piece.AbstractTwoDimensionalPiece;
import com.rgirish2.assignment1.tile.SquareTile;

/**
 * Class representing any kind of two dimensional chess boards. 
 * @author Rishi Girish (rgirish2ATillinoisDOTedu)
 *
 */
public abstract class AbstractTwoDimensionalBoard extends AbstractBoard {
	private final int dimensionOne;
	private final int dimensionTwo;
	private static final int currentDimensionCount = 2;
	protected SquareTile [][] board;
	
	/**
	 * Constructor for a chess board in two dimensions.
	 * @param dimensionOne
	 * @param dimensionTwo
	 * @param playerCount
	 */
	public AbstractTwoDimensionalBoard(int dimensionOne, int dimensionTwo, int playerCount) {
		this.dimensionCount = currentDimensionCount;
		this.dimensions = new ArrayList<Integer>();
		this.dimensions.add(0, dimensionOne);
		this.dimensions.add(1, dimensionTwo);
		this.dimensionOne = dimensionOne;
		this.dimensionTwo = dimensionTwo;
		this.playerCount = playerCount;
		
		this.board = new SquareTile[dimensionOne][dimensionTwo];
	}
	
	/**
	 * Returns the value of dimensionOne. This represents X axis in the euclidean plane.
	 * @return the value of dimensionTwo.
	 */
	public int getDimensionOne() {
		return dimensionOne;
	}
	
	/**
	 * Returns the value of dimensionTwo. This represents Y axis in the euclidean plane.
	 * @return the value of dimensionTwo.
	 */
	public int getDimensionTwo() {
		return dimensionTwo;
	}
	
	/**
	 * Returns the current chess board in it's present state as a 2-dimensional grid of square tiles.
	 * @return A 2 dimensional array of square tiles representing a chess board.
	 */
	public SquareTile [][] getBoard() {
		return this.board;
	}
	
	/**
	 * Moves a tile on the board from the old position to the new position.
	 * @param oldX The old X position of the tile.
	 * @param oldY The old Y position of the tile.
	 * @param newX The new X position of the tile.
	 * @param newY The new Y position of the tile.
	 * @throws Exception Throws exception on invalid moves.
	 */
	
	//TODO: Implement custom exception handling and propagating the exception upstream. Add better exception messages.
	public boolean moveTile (int oldX, int oldY, int newX, int newY) {
		if (this.board == null || this.board[oldX][oldY] != null) {
			AbstractTwoDimensionalPiece piece = board[oldX][oldY].getPiece();
			if (piece != null) {
				if (piece.isValidMove(this, newX, newY)) {
					this.board[newX][newY] = this.board[oldX][oldY];
					this.board[newX][newY].setMarked(false);
					this.board[newX][newY].getPiece().setPosX(newX);
					this.board[newX][newY].getPiece().setPosY(newY);
					this.board[oldX][oldY] = null;
					return true;
				} else {
//					throw new Exception("Incorrect movement for the piece.");
					return false;
				}
			} else {
//				throw new Exception("Current tile is empty. Incorrect movement request.");
				return false;
			}
		} else {
//			throw new Exception("Uninitialized board. Cannot make this request.");
			return false;
		}
	}
}
