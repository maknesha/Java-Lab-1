import java.util.Arrays;

public class Lab1 {
    public static void main(String[] args) {
        try {
            // Вхідні матриці A та B
            long[][] A = {
                    {10594044442L, 212654333454208L, 3456433L},
                    {44893936654322345L, 558439030L, 67584940L},
                    {744565459343L, 83283289885940L, 948843930L}
            };
            long[][] B = {
                    {948939399499303L, 847848385803490L, 743984030L},
                    {65884949558340L, 5589302493L, 48868594558303L},
                    {35858493573994L, 2858494904438859L, 15849303785L}
            };

            // Обчислення матриці C (A XOR B)
            long[][] C = xorMatrices(A, B);

            // Виведення матриці C
            System.out.println("Результат XOR операції (матриця C):");
            printMatrix(C);

            // Обчислення суми найменших елементів кожного стовпця матриці C
            long sumOfMinElements = calculateColumnMinSum(C);

            // Виведення результату
            System.out.println("Сума найменших елементів кожного стовпця матриці C: " + sumOfMinElements);
        } catch (Exception e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }

    // Метод для обчислення XOR матриць
    private static long[][] xorMatrices(long[][] A, long[][] B) {
        int rows = A.length;
        int cols = A[0].length;
        long[][] C = new long[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                C[i][j] = A[i][j] ^ B[i][j];
            }
        }
        return C;
    }

    // Метод для обчислення суми найменших елементів кожного стовпця
    private static long calculateColumnMinSum(long[][] matrix) {
        int cols = matrix[0].length;
        long sum = 0;

        for (int j = 0; j < cols; j++) {
            long min = Long.MAX_VALUE;
            for (long[] row : matrix) {
                if (row[j] < min) {
                    min = row[j];
                }
            }
            sum += min;
        }

        return sum;
    }

    // Метод для виведення матриці
    private static void printMatrix(long[][] matrix) {
        for (long[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}

