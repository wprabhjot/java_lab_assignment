package com.ymsli.assignment3.Q04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class BookFileReader {
	
	public static LinkedList<Book> bookFileReader(String file) throws IOException{
		LinkedList<Book> books = new LinkedList<>();
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
		while((line = br.readLine()) != null) {
			String[] data = line.split(":");
			int id = Integer.parseInt(data[0]);
            String isbn = data[1];
            String title = data[2];
            String author = data[3];
            int numOfCopies = Integer.parseInt(data[4]);
            
            books.add(new Book(id,isbn,title,author,numOfCopies));
		}
		br.close();
		return books;
	}

}
