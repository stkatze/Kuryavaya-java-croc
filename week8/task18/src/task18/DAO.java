package task18;

import task18.exceptions.NotFound;
import task18.exceptions.IllegalItemException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {

	Connection connection;

	public DAO(Connection connection) {
		this.connection = connection;
	}

	// Выполнить поиск товара по артикулу.
	Item findItem(String itemArticle) throws SQLException {
		Item returnItem = new Item();
		try (PreparedStatement statement = connection
				.prepareStatement("SELECT * FROM ITEMS p WHERE p.ARTICLE_ID = ?")) {
			statement.setString(1, itemArticle);
			try (ResultSet rs = statement.executeQuery()) {
				while (rs.next()) {
					returnItem.setItemArticle(rs.getString("ARTICLE_ID"));
					returnItem.setItemName(rs.getString("ITEM"));
					returnItem.setPrice(rs.getInt("PRICE"));
				}
			}
		}
		if (returnItem.getItemArticle() == null)
			return null;
		return returnItem;
	}

	Item createItem(Item item) throws SQLException {
		if (findItem(item.getItemArticle()) != null)
			throw new IllegalItemException();
		else {
			try (PreparedStatement statement = connection.prepareStatement("INSERT INTO ITEMS VALUES(?,?,?)")) {
				statement.setString(1, item.getItemArticle());
				statement.setString(2, item.getItemName());
				statement.setInt(3, item.getPrice());
				statement.execute();
			}
		}
		return item;
	}

	// Изменить информацию о товаре.
	Item updateItem(Item item) throws SQLException {
		if (findItem(item.getItemArticle()) == null)
			throw new NotFound();
		else {
			try (PreparedStatement statement = connection
					.prepareStatement("UPDATE ITEMS " + "SET ITEMS = ?, PRICE = ? " + "WHERE ARTICLE_ID = ?")) {
				statement.setString(1, item.getItemName());
				statement.setInt(2, item.getPrice());
				statement.setString(3, item.getItemArticle());
				statement.execute();
			}
		}
		return item;
	}

	void deleteItem(String itemArticle) throws SQLException {
		if (findItem(itemArticle) == null)
			throw new NotFound();
		else {
			try (PreparedStatement statement = connection.prepareStatement("DELETE FROM ORDERS o "
					+ "WHERE o.ARTICLE = ?; " + "DELETE FROM ITEMS p " + "WHERE p.ARTICLE_ID= ?")) {
				statement.setString(1, itemArticle);
				statement.setString(2, itemArticle);
				statement.execute();
			}
		}
	}

	// Найти ID последнего заказа.
	int getLastID() throws SQLException {
		try (Statement statement = connection.createStatement()) {
			try (ResultSet result = statement.executeQuery("SELECT ID FROM ORDERS o ORDER BY o.ID DESC")) {
				result.next();
				return result.getInt("ID");
			}
		}
	}

	// Создать заказ.
	Order createOrder(String login, List<Item> items) throws SQLException {
		// Текущий заказ=ID последнего заказа+1.
		int ID = getLastID() + 1;
		ArrayList<String> itemsArticles = new ArrayList<>();
		try (PreparedStatement statement = connection.prepareStatement("INSERT INTO ORDERS VALUES(?,?,?)")) {
			for (Item item : items) {
				if (findItem(item.getItemArticle()) == null)
					throw new NotFound();
				itemsArticles.add(item.getItemArticle());
				statement.setInt(1, ID);
				statement.setString(2, login);
				statement.setString(3, item.getItemArticle());
				statement.execute();
			}
		}
		return new Order(ID, login, itemsArticles);
	}

}