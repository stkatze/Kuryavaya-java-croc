package task12;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class Main {

	private static final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();

	private static synchronized String toHexString(byte[] bytes) {
		StringBuilder hex = new StringBuilder(bytes.length * 2);
		for (byte b : bytes) {
			hex.append(HEX_DIGITS[(b & 0xff) >> 4]);
			hex.append(HEX_DIGITS[b & 0x0f]);
		}
		return hex.toString();
	}

	private static synchronized String hashPassword(String password) {
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		digest.update(password.getBytes());
		byte[] bytes = digest.digest();
		return toHexString(bytes);
	}

	public static synchronized StringBuilder createPass(StringBuilder guessPass) {
		Random rand = new Random();
		for (int i = 0; i < 7; i++) {
			guessPass.append((char) ('a' + rand.nextInt(26)));
		}
		return guessPass;
	}

	static class Run implements Runnable {
		StringBuilder guessPass = new StringBuilder(7);

		@Override
		public void run() {
			guessPass = createPass(guessPass);
			System.out.println(Thread.currentThread().toString() + ": " + (guessPass.toString()));
		}

		public StringBuilder getGuessPass() {
			return this.guessPass;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		int threadsNumber = Integer.parseInt(args[0]);
		String hashPass = args[1];
		boolean passFounded = false;
		String password = "";
		Run[] run = new Run[threadsNumber];
		Thread[] thr = new Thread[threadsNumber];
		while (!passFounded) {
			for (int i = 0; i < threadsNumber; i++) {
				run[i] = new Run();
			}
			for (int i = 0; i < threadsNumber; i++) {
				thr[i] = new Thread(run[i]);
				thr[i].start();
			}
			for (int i = 0; i < threadsNumber; i++) {
				thr[i].join();
				StringBuilder guessPass = run[i].getGuessPass();
				if (hashPassword(guessPass.toString()).equals(hashPass)) {
					passFounded = true;
					password = guessPass.toString();
					break;
				}
			}
		}
		System.out.println("Пароль: \"" + password + "\"");
	}
}