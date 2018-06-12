/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package asgclient.connecthandler.responsehandler.extend;

import asgclient.connecthandler.responsehandler.ResponseHandler;
import static asgclient.connecthandler.responsehandler.ResponseHandler.FIELD_RESPONSE;
import static asgclient.connecthandler.responsehandler.ResponseHandler.convertJSON;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Nguyen Van Nha
 */
public class ViewFriendListResponse extends ResponseHandler {
    /**
     * get list response
     * @param response
     * @return
     * @throws ParseException 
     */
    public static List getFriendList (String response) throws ParseException{
        List<String> list = new ArrayList<>();
        
        JSONObject jso = convertJSON(response);
        JSONArray jsArr = (JSONArray)jso.get(FIELD_RESPONSE);
        if (jsArr != null){
            Iterator<String> iterator = jsArr.iterator();
            while (iterator.hasNext()) {
                list.add(iterator.next());
            }
        }
        
        return list;
    }
}
