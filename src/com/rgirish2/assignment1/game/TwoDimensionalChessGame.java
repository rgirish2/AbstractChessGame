package com.rgirish2.assignment1.game;

import java.util.ArrayList;
import java.util.List;

import com.rgirish2.assignment1.board.AbstractTwoDimensionalBoard;
import com.rgirish2.assignment1.board.EightByEightBoard;
import com.rgirish2.assignment1.piece.AbstractPieceSet;
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
	
	private final AbstractPlayer [] players;
	private final List<AbstractPieceSet> allPieceSet;
	private AbstractTwoDimensionalBoard chessBoard;
	
	public TwoDimensionalChessGame(String [] playerNames) {
		this.players = new NormalChessPlayer[playerCount];
		this.chessBoard = new EightByEightBoard();
		this.allPieceSet = new ArrayList<AbstractPieceSet>();
		
		for (int i = 0; i < playerCount; i++) {
			players[i] = new NormalChessPlayer(playerNames[i], i + 1);
			allPieceSet.add(players[i].getPieceSet());
		}
		this.chessBoard.buildBoard(this.allPieceSet);
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
		boolean isPossible = this.chessBoard.moveTile(curPosX, curPosY, newPosX, newPosY);
		return isPossible;
	}

//	public static void main (String [] args) {
//		System.out.println("Welcome to my world of Chess!!");
//		String [] names = {"rishi", "girish"};
//	
//		TwoDimensionalChessGame game = new TwoDimensionalChessGame(names);
//		
//		System.out.println(game.getBoard());
		
/*		
		System.out.println("=======================================================================================================");
		
		System.out.println(game.chessBoard.moveTile(4, 1, 4, 3));
		
		System.out.println(game.chessBoard);
		System.out.println("=======================================================================================================");
		
		System.out.println(game.chessBoard.moveTile(4, 0, 4, 1));
		
		System.out.println(game.chessBoard);
		System.out.println("=======================================================================================================");
		
		System.out.println(game.chessBoard.moveTile(4, 1, 4, 2));
		
		System.out.println(game.chessBoard);
		System.out.println("=======================================================================================================");
		
		System.out.println(game.chessBoard.moveTile(4, 2, 3, 2));
		
		System.out.println(game.chessBoard);
		System.out.println("=======================================================================================================");
		
		System.out.println(game.chessBoard.moveTile(3, 2, 2, 2));
		
		System.out.println(game.chessBoard);
		System.out.println("=======================================================================================================");
		
		System.out.println(game.chessBoard.moveTile(2, 2, 1, 3));
		
		System.out.println(game.chessBoard);
		System.out.println("=======================================================================================================");
		
		System.out.println(game.chessBoard.moveTile(1, 3, 0, 4));
		
		System.out.println(game.chessBoard);
		System.out.println("=======================================================================================================");
		
		System.out.println(game.chessBoard.moveTile(0, 4, 0, 5));
		
		System.out.println(game.chessBoard);
		
		System.out.println("=======================================================================================================");
		
		System.out.println(game.chessBoard.moveTile(0, 5, 0, 6));
		
		System.out.println(game.chessBoard);
		System.out.println("=======================================================================================================");
*/		
//		return;
//	}
}
