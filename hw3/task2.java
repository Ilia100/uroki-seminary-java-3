// Пусть дан произвольный список целых чисел. Удалить из него чётные числа.

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class task2 {
    public static void main(String[] args) {
        // List <Integer> newArrayList =newArray();
        // newArrayList=changer(newArrayList);
        System.out.println(changer(newArray()));

    }

    private static List<Integer> changer(List<Integer> newArrayList) {
        List<Integer> numbersNew = new ArrayList<>();
        for (Integer i : newArrayList) {
            if (i % 2 != 0) {
                numbersNew.add(i);
            }
        }
        return numbersNew;
    }

    private static List<Integer> newArray() {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            numbers.add(i, random.nextInt(10));
        }
        System.out.println(numbers);
        return numbers;
    }
}
