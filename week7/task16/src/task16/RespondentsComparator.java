package task16;

import java.util.Comparator;

public class RespondentsComparator implements Comparator<Respondent> {
	@Override
	public int compare(Respondent o1, Respondent o2) {
		if (o2.getAge() == o1.getAge()) {
			return o1.getFullName().compareTo(o2.getFullName());
		} else {
			return Integer
					.parseInt(String.valueOf(Integer.toString(o2.getAge()).compareTo(Integer.toString(o1.getAge()))));
		}
	}
}