public class Pyatnashki{
    static boolean canSolve(int[][] array){
        int status, sum = 0;

        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                status = 0;
                if(array[i][j] == 0){
                    sum += i * array.length + j + 1;
                }
                else{

                    sum += help(array, i, j);
                }
            }
        }
        if(sum % 2 != 0)
            return false;
        return true;
    }
    static int help(int[][] array, int a, int b){
        int status = 0;
        int b1 = b;
        for(int i = a; i < array.length; i++){
            for(int j = b; j < array[i].length; j++){
                if(array[a][b1] > array[i][j] && array[i][j] != 0){
                    ++status;
                }
            }
            b = 0;
        }
        return status;
    }
}