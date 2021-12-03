package task16;

public class Respondent {
	private String fullName;
	private int age;

	Respondent(String fullName, int age) {
		this.fullName = fullName;
		this.age = age;
	}

	public String getFullName() {
		return this.fullName;
	}

	public int getAge() {
		return this.age;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || !obj.getClass().equals(Respondent.class))
			return false;
		Respondent alt = (Respondent) obj;
		return this.fullName.equals(alt.fullName);
	}

	public int hashCode() {
		return fullName.hashCode();
	}

	public String toString() {
		return fullName + "(" + age + ")";
	}
}