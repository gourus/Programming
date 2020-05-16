package Greedy.ActivitySelectionProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ActivitySelection {
	
	public int findMaxPosibleActivities(List<Activity> aList) {
		
		Collections.sort(aList);
		
		List<Activity> result = new ArrayList<Activity>();
		
		result.add(aList.get(0));
		
		for(int i=1; i<aList.size(); i++) {
			if(result.get(result.size()-1).getEnd() < aList.get(i).getStart() ) {
				result.add(aList.get(i));
			}
		}
		
		for(Activity activity : result){
			System.out.println(activity);
		}
		
		return result.size();
	}
	
	
	public static void main(String[] args) {
		ActivitySelection as = new ActivitySelection();
		
		List<Activity> input = new ArrayList<Activity>();
		
		/*  
		 * Activities - {{5, 9}, {1, 2}, {3, 4}, {0, 6}, {5, 7}, {8, 9}}; 
		 */
		
		input.add(new Activity(8,9));
		input.add(new Activity(1,2));
		input.add(new Activity(3,4));
		input.add(new Activity(0,6));
		input.add(new Activity(5,7));
		input.add(new Activity(5,9));
		
		System.out.println(as.findMaxPosibleActivities(input));
		
	}

}
