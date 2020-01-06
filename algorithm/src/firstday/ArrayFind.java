package firstweek;

public class ArrayFind {

    public static void main(String[] args) {

    }

    public boolean Find(int target, int [][] array) {
        int rows = array.length;
        int cols = array[0].length;
        int i=rows-1,j=0;
        while(i>=0 && j<cols){
            if(target<array[i][j])
                i--;
            else if(target>array[i][j])
                j++;
            else
                return true;
        }
        return false;
    }

    public static boolean arrayFind(int target, int[][] array) {
        int i = array.length / 2;
        int j = array.length / 2;
        int temp = array[i][j];
        while (target != temp) {
            if (target > temp) {
                i++;
                j++;
                if (target == temp) {
                    return true;
                } else if (target < temp) {
                    while (target != array[i][j - 1]) {
                        i++;
                        if (target == temp) {
                            return true;
                        }
                        if (i == array.length) {
                            break;
                        }
                    }
                    while (target != array[0][j]) {
                        i++;
                        if (target == temp) {
                            return true;
                        }
                        if (i == array.length) {
                            break;
                        }
                    }
                }
            } else {
                i--;
                j--;
                if (target == temp) {
                    return true;
                } else if (target < temp) {
                    while (target != array[i][j - 1]) {
                        i++;
                        if (target == temp) {
                            return true;
                        }
                        if (i == array.length) {
                            break;
                        }
                    }
                    while (target != array[0][j]) {
                        i++;
                        if (target == temp) {
                            return true;
                        }
                        if (i == array.length) {
                            break;
                        }
                    }
                }
            }
        }
        return  false;
    }
}
