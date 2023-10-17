package ru.mirea.nikitina;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Application {
    public static void main(String[] args) {

        int[] numberArray;
        int[] numberArray2;
        int arrayLength;
        int numToFind;

        System.out.print("Введите размер массива: ");
        Scanner scan = new Scanner(System.in);
        arrayLength = scan.nextInt();

        numberArray = new int[arrayLength];
        numberArray2 = new int[arrayLength];

        Random random = new Random();

        for (int i = 0; i < numberArray.length; i++) {
            numberArray[i] = random.nextInt(-100, 100);
            numberArray2[i] = random.nextInt(-100,100);
        }

        System.out.println("Массив: " + Arrays.toString(numberArray));
        Arrays.sort(numberArray);
        System.out.println("Сортировка:" + Arrays.toString(numberArray));

        System.out.println();
        System.out.print("Введите число для поиска: ");
        numToFind = scan.nextInt();

        binarySearch(numberArray, numToFind);

        System.out.println();
        System.out.println("Первый массив: " + Arrays.toString(numberArray));
        System.out.println("Второй массив: " + Arrays.toString(numberArray2));
        System.out.println("Значения, которые встречаются в обоих массивах:" + sameValues(numberArray, numberArray2));

    }
    public static void binarySearch(int[] numberArray, int numToFind){
        int low = 0;
        int high = numberArray.length - 1;
        int middle;
        int i = 1;

        while (low <= high) {
            System.out.println("Итерация №" + i++);
            middle = (low + high) / 2;
            int num = numberArray[middle];

            if (num == numToFind) {
                System.out.println("Значение найдено под индексом " + middle);
                return;
            } else if (num  > numToFind){
                high = middle -1;
            } else {
                low = middle + 1;
            }
        }
        System.out.println("Искомого значения в массиве нет.");
    }

    public static ArrayList<Integer> sameValues(int[] numArray1, int[] numArray2){
        ArrayList<Integer> values = new ArrayList<Integer>();
        for (int i: numArray1){
            for (int j: numArray2){
                if (i==j){
                    values.add(i);
                    break;
                }
            }
        }
        return values;
    }
}
