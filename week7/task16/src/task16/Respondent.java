package task16;

public class Respondent {
	private final String name;
	private final int age;

	public Respondent(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Respondent(String respondentInfo) {
		this(respondentInfo.split(",")[0], Integer.parseInt(respondentInfo.split(",")[1]));
	}

	public int getAge() {
		return this.age;
	}

	public String getName() {
		return this.name;
	}

	public static void main(String[] args) {
	}
}