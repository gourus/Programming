package Greedy.FractionalKnapsack;

import java.util.ArrayList;
import java.util.Collections;

public class FractionalKnapsack {
	
	private float maxValue;
	
	// Class to store the Weight, value and fraction
	class Item implements Comparable<Item>
	{
		public double val;
		public double weight;
		public Double fraction;
		
		public Item(int v, int w)
		{
			val = v;
			weight = w;
			fraction = new Double( val/weight);
		}
		
		@Override
		public int compareTo(Item o) {
			return (int) ( (o.fraction - fraction)*100.0);
		}
		
	}
	
	
	public FractionalKnapsack() {
		maxValue = 0;
	}
	
	
	private void calcMaxValue(int wt[] , int v[] , int cap)
	{
		ArrayList<Item> itemList = new ArrayList<FractionalKnapsack.Item>();
		
		for(int i=0; i < wt.length ; i++)
		{
			itemList.add(new FractionalKnapsack.Item(v[i], wt[i]));
		}
		
		//Sort itemList WRT fraction (descending order)
		Collections.sort(itemList);
				
		for(FractionalKnapsack.Item i : itemList)
		{
			if(i.weight <= cap)
			{
				maxValue += i.val;
				cap -= i.weight;
			}
			else if(cap < i.weight)
			{
				maxValue += cap * i.fraction;
				break;
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		FractionalKnapsack fk = new FractionalKnapsack();
		
		int[] wt = {10, 40, 20, 30}; 
        int[] val = {60, 180, 100, 120}; 
        int capacity = 50; 
        
        fk.calcMaxValue(wt, val, capacity);
        
        System.out.println("Maximum value we can get : " + fk.maxValue);
	}

}