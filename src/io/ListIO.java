package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ListIO {
	private static final String FILE_NAME = "list.txt";
	
	public ArrayList<String> loadList() throws FileNotFoundException{
		File file = new File(FILE_NAME);
		BufferedReader bf = new BufferedReader(new FileReader(file));	
		ArrayList<String> entries = new ArrayList<String>();
		try {
			String line;
			while((line = bf.readLine()) != null){
				entries.add(line);
			}
			bf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return entries;
	}
	
	public void saveList(ArrayList<String> entries){
		File file = new File(FILE_NAME);
		try {
			file.createNewFile();
			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			for(String s : entries){
				bw.write(s + System.lineSeparator());
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
}
