package tushar.dp.questions.set_3.ques_21;
public class Ques_21 { 
    static int minJumps(int arr[], int start, int end) 
    { 
        if (end == start) 
            return 0; 
        if (arr[start] == 0) 
            return Integer.MAX_VALUE; 

        int min = Integer.MAX_VALUE; 
        for (int i = start + 1; i <= end && i <= start + arr[start]; i++) { 
            int jumps = minJumps(arr, i, end); 
            if (jumps != Integer.MAX_VALUE && jumps < min) 
                min = jumps; 
        } 
        return min+1; 
    } 
  
    public static void main(String args[]) 
    { 
        int arr[] = { 1, 3, 6, 3, 2, 3, 6, 8, 9, 5 }; 
        int n = arr.length; 
        System.out.print("Minimum number of jumps to reach end is "
                         + minJumps(arr, 0, n - 1)); 
    } 
} 