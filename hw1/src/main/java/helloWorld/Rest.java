/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloWorld;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;


/**
 * REST Web Service
 *
 * @author Miguel Simões
 */
@Path("helloWorld")
public class Rest {

    @Context
    private UriInfo context;
    /**
     * Creates a new instance of HelloWorld
     */
    public Rest() {
    }

    /**
     * Retrieves representation of an instance of helloWorld.HelloWorld
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getHtml() {
        //TODO return proper representation object
        sendLiveRequest slr = new sendLiveRequest();
        return "";
    }

    /**
     * PUT method for updating or creating an instance of HelloWorld
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.TEXT_HTML)
    public void putHtml(String content) {
    }
    
    
    @POST
    public String createCustomer(@FormParam("value") String value,
                                @FormParam("selectFrom") String selectFrom,@FormParam("selectTo") String selectTo
    ) {
        sendLiveRequest slr = new sendLiveRequest();
        return slr.sendLiveRequest(selectFrom,selectTo,value);
    }

} 
   
  
       


