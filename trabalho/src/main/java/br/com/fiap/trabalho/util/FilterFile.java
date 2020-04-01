package br.com.fiap.trabalho.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class FilterFile {
	
	public static Stream filterFromResource(String fileName) throws IOException {

		ClassLoader classLoader = new FilterFile().getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());

		Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+$");

		Stream stream = Files.lines(file.toPath()).filter(line -> !line.isEmpty())
				.filter(line -> pattern.matcher(line.substring(0, 1)).matches());

		return stream;
	}
	
}
