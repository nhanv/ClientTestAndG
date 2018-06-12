/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package asgclient.entity.request.extend;

import asgclient.constant.FieldRequest;
import asgclient.entity.request.Request;
import org.json.simple.JSONObject;

/**
 *
 * @author Nguyen Van Nha
 */
public class ViewInfoRequest extends Request{
    private String token;

    public ViewInfoRequest() {
        super ();
        this.token = null;
    }

    public ViewInfoRequest(int requestCode, String token) {
        super(requestCode);
        this.token = token;
    }

    public String getToken() {
        return token;
    }
    
    @Override
    public JSONObject toJSON (){
        JSONObject result = new JSONObject();
        result.put(FieldRequest.FIELD_REQUESTCODE, this.getRequestCode());
        result.put(FieldRequest.FIELD_TOKEN, token);
        
        return result;
    }
}
