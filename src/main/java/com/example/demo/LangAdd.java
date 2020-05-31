package com.example.demo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

public class LangAdd {

	public static  void addWord(String word, Locale locale) throws Exception, Exception {
		System.out.println(locale);
		
		//check locale, if EN then default
		String FILENAME = "src/main/resources/messages_"+locale.toString() +".properties";
		if (locale.toString().equals("en")) {FILENAME = "src/main/resources/messages.properties";}
		
		BufferedWriter bw = null;
		FileWriter fw = null;
		//write to file, if doesn't exist then create file
		try {
			
		   File file = new File(FILENAME);

			if (!file.exists()) {
				file.createNewFile();
			}
			
			fw = new FileWriter(file.getAbsoluteFile(), true);
			bw = new BufferedWriter(fw);
			bw.write(word);
			System.out.println(word + "successfully added to " + locale.toString() + " messages.");

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}

	} 

}
