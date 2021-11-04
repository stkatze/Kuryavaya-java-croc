package task10;

import java.util.ArrayList;

public class Call {
	private int beginning, end;

	public Call(int beginning, int end) {
		this.beginning = beginning;
		this.end = end;
	}

	public boolean isBetween(Call call) {
		return (this.beginning <= call.end) && (this.end >= call.end);
	}

	public int callsBetween(ArrayList<Call> calls) {
		int count = 0;
		for (Call call : calls) {
			if (this.isBetween(call)) {
				count++;
			}
		}
		return count;
	}
}