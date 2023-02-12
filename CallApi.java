package com.cloudmicro;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL; 






public class CallApi {

	public static void main(String[] args) {
		try {
		         call_me();
		        } catch (Exception e) {
		         e.printStackTrace();
		       }
	}
			   
	public static void call_me() throws Exception {
	     String url = "https://63813c578e5d4aea868d2b3276dafc1b.southeastasia.azure.elastic-cloud.com/search-data/_search";
	     URL obj = new URL(url);
	     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	     con.setDoOutput(true);
	     // optional default is GET
	     con.setRequestMethod("GET");
	     //add request header
	    // con.setRequestProperty("User-Agent", "Mozilla/5.0");
	     con.setRequestProperty("Authorization", "ApiKey SGtCc1JZWUI3d0owcUZHZjFYSTQ6YUloV24telRSSTZWdmw0VXBUUTBsQQ==");
	     con.setRequestProperty("Content-Type", "application/json");
	     String jsonInputString = "{ \"query\": { \"match\": { \"last_name\": \"Taylo\" } } }";
	     // String jsonInputString = "{ \"query\": { \"match_all\": {} } }";
	     try(OutputStream os = con.getOutputStream()) {
	    	    byte[] input = jsonInputString.getBytes("utf-8");
	    	    os.write(input, 0, input.length);			
	    	}
	     int responseCode = con.getResponseCode();
	     System.out.println("\nSending 'GET' request to URL : " + url);
	     System.out.println("Response Code : " + responseCode);
	     BufferedReader in = new BufferedReader(
	             new InputStreamReader(con.getInputStream()));
	     String inputLine;
	     StringBuffer response = new StringBuffer();
	     while ((inputLine = in.readLine()) != null) {
	     	response.append(inputLine);
	     }
	     in.close();
	     //print in String
	     System.out.println(response.toString());
	     
	     
	     
	   }	
		
	

}

