public class PrefixSum {
    /*
    ЗАДАНИЕ 1
    Алгоритм решения:
    1. Копируем первую строку и столбец исходной матрицы без изменений
    2. Заполняем ij элемент, так что если a[i][j]==0, то квадрат из единиц здесь невозможен, иначе определяем минимальное значение диагонального, верхнего и левого элементов + 1 (сам a[i][j])
     */
    public static int maxSqr(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] newMatrix = matrix;
        int max = 0;

        // Проверяем первую строку и столбец, т.к. они не будут изменены
        for (int i = 0; i < n; i++) {
            if (newMatrix[i][0]>max) max = newMatrix[i][0];
        }
        for (int j = 0; j < m; j++) {
            if (newMatrix[0][j]>max) max = newMatrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (newMatrix[i][j] != 0) {
                    newMatrix[i][j] = 1 + Math.min(Math.min(newMatrix[i - 1][j], newMatrix[i][j - 1]), newMatrix[i - 1][j - 1]);
                }
                if (newMatrix[i][j]>max) max = newMatrix[i][j];
            }
        }
        //
        return max;



    }
    public static void main(String[] args) {
        int [][] matrix = {
            {0, 1, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 1, 1},
            {1, 1, 1, 1}
        };
        System.out.println("Максимальный размер квадрата: " + maxSqr(matrix));
    }
}
