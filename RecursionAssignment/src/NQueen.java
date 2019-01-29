public class NQueen 
{
	
	/*
	 * canPlace method used to check the place is suitable to place the queen or not
	 * @param board array of type integer 
	 * @param row of type integer which represents which row in which queen to be 
	 * 			placed assumes row should not be null
	 * @param column in which queen to be placed assumes column should not be null
	 * @return true if position to place the queen is valid or false if not
	 */
	static boolean canPlace(int[][] board, int row, int column)
	{
		try
		{
			int index1,index2;
			
			
			int length = board.length;
				
			//loop will check for the column in which queen is available or not
			for( index1=0;index1<length;index1++)
				if(board[index1][column]==1)
					return false;
				
			//below 2 loops will check the left diagonal in which no other queen should be present
			for( index1=row,index2=column;index1>=0 && index2>=0;index1--,index2--)
				if(board[index1][index2] == 1)
					return false;
						
			for( index1=row,index2=column;index1<length && index2>=0;index1++,index2--)
				if(board[index1][index2] == 1)
					return false;
			
			//below 2 loops will check the right diagonal in which no other queen should be present
			for(index1=row,index2=column;index1>=0 && index2<length;index1--,index2++)
				if(board[index1][index2]==1)
					return false;
			
			for(index1=row,index2=column;index1<length && index2<length;index1++,index2++)
				if(board[index1][index2]==1)
					return false;
			
			//finally return true if the place is valid
			return true;
		}
		
		catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException)
		{
			throw arrayIndexOutOfBoundsException;
		}
		
	}
	
	/*
	 * solveNQueen method to solve the NQueen problem using recursion
	 * @param board array of type integer
	 * @param startRow which state the starting row in which queen should be placed first
	 * @param dimensionMatrix is the size of the board or the matrix 
	 * @return the boolean value true of solution is possible or false if not 
	 */
	
	static boolean solveNQueen(int[][] board, int startRow, int dimensionMatrix)
	{
		try
		{
			int columnindex;
			
			if(dimensionMatrix == 0)
			{
				return true;
			}
			
			int size=board.length;
			
				
				for(columnindex=0 ; columnindex < size ; columnindex++)
				{
					//condition will check whether queen can be placed at passed position or not
					if(canPlace(board, startRow, columnindex))
					{
						
						board[startRow][columnindex] = 1;
						dimensionMatrix -= 1;
						
						if(startRow == size-1)
							startRow=-1;
						
						//recursively call to solve NQueen problem
						if(solveNQueen(board, startRow+1, dimensionMatrix))
						{
							return true;
						}
						
						//if condition is false then should re-assign 0 to previous step
						if(startRow == -1)
						{
							startRow = size-1;
						}
						
						board[startRow][columnindex] = 0;
						dimensionMatrix = dimensionMatrix + 1;
						
					}
					
				}
				
				//finally return false if no solution is found
				return false;
		}
		
		catch(ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException)
		{
			throw arrayIndexOutOfBoundsException;
		}
	}
	
	
	
	
	
}