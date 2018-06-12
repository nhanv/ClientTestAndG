/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package asgclient.entity.request;

import asgclient.constant.FieldRequest;
import org.json.simple.JSONObject;


/**
 *
 * @author Nguyen Van Nha
 */
public class Request {
    private int requestCode;

    public Request() {
        this.requestCode = -1;
    }

    public Request(int requestCode) {
        this.requestCode = requestCode;
    }

    public int getRequestCode() {
        return requestCode;
    }
    
    public JSONObject toJSON (){
        JSONObject result = new JSONObject ();
        result.put (FieldRequest.FIELD_REQUESTCODE, requestCode);
        return result;
    }
}
