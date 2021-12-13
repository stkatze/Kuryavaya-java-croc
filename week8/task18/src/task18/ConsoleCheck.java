package task18;

import task18.exceptions.NotFound;
import task18.exceptions.IllegalItemException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleCheck {

	static final String databaseUrl = "jdbc:h2:tcp://localhost/~/test/test";
	static final String driver = "org.h2.Driver";

	static final String user = "sa";
	static final String password = "";

	public static void main(String[] args) {
		try (Connection connection = DriverManager.getConnection(databaseUrl, "sa", "")) {
			executes(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	static void executes(Connection connection) throws SQLException {
		DAO dao = new DAO(connection);
		Scanner sc = new Scanner(System.in);

		WHILE: while (true) {
			System.out.println("Введите команду большими буквами:");
			String[] command = sc.nextLine().split(" ");
			switch (command[0]) {
			// Создать запись товара.
			case "ТОВАР":
				if (command.length != 4) {
					System.out.println("Ошибка!");
					break;
				}
				try {
					dao.createItem(new Item(command[1], command[2], Integer.parseInt(command[3])));
					System.out.println("Готово!");
				} catch (NumberFormatException e) {
					System.out.println("Неверные параметры товара!");
				} catch (IllegalItemException e) {
					System.out.println(e.getMessage());
				}
				break;
			// Изменить запись о товаре.
			case "ИЗМЕНИТЬ":
				if (command.length != 4) {
					System.out.println("Ошибка!");
					break;
				}
				try {
					dao.updateItem(new Item(command[1], command[2], Integer.parseInt(command[3])));
					System.out.println("Готово!");
				} catch (NumberFormatException e) {
					System.out.println("Неверные параметры товара!");
				} catch (NotFound e) {
					System.out.println(e.getMessage());
				}
				break;
			// Удалить товар из реестра.
			case "УДАЛИТЬ":
				if (command.length != 2) {
					System.out.println("Ошибка!");
					break;
				}
				try {
					dao.deleteItem(command[1]);
					System.out.println("Готово!");
				} catch (NotFound e) {
					System.out.println(e.getMessage());
				}
				break;
			// Создать запись заказа.
			case "ЗАКАЗ":
				if (command.length < 3) {
					System.out.println("Указаны не все параметры!");
					break;
				}
				ArrayList<Item> items = new ArrayList<>();
				for (int i = 2; i < command.length; i++) {
					items.add(new Item(command[i]));
				}
				try {
					dao.createOrder(command[1], items);
					System.out.println("Готово!");
				} catch (NotFound e) {
					System.out.println(e.getMessage());
				}
				break;
			// Завершить обработку команд и закрыть все подключения к базе данных.
			case "КОНЕЦ":
				break WHILE;
			default:
				System.out.println("Ошибка!");
				break;
			}
		}
	}

}
