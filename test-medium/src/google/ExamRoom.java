package google;

public class ExamRoom {

	public int[] seats;

	public ExamRoom(int N) {
		seats = new int[N];
	}

	public int seat() {
		int last = 0, count = 0;
		int max = 0;
		for (int i = seats.length - 1; i >= 0; --i) {
			if (seats[i] == 1) {
				count++;
				if (count == 1) {
					last = i;
					max = Math.max(seats.length - 1 - last, max);
					continue;
				}
				// middle
				max = Math.max(max, (last - i) / 2);
				last = i;
			}
		}
		// end
		max = Math.max(max, last);
		seats[max] = 1;
		return max;
	}

	public void leave(int p) {
		seats[p] = 0;
	}
	
	public static void main(String[] args) {
		ExamRoom er = new ExamRoom(10);
		er.seat();
		er.seat();
		er.seat();
		er.seat();
		er.leave(4);
		er.seat();
	}
}
