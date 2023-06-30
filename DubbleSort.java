// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class DubbleSort {
    public static void main(String[] args) {
        int counter, num, array[];
        Scanner inp = new Scanner(System.in);
        System.out.println("введите количество элементов массива:  ");
        num = inp.nextInt();
        array = new int[num];
        System.out.println("введите " + num + " чисел");
        for (counter = 0; counter < num; counter++) {
            array[counter] = inp.nextInt();
        }
        System.out.println("массив перед сортировкой: " + Arrays.toString(array));
        bubbleSort(array);
        System.out.println("массив после пузырьковой сортировки : " + Arrays.toString(array));
    }

    public static void bubbleSort(int[] num) {
        int j;
        boolean flag = true;
        int temp;

        while (flag) {
            flag = false;
            for (j = 0; j < num.length - 1; j++) {
                if (num[j] > num[j + 1]) {
                    temp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = temp;
                    flag = true;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(Arrays.toString(num)).append("\n");
                try {
                    FileWriter fw = new FileWriter("log_task1.txt", true);
                    fw.write(sb.toString());
                    fw.close();
                } catch (Exception e) {
                    System.out.println("ERROR!");
                }
            }
        }
    }
}


