package seminar_5;

import java.util.Random;

public class hw_53 {
    /*
     * +
     * На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга. И
     * вывести Доску. Пример вывода доски 8x8
     * 0x000000
     * 0000x000
     * 00x00000
     */

    public static void main(String[] args) {
        int[][] array = { { 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1 } };
        int num = array.length;
        while (count(array, num) < num) {
            filling(array);
        }
        print(array);
    }

    // метод заполнения
    public static void filling(int[][] arr) {
        Random random = new Random();
        int n = random.nextInt(8);
        int m = random.nextInt(8);

        boolean flag = true;
        while (flag) {

            arr[n][m] = 8;// 3.3
            int nn = n; // 3
            int mm = m; // 3
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[i].length; j++) {
                    if (arr[i][j] != 0 || arr[i][j] != 8) {

                        if (i == n || j == m) {
                            arr[i][j] = 0;

                        }
                    }

                }
            }
            arr[nn][mm] = 8;
            while (n >= 0 && m >= 0) {

                if (arr[n][m] != 0 && arr[n][m] != 8) {
                    arr[n][m] = 0;
                }
                n--;
                m--;
            }
            n = nn;
            m = mm;
            while (n < arr.length && m < arr.length) {

                if (arr[n][m] != 0 && arr[n][m] != 8) {
                    arr[n][m] = 0;
                }
                n++;
                m++;
            }
            n = nn;
            m = mm;
            while (n < arr.length && m >= 0) {

                if (arr[n][m] != 0 && arr[n][m] != 8) {
                    arr[n][m] = 0;
                }
                n++;
                m--;
            }
            n = nn;
            m = mm;
            while (n >= 0 && m < arr.length) {

                if (arr[n][m] != 0 && arr[n][m] != 8) {
                    arr[n][m] = 0;
                }
                n--;
                m++;
            }

            flag = existNum(arr, 1);
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length; j++) {

                    if (arr[i][j] == 1) {
                        n = i;
                        m = j;
                    }
                }

            }
        }

    }

    public static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println("");
        }
    }

    public static boolean existNum(int[][] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == num) {
                    return true;
                }
            }
        }
        return false;
    }

    public static Integer count(int[][] arr, int num) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == 8) {
                    count++;
                }
            }
        }
        return count;
    }

}
