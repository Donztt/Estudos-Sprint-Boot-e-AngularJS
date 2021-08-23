package com.example.SprintLearning.Utilities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class Utilitario {
	public static JSONObject pegarJSONURL(String URL) {
	
		try {
			
			URL url = new URL(URL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
			con.setRequestMethod("GET");
			
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			
			String inputLine;
			StringBuffer response = new StringBuffer();
			
			while((inputLine = in.readLine()) != null) {
					response.append(inputLine);
			}
			in.close();
			
			JSONObject json = new JSONObject(response.toString());
			return json;
		
		} 
		catch (Exception e) {
			System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ " + e.getMessage());
			return null;
		}  
	}
}
