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
public class ChangePassRequest extends Request {
    private String token;
    private User u;
    private String newPass;

    public ChangePassRequest() {
        super();
        this.u = null;
        this.newPass = null;
        this.token = null;
    }

    public ChangePassRequest(int rqCode, String token, User u, String newPass) {
        super(rqCode);
        this.token = token;
        this.u = u;
        this.newPass = newPass;
    }

    public String getToken() {
        return token;
    }

    public User getU() {
        return u;
    }

    public String getNewPass() {
        return newPass;
    }
    
    @Override
    public JSONObject toJSON (){
        JSONObject result = new JSONObject();
        result.put(FieldRequest.FIELD_REQUESTCODE, this.getRequestCode());
        result.put(FieldRequest.FIELD_TOKEN, token);
        result.put(FieldRequest.FIELD_PASSWORD, u.getPassword());
        result.put(FieldRequest.FIELD_NEWPASSWORD, newPass);
        
        return result;
    }
}
