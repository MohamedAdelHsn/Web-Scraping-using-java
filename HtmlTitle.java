package com.webscrap;

import java.io.IOException;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HtmlTitle {

	public static void main(String[] args) throws IOException {
		
		System.out.print("Enter yor url : ");
		String url = new Scanner(System.in).nextLine();
		String title = "";
		if(url.contains("http") || url.contains("https")) 
		{
			 Document doc = Jsoup.connect(url).get();  
			 title = doc.title();
			
			
		}
		
		System.out.println((title.length()> 0) ? ""+title+"" : "Invalid Url");
		
		
	}

}
