package edu.tum.cs.i1.seecx;


import java.util.Collections;
import java.util.List;

public class QuickSort implements SortStrategy{


    public <T extends Comparable<T>> void performSort(List<T> input) {
        if (input.size() != 0) quicksort(input, 0, input.size() - 1);
    }


    private <T extends Comparable<T>> void quicksort(List<T> list, int from, int to) {
        if (from < to) {
            int pivot = from;
            int left = from + 1;
            int right = to;
            T pivotValue = list.get(pivot);
            while (left <= right) {
                while (left <= to && pivotValue.compareTo(list.get(left)) > 0) {
                    left++;
                }
                while (right > from && pivotValue.compareTo(list.get(right)) < 0) {
                    right--;
                }
                if (left < right) {
                    Collections.swap(list, left, right);
                }
            }
            Collections.swap(list, pivot, left - 1);
            quicksort(list, from, right - 1);
            quicksort(list, right + 1, to);
        }
    }


}
