package Tests;

import java.util.*;

public final class PerformanceManagement {
	private LinkedList<HashMap<String,Integer>> link;
	
	public PerformanceManagement() {
		link = new LinkedList<HashMap<String,Integer>>();
	}
	
	private void save() {
		HashMap<String,Integer> hashmap1 = new HashMap<String,Integer>();
		hashmap1.put("张三", 80);
		hashmap1.put("李四", 65);
		hashmap1.put("王五", 35);
		
		HashMap<String,Integer> hashmap2 = new HashMap<String,Integer>();
		hashmap2.put("张三", 88);
		hashmap2.put("李四", 75);
		hashmap2.put("王五", 45);
		
		link.add(hashmap1);
		link.add(hashmap2);
	}
	
	public Integer totalScore(Integer turn) {
		HashMap.Entry<String, Integer> tempentry;
		Integer sum = 0;
		HashMap<String,Integer> temp = link.get(turn-1);
		Set<HashMap.Entry<String, Integer>> set = temp.entrySet(); 
		for (Iterator<HashMap.Entry<String, Integer>> it = set.iterator(); 
				it.hasNext();) {
			tempentry = it.next();
			sum += tempentry.getValue();
		}
		return sum;
	}
	
	public Integer studentTotalScore(String name) {
		HashMap<String,Integer> temp;
		Integer sum = 0;
		for (Iterator<HashMap<String,Integer>> it = link.iterator(); 
				it.hasNext();) {
			temp = it.next();
			sum += temp.get(name);
		}
		return sum;
	}
	
	public Integer studentAverageScore(String name) {
		HashMap<String,Integer> temp;
		Integer sum = 0;
		Integer turn = 0;
		for (Iterator<HashMap<String,Integer>> it = link.iterator(); 
				it.hasNext();) {
			temp = it.next();
			sum += temp.get(name);
			turn ++;
		}
		return sum/turn;
	}
	
	public static void main(String[] args) {
		PerformanceManagement pm = new PerformanceManagement();
		pm.save();
		System.out.print(pm.studentAverageScore("王五"));
	}
}
