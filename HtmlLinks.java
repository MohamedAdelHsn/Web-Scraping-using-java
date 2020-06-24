package com.webscrap;

import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlLinks {

	public static void main(String[] args) throws IOException {
	
		  System.out.print("Enter yor url : ");
		  String url = new Scanner(System.in).nextLine();
		  Document doc = Jsoup.connect(url).get(); 
		  Elements links = doc.select("a[href]");  
		  for(Element link : links) 
		  {
			  System.out.println("link : "+link.attr("href"));
			  System.out.println("link_Text : "+link.text());
			  
		  }
		

	}

}
