/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package asgclient.connectinterface;

import asgclient.entity.User;
import asgclient.result.Result;
import asgclient.result.extend.StringResult;
import asgclient.result.extend.ListResult;

/**
 *
 * @author Nguyen Van Nha
 */
public interface IConnector {
    /**
     * register new user object
     * @param u
     * @return 
     */
    public Result register (User u);
    /**
     * user object login
     * @param u
     * @return 
     */
    public StringResult login (User u);
    /**
     * get info of user
     * @param token
     * @return 
     */
    public StringResult getInfo (String token);
    /**
     * change password by new password
     * @param token
     * @param u
     * @param newPass
     * @return 
     */
    public Result ChangePassword (String token, User u, String newPass); 
    /**
     * add other user into friend list
     * @param token
     * @param frEmail
     * @return 
     */
    public Result addFriend (String token, String frEmail);
    /**
     * get fiend list
     * @param token
     * @return 
     */
    public ListResult getFriendList (String token);
}
