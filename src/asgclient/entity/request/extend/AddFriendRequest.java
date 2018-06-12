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
public class AddFriendRequest extends Request {
    private String token;
    private String frEmail;

    public AddFriendRequest() {
        this.token = null;
        this.frEmail = null;
    }

    public AddFriendRequest(int requestCode, String token, String frEmail) {
        super(requestCode);
        this.token = token;
        this.frEmail = frEmail;
    }

    public String getToken() {
        return token;
    }

    public String getFrEmail() {
        return frEmail;
    }
    
    @Override
    public JSONObject toJSON (){
        JSONObject result = new JSONObject();
        result.put(FieldRequest.FIELD_REQUESTCODE, this.getRequestCode());
        result.put(FieldRequest.FIELD_TOKEN, token);
        result.put(FieldRequest.FIELD_FREMAIL, frEmail);
        
        return result;
    }
}
