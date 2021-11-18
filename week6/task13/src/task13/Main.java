package task13;

import java.util.*;

public class Main implements BlackListFilter {
	public static void main(String[] args) {
		ArrayList<String> comments = new ArrayList<>();
		comments.addAll(Arrays.asList("Интересный пост!", "Акция на установку окон!!!", "Делайте ставки на спорт!"));
		System.out.println("Комментарий:    " + comments);

		HashSet<String> blackList = new HashSet<>();
		blackList.addAll(Arrays.asList("АКЦИЯ", "СТАВКИ"));

		BlackListFilter.filterComments(comments, blackList);
		System.out.println("Отмодерированный комментарий: " + comments);
	}
}