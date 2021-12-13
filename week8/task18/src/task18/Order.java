package task18;

import java.util.List;

public class Order {
	private int ID;
	private String login;
	private List<String> article;

	public Order(int ID, String login, List<String> article) {
		this.ID = ID;
		this.login = login;
		this.article = article;
	}

	public Order() {
	}

	@Override
	public String toString() {
		return "ORDER:\nID :" + ID + "; login: " + login + "; article(s): " + article;
	}
}