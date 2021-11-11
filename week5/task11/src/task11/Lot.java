package task11;

import java.util.Date;

public class Lot {
	private volatile int cost;
	private volatile String username;
	private Date bidsEnd;

	public Lot(int cost, String username, Date bidsEnd) {
		this.cost = cost;
		this.username = username;
		this.bidsEnd = bidsEnd;
	}

	public synchronized void newBid(int cost, String username) {
		if (cost > this.cost && new Date().before(this.bidsEnd)) {
			this.cost = cost;
			this.username = username;
		} else {
			System.out.println("Ваша ставка ниже существующей или аукцион окончен!");
		}
	}

	public synchronized String getWinner() {
		return this.username + " победитель аукциона!";
	}
}