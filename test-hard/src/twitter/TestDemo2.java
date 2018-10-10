package twitter;

public class TestDemo2 {

	static int maxLength(int[] a, int k) {
		int max = 0, sum = 0, count;

		for (int i = 0; i < a.length; i++) {
			count = 0;
			sum = 0;
			int j = i;
			first: while (j!=a.length&&sum <= k) {
				sum += a[j];
				if (sum <= k)
					j++;
				else
					break first;
				count++;
			}
			max = max < count ? count : max;
		}
		return max;
	}

}
