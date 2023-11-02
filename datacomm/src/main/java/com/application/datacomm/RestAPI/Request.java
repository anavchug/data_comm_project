package com.application.datacomm.RestAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Request {
         public static String makeRequest(String apiUrl) throws Exception{
            URL request = new URL(apiUrl);
            HttpURLConnection con = (HttpURLConnection) request.openConnection();
            con.setRequestMethod("GET");
            
            BufferedReader in = new BufferedReader(
            new InputStreamReader(con.getInputStream()));

            String inputLine;

            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();

            return content.toString();

        }
}
