package com.comcast.crm.generic.fileutility;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonUtility {
	
	public String getDataFromJsonFile(String key) throws FileNotFoundException {
		FileReader fileR=new FileReader("./ConfigAppData/");
		JsonParser parser=new JsonParser();
		JsonElement obj = parser.parse(fileR);
		JsonObject map=(JsonObject) obj;
		JsonElement data= map.get(key);
		return key;
		
	}

}
