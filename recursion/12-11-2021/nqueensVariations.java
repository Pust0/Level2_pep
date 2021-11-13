class nqueensVariations{
	
	public static boolean isSafe(boolean[][] board, int sr, int sc) {
		int n=board.length, m=board[0].length;
		int dir[][]={{0,-1}, {-1,0}, {-1,-1}, {-1,1}};
		
		for(int[] d: dir) {
			int r=sr, c=sc;
			
			while(r>=0 && c>=0 && r<n && c<m) {
				if(board[r][c])	return false;
				r+=d[0];
				c+=d[1];
			}
		}
		
		return true;
	}
	
	public static boolean isSafePerm(boolean[][] board, int sr, int sc) {
		int n=board.length, m=board[0].length;
		int dir[][]={{0,-1}, {-1,0}, {-1,-1}, {-1,1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
		
		for(int[] d: dir) {
			int r=sr, c=sc;
			
			while(r>=0 && c>=0 && r<n && c<m) {
				if(board[r][c])	return false;
				r+=d[0];
				c+=d[1];
			}
		}
		
		return true;
	}
		
	public static void nqueens_comb_unop(boolean[][] board, int tq, int row, int col, String ans) {
		if(tq==0){
			System.out.println(ans);
			return;
		}

		if(col==board[0].length){
			row++;
			col=0;
		}

		if(row==board.length)	return;

		if(isSafePerm(board, row, col)) {
			board[row][col]=true;
			nqueens_comb_unop(board, tq-1, row, col+1, ans+"("+row+", "+col+")");
			board[row][col]=false;
		}
		nqueens_comb_unop(board, tq, row, col+1, ans);
	}
	
	public static int nqueens_perm_unop(boolean[][] board, int tq, int row, int col, String ans) {
		if(tq==0){
			System.out.println(ans);
			return 1;
		}

		if(col==board[0].length){
			row++;
			col=0;
		}

		if(row==board.length)	return 0;

		int count=0;
		if(isSafePerm(board, row, col)) {
			board[row][col]=true;
			count+=nqueens_perm_unop(board, tq-1, 0, 0, ans+"("+row+", "+col+")");
			board[row][col]=false;
		}
		count+=nqueens_perm_unop(board, tq, row, col+1, ans);
		
		return count;
	}
	
	public static void nqueens_comb(boolean[][] board, int tq, int row, int col, String ans, boolean[] rows, boolean[] cols, boolean[] diag, boolean[] adiag){
		
		if(tq==0){
			System.out.println(ans);
			return;
		}

		if(col==board[0].length){
			row++;
			col=0;
		}

		if(row==board.length)	return;

		if(!rows[row] && !cols[col] && !diag[row+col] && !adiag[row-col+board[0].length-1]){
			rows[row]=cols[col]=diag[row+col]=adiag[row-col+board[0].length-1]=true;
			nqueens_comb(board, tq-1, row, col+1, ans+"("+row+", "+col+")", rows, cols, diag, adiag);
			rows[row]=cols[col]=diag[row+col]=adiag[row-col+board[0].length-1]=false;
		}
		nqueens_comb(board, tq, row, col+1, ans, rows, cols, diag, adiag);
	}

	public static int nqueens_perm(boolean[][] board, int tq, int row, int col, String ans, boolean[] rows, boolean[] cols, boolean[] diag, boolean[] adiag){
		
		if(tq==0){
			System.out.println(ans);
			return 1;
		}

		if(col==board[0].length){
			row++;
			col=0;
		}

		if(row==board.length)	return 0;

		int count=0;
		if(!rows[row] && !cols[col] && !diag[row+col] && !adiag[row-col+board[0].length-1]){
			rows[row]=cols[col]=diag[row+col]=adiag[row-col+board[0].length-1]=true;
			count+=nqueens_perm(board, tq-1, 0, 0, ans+"("+row+", "+col+")", rows, cols, diag, adiag);
			rows[row]=cols[col]=diag[row+col]=adiag[row-col+board[0].length-1]=false;
		}
		
		count+=nqueens_perm(board, tq, row, col+1, ans, rows, cols, diag, adiag);
		return count;
	}
	
	//leetcode 52-N Queens 2
	public static int nqueens_comb_op(boolean[][] board, int tq, int row, int col, boolean[] rows, boolean[] cols, boolean[] diag, boolean[] adiag){
		
		if(tq==0){
			return 1;
		}

		if(col==board[0].length){
			col=0;
		    return 0;
		}

		if(row==board.length)	return 0;
    
        int count=0;
		if(!rows[row] && !cols[col] && !diag[row+col] && !adiag[row-col+board[0].length-1]){
			rows[row]=cols[col]=diag[row+col]=adiag[row-col+board[0].length-1]=true;
			count+=nqueens_comb_op(board, tq-1, row+1, 0, rows, cols, diag, adiag);
			rows[row]=cols[col]=diag[row+col]=adiag[row-col+board[0].length-1]=false;
		}
        count+=nqueens_comb_op(board, tq, row, col+1, rows, cols, diag, adiag);
        
        return count;
	}
	
    public static int nqueensafe(int n, int m , int floor, int nq, boolean[] cols, boolean[] diag, boolean[] adiag)
    {
        if (nq==0 || floor==n)
        {
            if(nq==0)return 1;
            return 0;
        }

        int count = 0;
        for (int rooms = 0; rooms < m; rooms++)
        {
            //we take the 2d array in the form of multiple 1d arrays, and to find the row number and column number, we apply this formula.
            int r=floor, c=rooms;
            if(!cols[c] && !diag[r+c] && !adiag[r-c+m-1])
            {
                cols[c]=diag[r+c]=adiag[r-c+m-1]=true;
                count+=nqueensafe(n,m,floor+1,nq-1,cols,diag,adiag);
                cols[c]=diag[r+c]=adiag[r-c+m-1]=false;
            }
        }
        count+=nqueensafe(n,m,floor+1,nq,cols,diag,adiag);
        return count;
    }

	public static void main(String args[]){
		int n=4, m=4, tq=4;
		
//		nqueens_comb_unop(new boolean[n][m], tq, 0, 0, "");
//		System.out.println(nqueens_perm_unop(new boolean[n][m], tq, 0, 0, ""));
		
		boolean[] rows=new boolean[n];
		boolean[] cols=new boolean[m];
		boolean[] diag=new boolean[n+m-1];
		boolean[] adiag=new boolean[n+m-1];

//		 nqueens_comb(new boolean[n][m], tq, 0, 0, "", rows, cols, diag, adiag);
		// System.out.println(nqueens_perm(new boolean[n][m], tq, 0, 0, "", rows, cols, diag, adiag));
	}
	
	
	//leetcode 51 - N Queens 1
	class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] grid = new boolean[n][n];
        List<List<String>> result = new ArrayList<>();
        explore(grid, result, n, 0);
        return result;
    }
    
    void explore(boolean[][] grid, List<List<String>> result, int n, int row){
        if(n == row){
            result.add(getGridAsListOfStrings(grid));
            return;
        }
        
        for(int i=0; i < n; i++){
            if(canPlaceQueen(grid, row, i, n)){
                grid[row][i] = true;
                explore(grid, result, n, row+1);
                grid[row][i] = false;
            }
        }
    }
    
    boolean canPlaceQueen(boolean[][] grid, int row, int col, int n){
        for(int i=row-1; i >=0; i--)
            if(grid[i][col]) return false;
        
        for(int i=row-1, j=col-1; i >=0 && j >= 0; i--, j--)
            if(grid[i][j]) return false;        
        
        for(int i=row-1, j=col+1; i >=0 && j < n; i--, j++)
            if(grid[i][j]) return false;
        
        return true;
    }
    
    List<String> getGridAsListOfStrings(boolean[][] grid){
        List<String> ans = new ArrayList<>();
        for(int i=0; i < grid.length; i++){
            StringBuilder currRow = new StringBuilder();
            for(int j=0; j < grid.length; j++){
                if(grid[i][j]) 
                    currRow.append("Q");
                else
                    currRow.append(".");
            }
            ans.add(currRow.toString());
        }
        return ans;
    }
}
}
