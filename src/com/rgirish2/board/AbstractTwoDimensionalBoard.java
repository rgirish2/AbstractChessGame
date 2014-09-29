package com.rgirish2.assignment1.board;

import java.util.ArrayList;

import com.rgirish2.assignment1.piece.AbstractTwoDimensionalPiece;
import com.rgirish2.assignment1.tile.SquareTile;

/**
 * Class representing any kind of two dimensional chess boards comprising of square tiles. 
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
	 * @param dimensionOne The first dimension of this 2-dimensional chess board.
	 * @param dimensionTwo The second dimension of this 2-dimensional chess board.
	 * @param playerCount The number of players playing this game.
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
	public boolean moveTile (int oldX, int oldY, int newX, int newY) {
		if (this.board != null || this.board[oldX][oldY] != null) {
			AbstractTwoDimensionalPiece piece = board[oldX][oldY].getPiece();
			if (piece != null) {
				try {
					if (piece.isValidMove(this, newX, newY)) {
						piece.setPosX(newX);
						piece.setPosY(newY);
						
						this.board[newX][newY].setPiece(piece);
						this.board[newX][newY].setMarked(false);
						this.board[newX][newY].setOccupied(true);
						
						this.board[oldX][oldY].setPiece(null);
						this.board[oldX][oldY].setMarked(false);
						this.board[oldX][oldY].setOccupied(false);
						
						piece = null;
						return true;
					} else {
						return false;
					}
				} catch (NullPointerException e) {
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
