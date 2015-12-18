package io;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class IOClient {

	public static void main(String[] args) throws IOException {
		String s = "asdadsadsasdasd";
		IOUtil util = new IOUtil();
		File file = util.createFile("C:\\Downloads", "test.txt");
		File file1 = new File("C:\\Program Files (x86)");
		util.writeToFile(s, file);
		util.appendToFile(s, file);
		String tt = util.readFromFile(file);
		util.appendToFile("\n" + tt, file);

		File[] list = file1.listFiles();
		// for (File f : list) {
		// System.out.println(f.getName() + ":" + util.getFileSize(f)+"kb");
		// }

		System.out.println(((double) util.getFolderSize(file1) / 1024 / 1024) + "MB");
	}

}
