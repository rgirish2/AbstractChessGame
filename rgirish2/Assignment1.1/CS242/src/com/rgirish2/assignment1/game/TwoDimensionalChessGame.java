package com.rgirish2.assignment1.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
	
	private AbstractPlayer [] players;
	private AbstractTwoDimensionalBoard chessBoard;
	private List<AbstractPieceSet> allPieceSet;
	
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
	
	public int getPlayerCount() {
		return this.playerCount;
	}
	
	public AbstractTwoDimensionalBoard getBoard() {
		return this.chessBoard;
	}
	
	public static void main (String [] args) {
		System.out.println("Welcome to my world of Chess!!");
//		boolean isGameRunning = true;

		String [] names = new String[2];
		
		Scanner in = new Scanner(System.in);
		
		for (int i = 0; i < 2; i++)
			names[i] = in.nextLine();
		
		TwoDimensionalChessGame game = new TwoDimensionalChessGame(names);
		
		System.out.println(game.chessBoard);
		/*		
		while (isGameRunning) {
			
		}
	
		Scanner in = new Scanner(System.in);
		int newX = in.nextInt();
		int newY = in.nextInt();
		
		try {
			chessBoard.moveTile(3, 1, newX, newY);
		} catch (Exception e) {
			e.printStackTrace();
		}
*/		
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
		
		return;
	}
}
