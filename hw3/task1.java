// Реализовать алгоритм сортировки слиянием.

import java.util.ArrayList;
import java.util.Random;
// import java.util.*;

public class task1 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = newArrayListGen();
        // ArrayList<Integer> numbers1 = new ArrayList <Integer>(Arrays.asList
        // (0,3,6,7,45,67,78,100));
        // ArrayList<Integer> numbers2 = new ArrayList <Integer>(Arrays.asList
        // (1,2,20,47,68,88,98));
        // ArrayList<Integer> numbersR = merger(numbers1, numbers2);
        // System.out.println(numbersR);

        numbers = sorter(numbers);
        System.out.println(numbers);

    }

    private static ArrayList<Integer> sorter(ArrayList<Integer> numbers) {

        if (numbers.size() > 1) {
            ArrayList<Integer> numbersLeft = new ArrayList<Integer>();
            ArrayList<Integer> numbersRight = new ArrayList<Integer>();
            ArrayList<Integer> numbersResult = new ArrayList<Integer>();

            for (int i = 0; i < numbers.size() / 2; i++) {
                numbersLeft.add(numbers.get(i));
            }
            for (int j = (numbers.size() / 2); j < numbers.size(); j++) {
                numbersRight.add(numbers.get(j));
            }

            numbersLeft = sorter(numbersLeft);
            numbersRight = sorter(numbersRight);
            numbersResult = merger(numbersLeft, numbersRight);

            return numbersResult;

        }

        else if (numbers.size() == 1) {
            numbers.sort(new NumberComperator());
            return numbers;
        } else
            return numbers;

    }

    private static ArrayList<Integer> merger(ArrayList<Integer> Array1, ArrayList<Integer> Array2) {
        ArrayList<Integer> newArrayList1 = new ArrayList<Integer>();
        ArrayList<Integer> newArrayList2 = new ArrayList<Integer>();
        newArrayList1.addAll(Array1);
        newArrayList1.addAll(Array2);
        // System.out.println(newArrayList1);
        int firstIndexArray1 = 0;
        int secondIndexArray1 = Array1.size() - 1;
        int firstIndexArray2 = Array1.size();
        int secondIndexArray2 = Array1.size() + Array2.size() - 1;
        int i = 0;
        int flag1 = 0;
        int flag2 = 0;

        while (i < newArrayList1.size()) {
            while (flag1 + flag2 == 0) {
                if (newArrayList1.get(firstIndexArray1) < newArrayList1.get(firstIndexArray2)) {
                    newArrayList2.add(newArrayList1.get(firstIndexArray1));
                    firstIndexArray1++;
                    if (firstIndexArray1 > secondIndexArray1)
                        flag1++;
                } else {
                    newArrayList2.add(newArrayList1.get(firstIndexArray2));
                    firstIndexArray2++;
                    if (firstIndexArray2 > secondIndexArray2)
                        flag2++;
                }
            }
            if ((flag1 > 0) & (firstIndexArray2 < secondIndexArray2 + 1)) {
                newArrayList2.add(newArrayList1.get(firstIndexArray2));
                firstIndexArray2++;
            }
            if ((flag2 > 0) & (firstIndexArray1 < secondIndexArray1 + 1)) {
                newArrayList2.add(newArrayList1.get(firstIndexArray1));
                firstIndexArray1++;
            }
            i++;
        }
        return newArrayList2;
    }

    private static ArrayList<Integer> newArrayListGen() {
        ArrayList<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            numbers.add(i, random.nextInt(-10, 10));
        }
        System.out.println(numbers);
        return numbers;
    }

}
