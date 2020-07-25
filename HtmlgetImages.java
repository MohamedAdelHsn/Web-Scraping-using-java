package com.webscrap;

import java.io.IOException;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlgetImages {

	public static void main(String[] args) throws IOException {
		
	      System.out.print("Enter yor url : ");
	      String url = new Scanner(System.in).nextLine();
	      Document doc = Jsoup.connect(url).get();   
              // define filter to match images in html
	      Elements images = doc.select("img[src~=(?i)\\.(png|jpe?g|gif)]");  
		
              for (Element image : images) {  
        	  
              System.out.println("src : " + image.attr("src"));   
              System.out.println("alt : " + image.attr("alt"));  
              
          }  
	}

}
