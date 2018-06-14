package Tests;

import java.io.*;
import java.util.*;

public final class InputByte {
	private static Scanner s;

	public static void main(String args[]) throws IOException {
		System.out.println("filename:");
		s = new Scanner(System.in);
		String filename = s.nextLine();
		DataOutputStream out = new DataOutputStream(new FileOutputStream(filename));
		out.writeInt(3);
		out.writeDouble(0.01);
		out.close();
	}
}
