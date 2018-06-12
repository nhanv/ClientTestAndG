/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package asgclient.connecthandler.responsehandler.extend;

import asgclient.connecthandler.responsehandler.ResponseHandler;
import static asgclient.connecthandler.responsehandler.ResponseHandler.FIELD_RESPONSE;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Nguyen Van Nha
 */
public class LoginResponse extends ResponseHandler {
    /**
     * get response
     * @param response
     * @return
     * @throws ParseException 
     */
    public static String getToken (String response) throws ParseException{
        JSONObject jso = ResponseHandler.convertJSON(response);
        String token = (String)jso.get(FIELD_RESPONSE);        
        return token;
    }
}
