package com.webscrap;

import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HtmlMetaData {

	public static void main(String[] args) throws IOException {
		
		  
		  System.out.print("Enter yor url : ");
		  String url = new Scanner(System.in).nextLine();
		  Document doc = Jsoup.connect(url).get();            
          String keywords = doc.select("meta[name=keywords]").first().attr("content");  
          System.out.println("Meta keyword : " + keywords);  
          String description = doc.select("meta[name=description]").get(0).attr("content");  
          System.out.println("Meta description : " + description);  
		

	}

}
