package binaryTree;

import java.util.*;

public class Main {

	/*
	 * ������������������ʵ����ĿҪ��Ĺ��� ��Ȼ����Ҳ���Բ������������ģ����������ȫ�����Լ����뷨�� ^-^ ��ʼд����
	 ******************************/
	static int solve(List<Node> l) {
		int count = 0;
		l.sort((Node n1, Node n2)->(n1.left-n2.left));
		Node node = l.get(0);
		while (!l.isEmpty()) {
			for (Node nd : l) {
				if(nd.left == node.right) {
				int index = l.indexOf(node);
				count++;
				node = l.get(node.right);
				l.remove(index);
			}else {
				l.remove(node);
				if(l.isEmpty()) break;
				node = l.get(0);
			}
		}}
		return count;
	}
	/****************************** ����д���� ******************************/

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		List<Node> l = new ArrayList<>();
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			int left = in.nextInt();
			int right = in.nextInt();
			l.add(new Node(Math.min(left, right), Math.max(left, right)));
		}
		int res = solve(l);
		System.out.println(res);

	}
	
	public static class Node {
		int left;
		int right;
		
		Node(int left, int right){
			this.left = left;
			this.right = right;
		}
	}
}
