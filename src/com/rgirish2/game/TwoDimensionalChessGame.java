package com.rgirish2.game;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

import com.rgirish2.assignment1.board.AbstractTwoDimensionalBoard;
import com.rgirish2.assignment1.board.EightByEightBoard;
import com.rgirish2.assignment1.movementValidity.TwoDimensionMovementsValidator;
import com.rgirish2.assignment1.piece.AbstractPieceSet;
import com.rgirish2.assignment1.piece.AbstractTwoDimensionalPiece;
import com.rgirish2.assignment1.piece.NormalPlayerOrdinal;
import com.rgirish2.assignment1.player.AbstractPlayer;
import com.rgirish2.assignment1.player.NormalChessPlayer;

/**
 * This would represent the normal 2 player, 2 dimensional 8X8 chess game.
 * Would encapsulate all the logic about game win, restart, loss, etc.
 * @author Rishi Girish (rgirish2ATillinoisDOTedu)
 *
 */
public class TwoDimensionalChessGame extends AbstractGame {
	private final int playerCount = 2;
	
	private AbstractPlayer [] players;
	private List<AbstractPieceSet> allPieceSet;
	private AbstractTwoDimensionalBoard chessBoard;
	
	/**
	 * Need 4 separate stacks because Java is snobbish about the concept of
	 * pairs and I am lazy to write my own pair class.
	 */
	private Deque<Integer> oldPosXStack;
	private Deque<Integer> oldPosYStack;
	private Deque<Integer> newPosXStack;
	private Deque<Integer> newPosYStack;
		
	public TwoDimensionalChessGame(String [] playerNames) {
		super(playerNames);

		this.oldPosXStack = new ArrayDeque<Integer>();
		this.oldPosYStack = new ArrayDeque<Integer>();
		this.newPosXStack = new ArrayDeque<Integer>();
		this.newPosYStack = new ArrayDeque<Integer>();
		
		this.init();
	}
	
	/**
	 * Initializes the chess pieces from scratch and sets up the current chess board.
	 * Should be called only when initializing or reinitializing the chess board.
	 * Bear in mind that calling this method will override all the changes made in
	 * the current game. 
	 * @throws IllegalArgumentException When the pieceset being used is not supported by the current chess board.
	 */
	private void init() throws IllegalArgumentException {
		
		this.players = new NormalChessPlayer[this.playerCount];
		this.chessBoard = new EightByEightBoard();
		this.allPieceSet = new ArrayList<AbstractPieceSet>();
		
		String [] playerNames = this.getPlayerNames();
		for (int i = 0; i < this.playerCount; i++) {
			this.players[i] = new NormalChessPlayer(playerNames[i], i + 1);
			allPieceSet.add(players[i].getPieceSet());
		}
		
		try {
			this.chessBoard.buildBoard(allPieceSet);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(e);
		}
			
		this.setCurrentPlayerOrdinal(1);
	}
	
	/**
	 * The number of players playing the game.
	 * @return The number of players playing the game.
	 */
	public int getPlayerCount() {
		return this.playerCount;
	}
	
	/**
	 * The chess board the game is being played on.
	 * @return The 2 dimensional chess board.
	 */
	public AbstractTwoDimensionalBoard getBoard() {
		return this.chessBoard;
	}
	
	/**
	 * Request to move a chess piece on this 2-D chess board.
	 * @param curPosX The current X position of the chess piece.
	 * @param curPosY The current Y position of the chess piece.
	 * @param newPosX The new X position of the chess piece.
	 * @param newPosY The new Y position of the chess piece.
	 * @return True if the move was successful, False otherwise.
	 */
	public boolean movePiece(int curPosX, int curPosY, int newPosX, int newPosY) {
		if (!this.isIsGameOver()) {
			if (isCorrectPlayerMove(curPosX, curPosY, newPosX, newPosY)) {
				boolean isPossible = this.chessBoard.moveTile(curPosX, curPosY, newPosX, newPosY);
				if (isPossible) {
					this.oldPosXStack.push(curPosX);
					this.oldPosYStack.push(curPosY);
					this.newPosXStack.push(newPosX);
					this.newPosYStack.push(newPosY);
					int currentPlayerOrdinal = this.getCurrentPlayerOrdinal();
					this.setCurrentPlayerOrdinal(currentPlayerOrdinal == 1 ? 2 : 1);
				}
				return isPossible;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	/**
	 * Verifies whether the piece requested to be moved is for the player whose turn is in the game.
	 * @param curPosX The current X position of the chess piece.
	 * @param curPosY The current Y position of the chess piece.
	 * @param newPosX The new X position of the chess piece.
	 * @param newPosY The new Y position of the chess piece.
	 * @return True if the move is for the correct player, False otherwise.
	 */
	private boolean isCorrectPlayerMove(int curPosX, int curPosY, int newPosX, int newPosY) {
		try {
			if (TwoDimensionMovementsValidator.isWithinRange(this.chessBoard, curPosX, curPosY, newPosX, newPosY)) {
				AbstractTwoDimensionalPiece piece = this.chessBoard.getBoard()[curPosX][curPosY].getPiece();
				if (piece != null) {
					int pieceMovementOrdinal = NormalPlayerOrdinal.getOrdinal(piece.getOrdinal());
					if (pieceMovementOrdinal == this.getCurrentPlayerOrdinal()) {
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}
			} else {
				return false;
			}
		} catch (NullPointerException e) {
			return false;
		}
	}

	/**
	 * Allows the players to undo their last move. Also takes care of the correct player move after an undo.
	 */
	@Override
	public boolean undoLastMove() {
		try {
			this.init();
		} catch (IllegalArgumentException e) {
			return false;
		}
		
		this.oldPosXStack.pop();
		this.oldPosYStack.pop();
		this.newPosXStack.pop();
		this.newPosYStack.pop();
		
		Iterator <Integer> oldPosXIterator = this.oldPosXStack.iterator();
		Iterator <Integer> oldPosYIterator = this.oldPosYStack.iterator();
		Iterator <Integer> newPosXIterator = this.newPosXStack.iterator();
		Iterator <Integer> newPosYIterator = this.newPosYStack.iterator();
		
		while (oldPosXIterator.hasNext() && oldPosYIterator.hasNext() && newPosXIterator.hasNext() && newPosYIterator.hasNext()) {
			int oldPosX = oldPosXIterator.next();
			int oldPosY = oldPosYIterator.next();
			int newPosX = newPosXIterator.next();
			int newPosY = newPosYIterator.next();
			boolean result = this.chessBoard.moveTile(oldPosX, oldPosY, newPosX, newPosY);
			if (!result) {
				return false;
			}
			int currentPlayerOrdinal = this.getCurrentPlayerOrdinal();
			this.setCurrentPlayerOrdinal(currentPlayerOrdinal == 1 ? 2 : 1);
		}		
		return true;
	}
	
	/**
	 * Allows players to restart the game.
	 */
	@Override
	public boolean restartGame() {
		try {
			this.init();
			this.oldPosXStack = new ArrayDeque<Integer>();
			this.oldPosYStack = new ArrayDeque<Integer>();
			this.newPosXStack = new ArrayDeque<Integer>();
			this.newPosYStack = new ArrayDeque<Integer>();
			
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}
}
