package com.webscrap;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/* 
 *  @Description : Download all images from html and save them into my computer
 *    
 *  @author : Mohamed Adel Hassan
*/

public class DownloadImages {
	
	static String path;
	
	public static void main(String[] args) throws IOException {
	
		 List<ImageInfo> list_images = new ArrayList<ImageInfo>();
		 System.out.print("Enter yor url : ");
		 String url = new Scanner(System.in).nextLine();
		 System.out.print("Enter your path : ");
		 path = new Scanner(System.in).nextLine();
		 
		 if(!new File(path).isDirectory()) {
		     System.err.print("Exception : please enter real folder path to continue ");
		      System.exit(0);
		 }
		 
		 Document doc = Jsoup.connect(url).get();   
		  // define filter to match images in html
		  Elements images = doc.select("img[src~=(?i)\\.(png|jpe?g|gif)]");  
          for (Element image : images) {  
       	  
        	  String text = image.attr("alt");
        	  String img_url = image.attr("src");
        	  String format = img_url.substring(img_url.lastIndexOf(".") , img_url.length());
        	  System.out.println(format);
        	  ImageInfo img = new ImageInfo(text+(format), img_url);
        	  list_images.add(img);
             
         }  
          
          
          // open connection to download images
          list_images.forEach((image)-> 
                
                    {
						try {
							DownloadImage(image.getUrl(), image.getText());
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
        		  
          );
         
		System.out.println("done!");
		
		
	}

	private static void DownloadImage(String image_url, String text) throws IOException {
		
	      URL url = new URL(image_url);
          InputStream inputStream = url.openStream();
          OutputStream outputStream = new FileOutputStream(new File(path+text));
          byte[] buffer = new byte[2048];
          
          int length = 0;
          
          while ((length = inputStream.read(buffer)) != -1) {
            
             outputStream.write(buffer, 0, length);
          }
          
          inputStream.close();
          outputStream.close();
	}
	
	
	static class ImageInfo
	{
		private String text;
		private String url;
		
		 ImageInfo(String text , String url) {
			
			this.text = text;
			this.url = url;
			
		}
		
		
		public String getText() {
			return text;
		}

		public String getUrl() {
			return url;
		}
		
		
		
	}

}
