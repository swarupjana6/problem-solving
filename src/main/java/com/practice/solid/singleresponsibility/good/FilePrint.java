package com.practice.solid.singleresponsibility.good;

import java.io.FileWriter;
import java.io.IOException;

public class FilePrint implements Print<String> {

	private String filePath;
	
	public FilePrint(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public void print(String content) {

		try {
			FileWriter fw=new FileWriter(filePath);    
			fw.write(content);    
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
