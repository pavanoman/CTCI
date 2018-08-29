//Solution 1:
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return false;
        
        int row=0;
        int col=matrix[0].length-1;
        
        while(row < matrix.length && col>=0){
            
            if(matrix[row][col]==target) return true;
            else if (matrix[row][col] < target) row++; // search next row
            else col--; //search same row
        }
        return false;
  
    }
}

//Time complexity : O(m+n)

//Solution 2: (Optimized):

public boolean searchMatrix(int[][] matrix, int target) {
	
	int row_num = matrix.length;
	int col_num = matrix[0].length;
	
	int begin = 0, end = row_num * col_num - 1;
	
	while(begin <= end){
		int mid = (begin + end) / 2;
		int mid_value = matrix[mid/col_num][mid%col_num];
		
		if( mid_value == target){
			return true;
		
		}else if(mid_value < target){
			//Should move a bit further, otherwise dead loop.
			begin = mid+1;
		}else{
			end = mid-1;
		}
	}
	
	return false;
}
/*
0, 1, 2
3, 4, 5  -->  0, 1, 2, 3, 4, 5, 6, 7, 8
6, 7, 8

Hence, matrix1[i][j] becomes matrix2[i * col_num + j], where i, j = 0, 1, 2, col_num = 3. Denote i * col_num + j by mid, then i = mid / col_num, and j = mid % col_num, hence matrix2[mid] = matrix1[mid / col_num][mid % col_num] = matrix1[i][j].

complexity of the solution is O(log(mn)) = O(log(m) + log(n))

*/
