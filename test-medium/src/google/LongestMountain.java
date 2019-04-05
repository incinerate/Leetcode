package google;

public class LongestMountain {

	/*
	 * ˼·: ����ÿ����i����������up[i]��down[i],��ֻ����peak��ͬʱ�߱�up��down�������ԣ��������ǾͰ�����peak������ֵ
	 * ȡ��������res��
	 */
	public int longestMountain(int[] A) {
		int N = A.length, res = 0;
		int[] up = new int[N], down = new int[N];
		for (int i = N - 2; i >= 0; --i)
			if (A[i] > A[i + 1])
				down[i] = down[i + 1] + 1;
		for (int i = 0; i < N; ++i) {
			if (i > 0 && A[i] > A[i - 1])
				up[i] = up[i - 1] + 1;
			if (up[i] > 0 && down[i] > 0)
				res = Math.max(res, up[i] + down[i] + 1);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] A = { 1, 0, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0, 2 };
		System.out.println(new LongestMountain().longestMountain(A));
	}

}
