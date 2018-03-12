package edu.tum.cs.i1.seecx;

import java.util.Date;
import java.util.List;

public class Context {
	
	private List<Date> dates;
	private SortStrategy sortAlgorithm;

	public List<Date> getDates() {
		return dates;
	}

	public void setDates(List<Date> dates) {
		this.dates = dates;
	}
	
	public void setSortAlgorithm(SortStrategy SortStrategy) {
		this.sortAlgorithm = SortStrategy;
	}
	
	public SortStrategy getSortAlgorithm() {
		return this.sortAlgorithm;
	}
	
	public void sort() {
		this.sortAlgorithm.performSort(this.dates);
	}

}
