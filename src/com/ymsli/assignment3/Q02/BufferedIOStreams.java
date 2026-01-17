package com.ymsli.assignment3.Q02;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedIOStreams {
	public static void main(String[] args) {
		File source = new File("image.png");
		File dest1 = new File("copyWithoutImage.png");
		File dest2 = new File("copyWithBuffer.png");
		long startTime = System.currentTimeMillis();
		long timeWithoutBuffer=0, timeWithBuffer=0;
		try(FileInputStream fis = new FileInputStream(source);
			FileOutputStream fos = new FileOutputStream(dest1);
			){
			
			int byteData;
			while((byteData = fis.read()) != -1) {
				fos.write(byteData);
			}
			long endTime = System.currentTimeMillis();
			timeWithoutBuffer = endTime - startTime;
			System.out.println("Without buffering: "+ timeWithoutBuffer+ "ms");
			
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("File not found "+ e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error during copying "+ e.getMessage());
		}
		
		startTime = System.currentTimeMillis();
		
		try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest2))){
			
//			int bufferedByteData;
//			while((bufferedByteData = bis.read()) != -1) {
//				bos.write(bufferedByteData);
//			}
			byte[] buffer = new byte[8192];
			int bytesRead;
			while((bytesRead = bis.read(buffer)) != -1) {
				bos.write(buffer, 0, bytesRead);
			}
			long endTime = System.currentTimeMillis();
			timeWithBuffer = endTime - startTime;
			System.out.println("With buffering: "+ timeWithBuffer+ "ms");
			
			System.out.println("Performance improved by: "+ (timeWithoutBuffer - timeWithBuffer)+ "ms");
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			System.out.println("File not found "+ e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error during copying "+ e.getMessage());
		}
	}
}
