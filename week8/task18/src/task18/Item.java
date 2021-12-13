package task18;

import java.util.Objects;

public class Item {
	private String itemArticle;
	private String itemName;
	private int price;

	public Item(String itemArticle, String itemName, int price) {
		this.itemArticle = itemArticle;
		this.itemName = itemName;
		this.price = price;
	}

	public Item(String itemArticle) {
		this.itemArticle = itemArticle;
	}

	public Item() {
	}

	public String getItemArticle() {
		return itemArticle;
	}

	public String getItemName() {
		return itemName;
	}

	public int getPrice() {
		return price;
	}

	public void setItemArticle(String itemArticle) {
		this.itemArticle = itemArticle;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "itemArticle: " + itemArticle + "\n";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Item))
			return false;
		Item item = (Item) o;
		return price == item.price && itemArticle.equals(item.itemArticle) && itemName.equals(item.itemName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemArticle, itemName, price);
	}

}
