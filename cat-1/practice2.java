import java.util.*;
public class practice2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //celebrity problem -
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        int[] iknow = new int[n];
        int[] knowme = new int[n];
        for(int i =0; i<n;i++){
            for(int j =0; j<n; j++){
                if(matrix[i][j] == 1){
                    iknow[i] += 1;
                    knowme[j] += 1;
                }
            }
        }
        for(int i = 0; i<n; i++){
            if (iknow[i] == 0 && knowme[i] == n-1){
                System.out.println("celebrity: "+i);
                break;
            }
        }
    }
}
