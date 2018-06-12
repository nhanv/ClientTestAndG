/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package asgclient;

import asgclient.connectinterface.impl.Connector;
import asgclient.constant.ErrorCode;
import asgclient.entity.User;
import asgclient.result.Result;
import asgclient.result.extend.StringResult;
import asgclient.result.extend.ListResult;

/**
 *
 * @author Nguyen Van Nha
 */
public class Main {
    private static final Connector connect = new Connector ();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String email = "xyz@abc";
        String password = "123abc";
        String newPassword = "123abc";
        String name = "Ly Hoang Nam";
        int age = 21;
        String frEmail = "abc@xyz";
        
        registerAccount(email, password, name, age);
        String tokenResponse = login(email, password);
        System.out.println("Token:" + tokenResponse);
        
        //check over time life of session
        try {
            Thread.sleep(6000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
        viewInfo(tokenResponse);
        changePassword(tokenResponse, password, newPassword);
        
        addFriend(tokenResponse, frEmail);
        viewFriendList(tokenResponse);
        
    }
    
    //==========================================================================
    /**
     * register new account with email, password, name and age
     * @param email
     * @param pass
     * @param name
     * @param age 
     */
    private static void registerAccount (String email, String pass, String name,
                                         int age){
        User u = new User(email, pass, name, age);
        Result rs = connect.register(u);
        printResult(rs);
    }
    
    /**
     * login with email and password
     * @param email
     * @param pass
     * @return a token
     */
    private static String login (String email, String pass){
        User u = new User(email, pass);
        StringResult rs = connect.login(u);
        printResult(rs);
        
        return rs.getResult();
    }
    
    /**
     * view info of user
     * @param token 
     */
    private static void viewInfo (String token){
        StringResult rs = connect.getInfo(token);
        if (rs.getResult() != null && !rs.getResult().isEmpty()){
            System.out.println("Infomation:");
            System.out.println(rs.getResult());
        }
        printResult(rs);
    }
    
    /**
     * change password by new password not equal old password
     * @param token
     * @param oldP
     * @param newP 
     */
    private static void  changePassword (String token, String oldP, String newP){
        User u = new User(null, oldP);
        Result rs = connect.ChangePassword(token, u, newP);
        printResult(rs);
    }
    /**
     * add other user into friend list
     * @param token
     * @param email 
     */
    private static void addFriend (String token, String email){
        Result rs = connect.addFriend(token, email);
        printResult(rs);
    }
    
    /**
     * get friend list
     * @param token 
     */
    private static void viewFriendList (String token){
        ListResult rs = connect.getFriendList(token);
        if (rs.getList()!= null){
            System.out.println("Friend list:");
            int size = rs.getList().size();
            for (int i = 0; i < size; i++) {
                System.out.println(rs.getList().get(i));
            }
        }
        printResult(rs);
    }
    
    private static void printResult (Result rs){
        if (rs == null){
            System.out.println("UNKNOWN ERROR.");
        }else{
            switch (rs.getCode()) {
                case ErrorCode.UNKNOWN_CODE:
                    System.out.println("Unkown error");
                    break;
                case ErrorCode.COLLECTION_ISEMPTY:
                    System.out.println("Collection is empty.");
                    break;
                case ErrorCode.SUCCESSFULLY_CODE:
                    System.out.println("Successfully.");
                    break;
                case ErrorCode.IDLOGIN_DUPLICATE:
                    System.out.println("Id login duplicate");
                    break;
                case ErrorCode.INVAILABLE_AGE:
                    System.out.println("Invailable age");
                    break;
                case ErrorCode.INRELATIONSHIP:
                    System.out.println("Inrelationship");
                    break;
                case ErrorCode.INVAILABLE_EMAIL:
                    System.out.println("Invailable email");
                    break;
                case ErrorCode.INVAILABLE_ID:
                    System.out.println("Invailable id");
                    break;
                case ErrorCode.INVAILABLE_PASSWORD:
                    System.out.println("Invailable password");
                    break;
                case ErrorCode.INVAILABLE_USERNAME:
                    System.out.println("Invailable username");
                    break;
                case ErrorCode.WRONG_EMAIL:
                    System.out.println("Wrong email");
                    break;
                case ErrorCode.WRONG_ID:
                    System.out.println("Wrong id");
                    break;
                case ErrorCode.WRONG_PASSWORD:
                    System.out.println("Wrong password");
                    break;
                case ErrorCode.EMAIL_DUPLICATE:
                    System.out.println("Email duplicate");
                    break;
                case ErrorCode.TOKEN_ERROR:
                    System.out.println("Token error.");
                    break;
                case ErrorCode.CONNECT_ERROR:
                    System.out.println("Connect error");
                    break;
                case ErrorCode.USER_NOT_FOUND:
                    System.out.println("User not found");
                    break;
                case ErrorCode.LIST_ISEMPTY:
                    System.out.println("List is empty");
                    break;
                case ErrorCode.RESPONSE_ERROR:
                    System.out.println("Response error.");
                    break;
                case ErrorCode.PASSWORD_DUPLICATE:
                    System.out.println("Password duplicate.");
                    break;
                default:
                    throw new AssertionError();
            }
        }
    }
    
}
