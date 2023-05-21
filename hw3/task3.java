// Задан целочисленный список ArrayList.
//  Найти минимальное, максимальное и среднее арифметичское этого списка.

import java.util.ArrayList;
import java.util.Random;

public class task3 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = newArrayList();
        Integer max = maxNum(numbers);
        Integer min = minNum(numbers);
        Double ever = everNum(numbers);

        System.out.printf("минимальное: %d, максимальное: %d и среднее арифметичское: %.2f", min, max, ever);

    }

    private static Integer maxNum(ArrayList<Integer> newArrayList) {
        Integer max = newArrayList.get(0);
        for (Integer i : newArrayList) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    private static Integer minNum(ArrayList<Integer> newArrayList) {
        Integer min = newArrayList.get(0);
        for (Integer i : newArrayList) {
            if (i < min) {
                min = i;
            }
        }
        return min;
    }

    private static Double everNum(ArrayList<Integer> newArrayList) {
        Double ever = 0.00;
        for (int j = 0; j < newArrayList.size(); j++) {
            ever = ever + newArrayList.get(j).doubleValue();
        }
        ever = ever / newArrayList.size();
        return ever;
    }

    private static ArrayList<Integer> newArrayList() {
        ArrayList<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            numbers.add(i, random.nextInt(-10, 10));
        }
        System.out.println(numbers);
        return numbers;
    }

}
