package firstMissingPositive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;



public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int m = 0;
		HashMap<Integer,List<Integer>> map = new HashMap<>();
		for (int i = 1; i <= num; i++) {
			String s = sc.next();
			String[] data = s.split(" ");
			System.out.println((data[1]));
			ArrayList<Integer> temp = new ArrayList<>();
			for (int j = 0; j < data.length; j++) {
				if (!"0".equals(data[j])) {
					temp.add(Integer.parseInt(data[j]));
				}
			}
			map.put(i, temp);
		 }
		for(Entry<Integer, List<Integer>> entry: map.entrySet())
        {
         System.out.println("Key: "+ entry.getKey()+ " Value: "+entry.getValue());
        }
	   }
}
