/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package asgclient.connecthandler.responsehandler;

import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Nguyen Van Nha
 */
public class ResponseHandler {
    public static final String FIELD_ERRORCODE = "responsecode";
    public static final String FIELD_RESPONSE = "response";
    
    /**
     * get error code
     * @param response
     * @return
     * @throws ParseException 
     */
    public static int getErrorCode (String response) throws ParseException{
        JSONObject jso = convertJSON(response);
        long code = (Long)jso.get(FIELD_ERRORCODE);
        
        return (int)code;
    }
    
    /**
     * parser string to JSON
     * @param input
     * @return
     * @throws ParseException 
     */
    public static JSONObject convertJSON (String input) throws ParseException{
        JSONParser jsp = new JSONParser();
        JSONObject result = (JSONObject)jsp.parse(input);
        return result;
    }
    
}
