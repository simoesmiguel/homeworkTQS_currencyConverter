/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloWorld;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class sendLiveRequest{

    // essential URL structure is built using constants
    public static final String ACCESS_KEY = "35a6f96d76c2195087f3d2a0bf27cd93";
    public static final String BASE_URL = "http://apilayer.net/api/";
    public static final String ENDPOINT = "live";

    // this object is used for executing requests to the (REST) API
    static CloseableHttpClient httpClient = HttpClients.createDefault();

    public sendLiveRequest(){
        
    }
    
    /**
     * 
     * Notes:
     * 
     * A JSON response of the form {"key":"value"} is considered a simple Java JSONObject.
     * To get a simple value from the JSONObject, use: <JSONObject identifier>.get<Type>("key");
     * 
     * A JSON response of the form {"key":{"key":"value"}} is considered a complex Java JSONObject.
     * To get a complex value like another JSONObject, use: <JSONObject identifier>.getJSONObject("key")
     * 
     * Values can also be JSONArray Objects. JSONArray objects are simple, consisting of multiple JSONObject Objects.
     * 
     * 
     */    

    // sendLiveRequest() function is created to request and retrieve the data
    public static String sendLiveRequest(String from, String to,String value){
        String liveCurrency="";
        double first_conversion,second_conversion,final_conversion = 0;
        // The following line initializes the HttpGet Object with the URL in order to send a request
        HttpGet get = new HttpGet(BASE_URL + ENDPOINT + "?access_key=" + ACCESS_KEY);

        try {
            CloseableHttpResponse response =  httpClient.execute(get);
            HttpEntity entity = response.getEntity();

            // the following line converts the JSON Response to an equivalent Java Object
            JSONObject exchangeRates = new JSONObject(EntityUtils.toString(entity));

            System.out.println("Live Currency Exchange Rates");
            System.out.println(exchangeRates);
            
            // Parsed JSON Objects are accessed according to the JSON resonse's hierarchy, output strings are built
            Date timeStampDate = new Date((long)(exchangeRates.getLong("timestamp")*1000)); 
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a");
            String formattedDate = dateFormat.format(timeStampDate);
            if(from!="USD" && to!="USD")
            {
                first_conversion = exchangeRates.getJSONObject("quotes").getDouble("USD"+from);
                second_conversion = Double.parseDouble(value)/first_conversion; // da-me o valor do 'from' em USD
                final_conversion = second_conversion* exchangeRates.getJSONObject("quotes").getDouble("USD"+to); // da o valor do 'from' em 'to' 
            }
            else
            {
                if(from!="USD")
                {    
                    final_conversion = Double.parseDouble(value)/exchangeRates.getJSONObject("quotes").getDouble("USD"+from);
                    
                }
                else
                {
                    final_conversion = Double.parseDouble(value)*exchangeRates.getJSONObject("quotes").getDouble("USD"+to);
                }
            }
            
            //System.out.println("1 " + exchangeRates.getString("source") + " in "+to +" : " + exchangeRates.getJSONObject("quotes").getDouble("USD"+to) + " (Date: " + formattedDate + ")");   
            //System.out.println("\n");
            System.out.println(value +" "+ from + " in "+to +" : " + final_conversion + " (Date: " + formattedDate + ")");   
            System.out.println("\n");
            
            liveCurrency = value +" "+ from + " in "+to +" : " + final_conversion;
            
            response.close();
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
      }
        
        return liveCurrency;
    }

        // sendLiveRequest() function is executed
    public static void main(String[] args) throws IOException{
        sendLiveRequest("EUR","USD","5");
        httpClient.close();
        new BufferedReader(new InputStreamReader(System.in)).readLine();
    }
}