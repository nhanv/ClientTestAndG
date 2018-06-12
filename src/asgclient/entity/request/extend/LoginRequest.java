/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package asgclient.entity.request.extend;

import asgclient.constant.FieldRequest;
import asgclient.entity.User;
import asgclient.entity.request.Request;
import org.json.simple.JSONObject;

/**
 *
 * @author Nguyen Van Nha
 */
public class LoginRequest extends Request {
    private User user;

    public LoginRequest() {
        super ();
        this.user = null;
    }

    public LoginRequest(int requestCode, User user) {
        super (requestCode);
        this.user = user;
    }

    public User getUser() {
        return user;
    }
    
    @Override
    public JSONObject toJSON (){
        JSONObject result = new JSONObject();
        result.put(FieldRequest.FIELD_REQUESTCODE, this.getRequestCode());
        result.put(FieldRequest.FIELD_EMAIL, user.getEmail());
        result.put(FieldRequest.FIELD_PASSWORD, user.getPassword());
        
        return result;
    }
}
