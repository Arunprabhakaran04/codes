public class celebrityproblem {

    public static void findcelebrity(int[][] matrix){
        int n = matrix.length;
        int[] knowme = new int[n];
        int[] iknow = new int[n];
        for(int i = 0; i<n; i++){
            for(int j = 0;j<n; j++){
                if (matrix[i][j] == 1){
                    knowme[j]++;
                    iknow[i]++;
                }

            }

        }
        for(int i = 0; i<n; i++){
            if (knowme[i] == n-1 && iknow[i] == 0){
                System.out.println(i);
                return;
            }
        }
        System.out.println("No celebrity");
        return;


    }
    public static void main(String[] args) {
        int[][] matrix = {
            {0,0,1,0},
            {0,0,1,0},
            {0,0,0,0},
            {0,0,1,0}

        };
        findcelebrity(matrix);

    }
}
