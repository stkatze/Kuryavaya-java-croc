package task6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static void main(String[] args) {
		String str = "/*\n" + " * My first ever program in Java!\n" + " */\n"
				+ "class Hello { // class body starts here \n" + "\n" + "    /* \n" + "    * main method \n"
				+ "    */\n" + "    public static void main(String[] args/* we put command line arguments here*/) {\n"
				+ "        // this line prints my first greeting to the screen\n"
				+ "        System.out.println(\"Hi!\"); // :)\n" + "    }\n" + "} // the end\n"
				+ "// to be continued...\n";

		System.out.print(removeJavaComments(str));
	}

	static String removeJavaComments(String str) {
		StringBuilder noComments = new StringBuilder();

		Pattern pattern = Pattern.compile("(/\\*([\\S\\s]+?)\\*/)|(//.*)");
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			matcher.appendReplacement(noComments, "");
		}
		matcher.appendTail(noComments);

		return String.valueOf(noComments);
	}
}