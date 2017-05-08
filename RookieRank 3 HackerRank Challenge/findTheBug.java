import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[] findTheBug(String[] grid){
        int[] posi = new int[2];
        for(int i = 0; i < grid.length; i++){
            if(grid[i].contains("X")){ //row of X
                posi[0] = i;
                posi[1] = grid[i].indexOf('X'); //column that of X
                break;
            }
        }
        return posi; //returning position
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] grid = new String[n];
        for(int grid_i=0; grid_i < n; grid_i++){
            grid[grid_i] = in.next();
        }
        // Return an array containing [r, c]
        int[] result = findTheBug(grid);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? "," : ""));
        }
        System.out.println("");
    }
}
