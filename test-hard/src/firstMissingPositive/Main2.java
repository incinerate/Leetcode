package firstMissingPositive;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
			int num = sc.nextInt();
			if(num < 2) {
				System.out.println("Sad");
				continue;
			}
			ArrayList<String> list = new ArrayList<>();

			for (int j = 0; j < num; j++) {
				list.add(sc.next());
			}
			
			if(judge(list)) {
				System.out.println("Yeah");
			}else {
				System.out.println("Sad");
			}
		}
	}
	
	public static String reverse(String str){  
        return new StringBuilder(str).reverse().toString();  
    }

	private static boolean judge(ArrayList<String> list) {
		// TODO Auto-generated method stub
		for (int i = 0; i < list.size(); i++) {
			for (int j = i+1; j < list.size(); j++) {
				String s1 = list.get(i);
				String s2 = list.get(j);
				if(s1.equals(s2) || s1.equals(reverse(s2))) {
					return true;
				}
				int n = s2.length();
				char[] cs = s2.toCharArray();
				LinkedList<Character> l = new LinkedList<>();
				LinkedList<Character> reverseL = new LinkedList<>();
				for (char c : cs) {
					l.add(c);
					reverseL.addFirst(c);
				}
				
				for (int k = 0; k < n; k++) {
					Character first = l.removeFirst();
					l.addLast(first);
					StringBuilder sb = new StringBuilder();
					for (Character character : l) {
						sb.append(character);
					}
					if(sb.toString().equals(s1) || reverse(sb.toString()).equals(s1)) {
						return true;
					}
				}
			}
		}
		return false;
	}
}