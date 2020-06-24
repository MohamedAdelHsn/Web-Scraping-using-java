package com.webscrap;

import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HtmlSource {

	public static void main(String[] args) throws IOException {
		
		System.out.print("Enter yor url : ");
		String url = new Scanner(System.in).nextLine();
		String source = "";
		if(url.contains("http") || url.contains("https")) 
		{
			 Document doc = Jsoup.connect(url).get();  
			 source= doc.html();
			
			
		}
		
		System.out.println((source.length()> 0) ? ""+source+"" : "Invalid Url");
		
		
		
	}

}
