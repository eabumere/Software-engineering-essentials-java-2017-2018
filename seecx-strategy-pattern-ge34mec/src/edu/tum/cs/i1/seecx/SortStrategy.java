package edu.tum.cs.i1.seecx;

import java.util.List;

public interface SortStrategy {
	
	public <T extends Comparable<T>> void performSort(List<T> input);

}
