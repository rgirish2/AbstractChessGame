package com.rgirish2.board;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Before;
import org.junit.Test;

import com.rgirish2.assignment1.piece.AbstractPiece;
import com.rgirish2.assignment1.piece.AbstractPieceSet;
import com.rgirish2.assignment1.player.AbstractPlayer;
import com.rgirish2.assignment1.player.NormalChessPlayer;

public class EightByEightBoardTest {
	
	AbstractTwoDimensionalBoard chessBoard;
	List<AbstractPieceSet> allPieceSet;
	AbstractPlayer [] players;
	private int playerCount = 0;
	
	private void customPlayerCount(int playerCount) {
		this.chessBoard = new EightByEightBoard();
		allPieceSet = new ArrayList<AbstractPieceSet>();
		players = new NormalChessPlayer[playerCount];
		
		for (int i = 0; i < playerCount; i++) {
			players[i] = new NormalChessPlayer("", i + 1);
			allPieceSet.add(players[i].getPieceSet());
		}
	}
	
	@Before
	public void init() {
		this.chessBoard = new EightByEightBoard();
		allPieceSet = new ArrayList<AbstractPieceSet>();
		players = new NormalChessPlayer[playerCount];
		
		for (int i = 0; i < playerCount; i++) {
			players[i] = new NormalChessPlayer("", i + 1);
			allPieceSet.add(players[i].getPieceSet());
		}	
	}
	
	@Test
	public void buildBoardTestZeroPlayer() {
		this.chessBoard.buildBoard(this.allPieceSet);
		for (int i = 0; i < this.chessBoard.getDimensionOne(); i++) {
			for (int j = 0; j < this.chessBoard.getDimensionTwo(); j++) {
				assert (this.chessBoard.board[i][j]) == null;
			}
		}
	}
	
	@Test
	public void buildBoardTestOnePlayer() {
		this.customPlayerCount(1);
		this.chessBoard.buildBoard(this.allPieceSet);
		
		for (int i = 0; i < this.chessBoard.getDimensionOne(); i++) {
			for (int j = 0; j < this.chessBoard.getDimensionTwo(); j++) {
				if (j == 0 || j == 1) {
					IsInstanceOf.instanceOf(AbstractPiece.class);
				} else {
					assert (this.chessBoard.board[i][j]) == null;
				}
			}
		}
	}
	
	@Test
	public void buildBoardTestTwoPlayer() {
		this.customPlayerCount(2);
		this.chessBoard.buildBoard(this.allPieceSet);
		
		for (int i = 0; i < this.chessBoard.getDimensionOne(); i++) {
			for (int j = 0; j < this.chessBoard.getDimensionTwo(); j++) {
				if (j == 0 || j == 1 || j == 6 || j == 7) {
					IsInstanceOf.instanceOf(AbstractPiece.class);
				} else {
					assert (this.chessBoard.board[i][j]) == null;
				}
			}
		}
	}
}
