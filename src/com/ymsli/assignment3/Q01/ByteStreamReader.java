package com.ymsli.assignment3.Q01;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamReader {
	public static void main(String[] args) {
		File source = new File("image.png");
		File dest = new File("copyImage.png");
		try(FileInputStream fis = new FileInputStream(source);
			FileOutputStream fos = new FileOutputStream(dest);){
			
			int byteData;
			while((byteData = fis.read()) != -1) {
				fos.write(byteData);
			}
			System.out.println("Byte Stream: ");
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
