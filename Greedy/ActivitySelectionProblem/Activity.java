package Greedy.ActivitySelectionProblem;

public class Activity implements Comparable<Activity>{
	
	public Activity() {
		this(0,0);
	}
	
	public Activity(int s, int e) {
		this.start = s;
		this.end = e;
	}
	
	private int start;
	private int end;
	
	public int getStart() {
		return start;
	}
	
	public int getEnd() {
		return end;
	}
	
	public void setStart(int start) {
		this.start = start;
	}
	
	public void setEnd(int end) {
		this.end = end;
	}

	@Override
	public int compareTo(Activity object) {
		
		if(this.end == object.end) {
			return this.start - object.start;
		}
		
		return this.end - object.end;
	}
	
	@Override
	public String toString() {
		return "( " + start + " , " + end + ")";
	}

}
