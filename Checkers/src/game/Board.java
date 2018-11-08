package game;

public class Board {
	
	private final int rowNumber = 8;
	private final int colNumber = 8;
	private Cell boardArray[][] = new Cell[rowNumber][colNumber];
	private final char colLetters[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
	
	public Board() {
		
		for(int i = 0 ; i < rowNumber ; i++) {
			for(int j = 0 ; j < colNumber ; j++) {
				boardArray[i][j] = new Cell(i, j);
				boardArray[i][j].setPiece(new Space());
			}
		}
		
	}
	
	public void display() {
		System.out.print("  ");
		for(int i = 0 ; i < colNumber ; i++) {
			System.out.print("  " + colLetters[i] + "  ");
		}
		System.out.println();
		int lineIndex = 8;
		System.out.println("   ---------------------------------------");
		for(int i = 0 ; i < rowNumber ; i++) {
			System.out.print(lineIndex);
			System.out.print(" | ");
			for(int j = 0 ; j < colNumber ; j++) {
				System.out.print(boardArray[i][j].getPiece().getSymbol());
				System.out.print(" | ");
			}
		System.out.print(lineIndex);
		lineIndex--;
		System.out.println();
		System.out.println("   ---------------------------------------");
		}
		System.out.print("  ");
		for(int j = 0 ; j < colNumber ; j++) {
			System.out.print("  " + colLetters[j] + "  ");
		}
		System.out.println();
		System.out.println();
	}
	
	public int getColNumber() {
		return colNumber;
	}
	
	public int getRowNumber() {
		return rowNumber;
	}
	
	public Cell getCell(int row, int col) {
		return boardArray[row][col];
	}
	
	public Cell getCell(String pos) {
		int row = 8 - Character.getNumericValue(pos.charAt(1));
		int col = 0;
		
		for(int i = 0 ; i < colNumber ; i++) {
			if(pos.charAt(0) == colLetters[i]) {
				col = i;
			}
		}
		
		return boardArray[row][col];
	}
	
	public int getCellRow(String pos) {
		return 8 - Character.getNumericValue(pos.charAt(1));
	}
	
	public int getCellCol(String pos) {
		int col = 0;
		
		for(int i = 0 ; i < colNumber ; i++) {
			if(pos.charAt(0) == colLetters[i]) {
				col = i;
			}
		}
		return col;
	}
	
	public String intCoordToString(int row, int col) {
		String sRow = Integer.toString(8 - row);
		String sCol = Character.toString(colLetters[col]);
		
		return sRow + sCol;
	}
	
}
