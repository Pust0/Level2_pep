public class queenVariations {
	
	//1D
	public static int queen1DCombination(boolean board[], int tq, int idx, int qpsf, String ans) {
		
		if(qpsf==tq) {
			System.out.println(ans);
			return 1;
		}
		
		int count=0;
		for(int i=idx; i<board.length; ++i) {
			count+=queen1DCombination(board, tq, i+1, qpsf+1, ans+"b"+i+"q"+qpsf);
		}
		return count;
	}
	
	public static int queen1DCombination_sub(boolean board[], int tq, int idx, int qpsf, String ans) {
		if(idx==board.length || qpsf==tq) {
			if(qpsf==tq) {
				System.out.println(ans);
				return 1;
			}
			return 0;
		}
		
		int count=0;
		count+=queen1DCombination_sub(board, tq, idx+1, qpsf+1, ans+"b"+idx+"q"+qpsf);
		count+=queen1DCombination_sub(board, tq, idx+1, qpsf, ans);
		return count;
	}
	
	public static int queen1DPermutation(boolean board[], int tq, int idx, int qpsf, String ans) {
		
		if(qpsf==tq) {
			System.out.println(ans);
			return 1;
		}
		
		int count=0;
		for(int i=idx; i<board.length; ++i) {
			if(!board[i]) {
				board[i]=true;
				count+=queen1DPermutation(board, tq, 0, qpsf+1, ans+"b"+i+"q"+qpsf);
				board[i]=false;
			}
		}
		return count;
	}
	
	public static int queen1DPermutation_sub(boolean board[], int tq, int idx, int qpsf, String ans) {
		if(idx==board.length || qpsf==tq) {
			if(qpsf==tq) {
				System.out.println(ans);
				return 1;
			}
			return 0;
		}
		
		int count=0;
		if(!board[idx]) {
			board[idx]=true;
			count+=queen1DPermutation_sub(board, tq, 0, qpsf+1, ans+"b"+idx+"q"+qpsf);
			board[idx]=false;
		}
		count+=queen1DPermutation_sub(board, tq, idx+1, qpsf, ans);
		return count;
	}
	
	//2D
	public static int queen2DCombination(boolean board[][], int tq, int idx, String ans) {
		if(tq==0) {
			System.out.println(ans);
			return 1;
		}
		
		int count=0, n=board.length, m=board[0].length;
		for(int i=idx; i<n*m; ++i) {
			int r=i/m, c=i%m;
			count+=queen2DCombination(board, tq-1, i+1, ans+"("+r+", "+c+")");
		}
		
		return count;
	}
	
	public static int queen2DCombination_sub(boolean board[][], int tq, int row, int col, String ans) {

		if(tq==0) {
			System.out.println(ans);
			return 1;
		}
		
		if(col==board[0].length) {
			row++;
			col=0;
		}
		
		if(row==board.length)	return 0;

		int count=0;
		count+=queen2DCombination_sub(board, tq-1, row, col+1, ans+"("+row+", "+col+")");
		count+=queen2DCombination_sub(board, tq, row, col+1, ans);
		return count;
	}
	
	public static int queen2DPermutation(boolean board[][], int tq, int idx, String ans) {
		if(tq==0) {
			System.out.println(ans);
			return 1;
		}
		
		int count=0, n=board.length, m=board[0].length;
		for(int i=idx; i<n*m; ++i) {
			int r=i/m, c=i%m;
			if(!board[r][c]) {
				board[r][c]=true;
				count+=queen2DPermutation(board, tq-1, 0, ans+"("+r+", "+c+")");
				board[r][c]=false;
			}
		}
		
		return count;
	}
	
	public static int queen2DPermutation_sub(boolean board[][], int tq, int row, int col, String ans) {
		if(tq==0) {
			System.out.println(ans);
			return 1;
		}
		
		if(col==board[0].length) {
			row++;
			col=0;
		}
		
		if(row==board.length)	return 0;

		int count=0;
		if(!board[row][col]) {
			board[row][col]=true;
			count+=queen2DPermutation_sub(board, tq-1, 0, 0, ans+"("+row+", "+col+")");
			board[row][col]=false;
		}
		
		count+=queen2DPermutation_sub(board, tq, row, col+1, ans);
		return count;
	}
	
	public static void main(String[] args) {
		
//		System.out.println(queen1DCombination(new boolean[5], 3, 0, 0, ""));
//		System.out.println(queen1DCombination_sub(new boolean[5], 3, 0, 0, ""));
//		System.out.println(queen1DPermutation(new boolean[5], 3, 0, 0, ""));
//		System.out.println(queen1DPermutation_sub(new boolean[5], 3, 0, 0, ""));
		
		
//		System.out.println(queen2DCombination(new boolean[4][4], 4, 0, ""));
//		System.out.println(queen2DCombination_sub(new boolean[4][4], 4, 0, 0, ""));
//		System.out.println(queen2DPermutation(new boolean[4][4], 4, 0, ""));
		System.out.println(queen2DPermutation_sub(new boolean[4][4], 4, 0, 0, ""));
	}
}
