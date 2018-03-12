package edu.tum.cs.i1.seecx;

public class Policy {
	
	private Context context;

	public Policy(Context context) {
		this.context = context;
	}
	
	public void configure() {
		if (context.getDates().size() > 10){
			context.setSortAlgorithm(new MergeSort());
		} else {
			context.setSortAlgorithm(new BubbleSort());
		}
	}

}
