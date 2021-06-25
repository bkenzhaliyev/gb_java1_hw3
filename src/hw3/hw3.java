package hw3;

public class hw3 {

    public static void main(String[] args) {
        int len = 10;
        int[] arr1 = new int[len];
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] arr3 = {1, 1, 3, 1, 1, 6, 2, 3, 1, 2, 4, 1};

        invertArray();
        fillArray();
        changeArray();
        fillDiagonal();

        arr1 = getArray(len, 2);
        System.out.println();
        printArray(arr1);
        getMinMax();

        System.out.println(equalArray(arr3));
        moveArray(arr2, 2);
    }

    /**
     * Метод печати элементов массива
     */
    public static void printArray(int[] arr) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%4d", arr[i]);
        }
        System.out.println();
    }

    /**
     * 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
     * С помощью цикла и условия заменить 0 на 1, 1 на 0;
     */
    public static void invertArray() {
        int[] arr = {1, 0, 1, 0, 0, 1};
        printArray(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        printArray(arr);
    }

    /**
     * 2. Задать пустой целочисленный массив длиной 100.
     * С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100;
     */
    public static void fillArray() {
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        printArray(arr);
    }

    /**
     * 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом,
     * и числа меньшие 6 умножить на 2;
     */
    public static void changeArray() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        printArray(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] *= 2;
            }
        }
        printArray(arr);
    }

    /**
     * 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
     * и с помощью цикла(-ов) заполнить его диагональные элементы единицами
     */
    public static void fillDiagonal() {
        int[][] arr = new int[10][10];
        for (int i = 0; i < arr.length; i++) {
            System.out.println();
            for (int j = 0; j < arr[i].length; j++) {
                if (i == j) {
                    arr[i][j] = 1;
                } else if (i == arr[i].length - (j + 1)) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = 0;
                }
                System.out.printf("%4d", arr[i][j]);
            }
        }
    }

    /**
     * 5. Написать метод, принимающий на вход два аргумента: len и initialValue,
     * и возвращающий одномерный массив типа int длиной len,
     * каждая ячейка которого равна initialValue;
     */
    public static int[] getArray(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }

    /***6. Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
     */
    public static void getMinMax() {
        int[] arr = {4, 5, 3, 2, 11, 4, 5, 0, 4, 8, 9, 1};
        int min = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }

            if (max < arr[i]) {
                max = arr[i];
            }
        }
        System.out.println("");
        printArray(arr);
        System.out.printf("Минимальный элемент %4d \n", min);
        System.out.printf("Максимальный элемент %4d \n", max);
    }

    /**
     * 7.Написать метод, в который передается не пустой одномерный целочисленный массив,
     * метод должен вернуть true, если в массиве есть место,
     * в котором сумма левой и правой части массива равны.
     */
    public static boolean equalArray(int[] arr) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < arr.length; i++) {
            a += arr[i];
            b = 0;
            for (int j = i + 1; j < arr.length; j++) {
                b += arr[j];
            }
            if (a == b) {
                System.out.println(a);
                break;
            }

        }
        return (a == b);
    }

    /**
     * 8. Написать метод, которому на вход подается одномерный массив и число n (может быть положительным,
     * или отрицательным), при этом метод должен сместить все элементы массива на n позиций.
     * Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами.
     */
    public static void moveArray(int[] arr, int n) {
        int a = 0;
        int j = 1;
        int b = 0;

        if (n < 0){
            b = arr.length + n;
        } else {
            b = n;
        }
        printArray(arr);
        while (j <= b) {
            for (int i = 0; i < arr.length; i++) {
                a = arr[0];
                arr[0] = arr[i];
                arr[i] = a;
            }
            j += 1;
        }
        printArray(arr);
    }
}