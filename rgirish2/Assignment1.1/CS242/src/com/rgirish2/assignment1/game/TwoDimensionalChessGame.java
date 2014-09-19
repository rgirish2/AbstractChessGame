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
	
	public static void main (String [] args) {
		System.out.println("Welcome to my world of Chess!!");
//		boolean isGameRunning = true;
		
		int playerCount = 2;
		
		AbstractPlayer [] players = new NormalChessPlayer[playerCount];
		AbstractTwoDimensionalBoard chessBoard = new EightByEightBoard();
		List<AbstractPieceSet> allPieceSet = new ArrayList<AbstractPieceSet>();
		
		for (int i = 0; i < playerCount; i++) {
			players[i] = new NormalChessPlayer("", i + 1);
			allPieceSet.add(players[i].getPieceSet());
		}
		
		chessBoard.buildBoard(allPieceSet);
		
		System.out.println(chessBoard);
/*		
		while (isGameRunning) {
			
		}
*/	
		Scanner in = new Scanner(System.in);
		int newX = in.nextInt();
		int newY = in.nextInt();
		
		try {
			chessBoard.moveTile(3, 1, newX, newY);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("=======================================================================================================");
		
		System.out.println(chessBoard);
		
		return;
	}
}
