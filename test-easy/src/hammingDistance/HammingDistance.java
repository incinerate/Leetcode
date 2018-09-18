package hammingDistance;

public class HammingDistance {
	
	public static void main(String[] args) {
		System.out.println(hammingDistance2(1, 4));
	}
	
	public static int hammingDistance(int x, int y) {
		int dis = 0;
		while((y!=0) || (x!=0)){
			if(x%2!=y%2)
				dis++;
			x=x/2;
			y=y/2;
		}
		return dis;
	}
	
	public static int hammingDistance2(int x, int y){
		return Integer.bitCount(x ^ y);
	}
}
