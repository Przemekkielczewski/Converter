package com.example.przemek.model;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;

public class ConverterModel {

	// tworzê szkielet JSON?

		// znaki koñca linii??
	
	private int progressInfo = 0;
	
	public void parseCsvXml
	(File chooserFile, String userRoot, String userObject, String userReg)
	{
		File csvFile = chooserFile;
		try {
			FileWriter writer = new FileWriter(this.createFile(userRoot, ".xml"));
			Scanner reader = new Scanner(csvFile);
			
			writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
					+ System.lineSeparator());
			writer.write("<" + userRoot + ">" + System.lineSeparator());
			// root podany przez u¿ytkownika
			String header = reader.nextLine();
			String[] headerParts = this.parseLine(header, userReg);

			while (reader.hasNext() == true) {
				String line = reader.nextLine();
				String[] lineParts = this.parseLine(line, userReg);
				writer.write("<" + userObject + ">");
				// obiekt podany przez u¿ytkownika
				for (int i = 0; i < headerParts.length; i++) {
					writer.write("<" + headerParts[i] + ">");
					writer.write(lineParts[i]);
					writer.write("</" + headerParts[i] + ">");
				}
				writer.write("</" + userObject + ">");
			}
			writer.write("</" + userRoot + ">" + System.lineSeparator());
			writer.close();
			reader.close();
			this.progressInfo = 1;
		} catch (IOException e) {
			this.progressInfo = 2;
			e.printStackTrace();
		}
	}
	
	public void parseCsvJson
	(File chooserFile, String userRoot, String userObject, String userReg)
	{
		File csvFile = chooserFile;
		try {
			FileWriter writer = new FileWriter(this.createFile(userRoot, ".Json"));
			Scanner reader = new Scanner(csvFile);
			
			writer.write("{ \"" + userRoot + "\":[");
			// root podany przez u¿ytkownika
			String header = reader.nextLine();
			String[] headerParts = this.parseLine(header, userReg);

			while (reader.hasNext() == true) {
				String line = reader.nextLine();
				String[] lineParts = this.parseLine(line, userReg);
				// obiekt podany przez u¿ytkownika
				writer.write ("{");
				for (int i = 0; i < headerParts.length; i++) {
					writer.write("\"" + headerParts[i] + "\":");
					writer.write("\"" + lineParts[i] + "\"");
					if (i < headerParts.length-1) {
						writer.write(", ");	
					}
				}
				
				if (reader.hasNext() == true) {
				writer.write("},");
				}
				else {
					writer.write("}");
				} 
			}
			
			writer.write("]}");
			writer.close();
			reader.close();
			this.progressInfo = 1;
		} catch (IOException e) {
			this.progressInfo = 2;
			e.printStackTrace();
		}
	}

	public File createFile(String fileName, String extension) {
		File file = new File(
		fileName + extension);
		System.out.println(file.getPath());
		if (file.exists()) {
		} else
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		return file;
	}

	public String[] parseLine(String line, String regEx) {
		String[] list = line.split(regEx);
		return list;
	}
	
	public String progressInfo () {
		String text = "";
		if (progressInfo == 1) {
			text = "parsing succesful";
		}
		else {
			text = "unable to parse";
		}
		return text;
	} 
}
