package task13;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public interface BlackListFilter {

	/**
	 * From the given list of comments removes ones that contain words from the
	 * black list.
	 *
	 * @param comments  list of comments; every comment is a sequence of words,
	 *                  separated by spaces, punctuation or line breaks
	 * @param blackList list of words that should not be present in a comment
	 */
	static void filterComments(List<String> comments, Set<String> blackList) {
		List<String> spam = new ArrayList<>();
		for (String comment : comments) {
			for (String spamWord : blackList) {
				if (comment.toUpperCase().contains(spamWord))
					spam.add(comment);
			}
		}

		for (String spamComment : spam) {
			comments.remove(spamComment);
		}
	}

}