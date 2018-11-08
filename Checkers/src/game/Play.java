package game;

import java.util.Scanner;

public class Play {
	
	private Board board = new Board();
	private Player p1 = new Player(Direction.UP);
	private Player p2 = new Player(Direction.DOWN);
	
	// The name collector and side selection method for the players
	
	private void sideSelection() {
		System.out.println("Player 1 type in your name : ");
		Scanner answer1 = new Scanner(System.in);
		p1.setName(answer1.nextLine());
		
		System.out.println();
		
		System.out.println("Player 2 type in your name : ");
		Scanner answer2 = new Scanner(System.in);
		p2.setName(answer2.nextLine());
		
		System.out.println();
		
		boolean validIndex = false;
		
		while(validIndex == false) {
			System.out.println(p1.getName() + " please select 1 for white or 2 for black : ");
			Scanner answerSide = new Scanner(System.in);
			switch(answerSide.nextLine()) {
				case "1":
					p1.setSide(Side.WHITE);
					p2.setSide(Side.BLACK);
					validIndex = true;
					break;
					
				case "2":
					p1.setSide(Side.BLACK);
					p2.setSide(Side.WHITE);
					validIndex = true;
					break;
				
				default :
					validIndex = false;
					break;
			}
		}
	}
	
	private void setPiecesOnBoard() {
		int indexP1 = 0;
		for(int i = 7 ; i > 4 ; i--) {
			if(i % 2 != 0) {
				for(int j = 0 ; j < board.getColNumber() ; j = j + 2 ) {
					board.getCell(i, j).setPiece(p1.getPieceAtIndex(indexP1));
					indexP1++;
				}
			}
			else {
				for(int j = 1 ; j < board.getColNumber() ; j = j + 2 ) {
					board.getCell(i, j).setPiece(p1.getPieceAtIndex(indexP1));
					indexP1++;
				}
			}		
		}
		
		int indexP2 = 0;
		for(int i = 0 ; i < 3 ; i++) {
			if(i % 2 == 0) {
				for(int j = 1 ; j < board.getColNumber() ; j = j + 2 ) {
					board.getCell(i, j).setPiece(p2.getPieceAtIndex(indexP2));
					indexP2++;
				}
			}
			else {
				for(int j = 0 ; j < board.getColNumber() ; j = j + 2 ) {
					board.getCell(i, j).setPiece(p2.getPieceAtIndex(indexP2));
					indexP2++;
				}
			}		
		}
	}	
	
	private void play() {
		sideSelection();
		p1.setPieceArray();
		p2.setPieceArray();
		setPiecesOnBoard();
		
		p1.move(board, "a3", "b4");
		p1.move(board, "b4", "c5");
		p2.move(board, "b6", "d4");
		board.display();
	}
	
	public static void main(String args[]) {
		new Play().play();
	}
}
