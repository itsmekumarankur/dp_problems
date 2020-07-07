package cb;


public class Solution {

	public static void main(String[] args) {
		print(5);
	}
	public static void print(int n) {
		//Total No of rows
        for(int row =0; row<n; row++){
            // columns
            for(int j = n-row;j>0;j-- ){
            	System.out.print("* ");
            }
            System.out.println();
        }
  }
}


//Steps: 
/*
	1. Understanding of question & ask Missing info
    	- range of n

	2. put a solution
    3. Time & space complexity
    4. more optimized
    5. Improve Coding Convetion
    6. Error Handling or any missed case
*/