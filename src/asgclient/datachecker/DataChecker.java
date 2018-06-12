/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package asgclient.datachecker;

import asgclient.constant.ErrorCode;

/**
 *
 * @author Nguyen Van Nha
 */
public class DataChecker {
    /**
     * check data before register
     * @param email
     * @param pass
     * @param name
     * @param age
     * @return a error code
     */
    public static int checkRegister (String email, String pass, String name, int age){
        int result;
        if (email == null || email.isEmpty())
            result = ErrorCode.INVAILABLE_EMAIL;
        else if (pass == null || pass.isEmpty())
            result = ErrorCode.INVAILABLE_PASSWORD;
        else if (name == null || name.isEmpty())
            result = ErrorCode.INVAILABLE_USERNAME;
        else if (age < 0 || age > 150)
            result = ErrorCode.INVAILABLE_AGE;
        else
            result = ErrorCode.SUCCESSFULLY_CODE;
        
        return result;
    }
    
    /**
     * check data before login
     * @param email
     * @param pass
     * @return a error code
     */
    public static int checkLogin (String email, String pass){
        int result;
        if (email == null || email.isEmpty())
            result = ErrorCode.INVAILABLE_EMAIL;
        else if (pass == null || pass.isEmpty())
            result = ErrorCode.INVAILABLE_PASSWORD;
        else
            result = ErrorCode.SUCCESSFULLY_CODE;
        
        return result;
    }
    
    /**
     * check token
     * @param token
     * @return error code
     */
    public static int checkToken (String token){
        int result;
        if (token == null || token.isEmpty())
            result = ErrorCode.TOKEN_ERROR;
        else
            result = ErrorCode.SUCCESSFULLY_CODE;
        return result;
    }
    
    /**
     * check context to add new friend
     * @param token
     * @param email
     * @return 
     */
    public static int checkAddFriend (String token, String email){
        int result;
        if (email == null || email.isEmpty())
            result = ErrorCode.INVAILABLE_EMAIL;
        else if (token == null || token.isEmpty())
            result = ErrorCode.TOKEN_ERROR;
        else
            result = ErrorCode.SUCCESSFULLY_CODE;
        return result;
    }
    
    /**
     * check data begin change password
     * @param token
     * @param oldP
     * @param newP
     * @return 
     */
    public static int checkChangePass (String token, String oldP, String newP){
        int result;
        if (token == null || token.isEmpty())
            result = ErrorCode.TOKEN_ERROR;
        else if (oldP == null || oldP.isEmpty())
            result = ErrorCode.INVAILABLE_PASSWORD;
        else if (newP == null || newP.isEmpty())
            result = ErrorCode.INVAILABLE_PASSWORD;
        else if (newP.equals(oldP))
            result = ErrorCode.PASSWORD_DUPLICATE;
        else
            result = ErrorCode.SUCCESSFULLY_CODE;
        
        return result;
    }
    
    /**
     * check response
     * @param response
     * @return 
     */
    public static int checkResponse (String response){
        int result;
        if (response == null || response.isEmpty())
            result = ErrorCode.RESPONSE_ERROR;
        else
            result = ErrorCode.SUCCESSFULLY_CODE;
        return result;
    }
    
}
