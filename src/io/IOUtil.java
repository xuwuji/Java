package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Basic operations about files
 * 
 * @author wuxu
 * @time 2015Äê12ÔÂ18ÈÕ
 */
public class IOUtil {

	public boolean isExit(String path) {
		File file = new File(path);
		return file.exists();
	}

	public File createFile(String filename) throws IOException {
		File file = new File(filename);
		file.createNewFile();
		return file;
	}

	public File createFile(String dirPath, String filename) throws IOException {
		File file = new File(dirPath, filename);
		file.createNewFile();
		return file;
	}

	public void createDir(String dirPath) {
		File file = new File(dirPath);
		if (!file.exists()) {
			file.mkdirs();
		}
	}

	public String readFromFile(File file) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = br.readLine()) != null) {
			sb.append(line);
		}
		return sb.toString();
	}

	public void writeToFile(String content, File file) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		bw.write(content);
		bw.flush();
		bw.close();
	}

	public void appendToFile(String content, File file) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
		bw.write(content);
		bw.flush();
		bw.close();
	}

	public void copy(String SourcePath, String TargetPath) throws IOException {
		Path source = Paths.get(SourcePath); // exists
		Path target = Paths.get(TargetPath); // doesn't yet exist
		// now two copies of the file
		Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
	}

	public void delete(String path) throws IOException {
		Path source = Paths.get(path); // exists
		Files.delete(source);
	}

	public void move(String SourcePath, String TargetPath) throws IOException {
		Path source = Paths.get(SourcePath);
		Path target = Paths.get(TargetPath);
		Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
	}

	public double getFileSize(File file) {
		double bytes = file.length();
		double kilobytes = (bytes / 1024);
		return kilobytes;
	}

	public static long getFolderSize(File directory) {
		long length = 0;

		System.out.println("Directory:" + directory.getName());

		for (File file : directory.listFiles()) {
			if (file.isFile()) {
				System.out.println("File:" + file.getName() + "  " + file.length()/1024/1024+"MB");
				length += file.length();
			}

			else if (file.isDirectory()) {
				length += getFolderSize(file);
			}

		}
		return length;
	}

}
