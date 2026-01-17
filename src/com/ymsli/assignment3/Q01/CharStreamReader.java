package com.ymsli.assignment3.Q01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharStreamReader {
	public static void main(String[] args) {
		File source = new File("image.png");
		File dest = new File("copyImage");
		try(FileReader fis = new FileReader(source);
			FileWriter fos = new FileWriter(dest);){
			
			int byteData;
			while((byteData = fis.read()) != -1) {
				fos.write(byteData);
			}
			System.out.println("Character Stream: ");
			System.out.println("Original Size: "+ source.length());
			System.out.println("Destination Size: "+ dest.length());
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("File not found "+ e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error during copying "+ e.getMessage());
		}
	}
}
