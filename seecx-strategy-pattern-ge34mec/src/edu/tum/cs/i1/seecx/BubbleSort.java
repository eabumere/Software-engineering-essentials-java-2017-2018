package edu.tum.cs.i1.seecx;

import java.util.List;

public class BubbleSort implements SortStrategy{
    public <T extends Comparable<T>> void performSort(List<T> input) {

        for (int i = input.size() - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (input.get(j).compareTo(input.get(j + 1)) > 0) {
                    T temp = input.get(j);
                    input.set(j, input.get(j + 1));
                    input.set(j + 1, temp);
                }
            }
        }

    }


}
