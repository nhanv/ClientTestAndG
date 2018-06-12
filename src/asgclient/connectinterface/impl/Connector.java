/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package asgclient.connectinterface.impl;

import asgclient.connecthandler.SendRequest;
import asgclient.connecthandler.responsehandler.ResponseHandler;
import asgclient.connecthandler.responsehandler.extend.LoginResponse;
import asgclient.connecthandler.responsehandler.extend.ViewFriendListResponse;
import asgclient.connecthandler.responsehandler.extend.ViewInfoResponse;
import asgclient.connectinterface.IConnector;
import asgclient.constant.ErrorCode;
import asgclient.constant.RequestCode;
import asgclient.datachecker.DataChecker;
import asgclient.entity.User;
import asgclient.entity.request.extend.AddFriendRequest;
import asgclient.entity.request.extend.ChangePassRequest;
import asgclient.entity.request.extend.LoginRequest;
import asgclient.entity.request.extend.RegisterRequest;
import asgclient.entity.request.extend.ViewInfoRequest;
import asgclient.entity.request.extend.ViewFriendListRequest;
import asgclient.result.Result;
import asgclient.result.extend.StringResult;
import asgclient.result.extend.ListResult;
import java.util.List;

/**
 *
 * @author Nguyen Van Nha
 */
public class Connector implements IConnector{
    private static final String HOST = "localhost";
    private static final int PORT = 8082;

    /**
     * Register
     * @param u
     * @return a Result
     */
    @Override
    public Result register(User u) {
        Result result = new Result();
        int code = DataChecker.checkRegister(u.getEmail(), u.getPassword(),
                                             u.getName(), u.getAge());
        try{
            if (code == ErrorCode.SUCCESSFULLY_CODE){
                //send request
                RegisterRequest or = new RegisterRequest(RequestCode.REGISTER_CODE, u);
                //get response
                String str = SendRequest.sendByPost(or, HOST, PORT);
                int ckResponse = DataChecker.checkResponse(str);
                if (ckResponse == ErrorCode.SUCCESSFULLY_CODE){
                    int rs = ResponseHandler.getErrorCode(str);
                    result = new Result (rs);
                }else{
                    result = new Result (ckResponse);
                }
            }else
                result = new Result (code);
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return result;
    }

    /**
     * login
     * @param u
     * @return token
     */
    @Override
    public StringResult login(User u) {
        StringResult result = new StringResult();
        //check account login
        int code = DataChecker.checkLogin(u.getEmail(), u.getPassword());
        try {
            if (code == ErrorCode.SUCCESSFULLY_CODE){
                //create request
                LoginRequest or = new LoginRequest(RequestCode.LOGIN_CODE, u);
                //get response
                String str = SendRequest.sendByPost(or, HOST, PORT);
                int ckResponse = DataChecker.checkResponse(str);
                if (ckResponse == ErrorCode.SUCCESSFULLY_CODE){
                    //get token and error code
                    int rs = ResponseHandler.getErrorCode(str);
                    String token = LoginResponse.getToken(str);
                    
                    result = new StringResult(token, rs);
                }else{
                    result = new StringResult (ckResponse);
                }
            }else{
                result = new StringResult (code);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        
        return result;
    }

    /**
     * get info by token
     * @param token
     * @return a ListResult
     */
    @Override
    public StringResult getInfo(String token) {
        StringResult result = new StringResult();
        int code = DataChecker.checkToken(token);
        try{
            if (code == ErrorCode.SUCCESSFULLY_CODE){
                //create request
                ViewInfoRequest or = new ViewInfoRequest(RequestCode.GETINFO_CODE,
                                                         token);
                //get response
                String str = SendRequest.sendByPost(or, HOST, PORT);
                int ckResponse = DataChecker.checkResponse(str);
                if (ckResponse == ErrorCode.SUCCESSFULLY_CODE){
                    //get info and response code
                    int rs = ResponseHandler.getErrorCode(str); //error code
                    String info = ViewInfoResponse.getInfo(str);//info
                    
                    result = new StringResult(info, rs);
                }else{
                    result = new StringResult (ckResponse);
                }
            }else{
                result = new StringResult (code);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * add new friend into friend list
     * @param token
     * @param frEmail
     * @return a result
     */
    @Override
    public Result addFriend(String token, String frEmail) {
        Result result = new Result ();
        int code = DataChecker.checkAddFriend(token, frEmail);
        try{
            if (code == ErrorCode.SUCCESSFULLY_CODE){
                //create request
                AddFriendRequest or = new AddFriendRequest(RequestCode.ADDFRIEND_CODE,
                                                           token, frEmail);
                //get response
                String str = SendRequest.sendByPost(or, HOST, PORT);
                int ckResponse = DataChecker.checkResponse(str);
                if (ckResponse == ErrorCode.SUCCESSFULLY_CODE){
                    //get response code
                    int rs = ResponseHandler.getErrorCode(str); //error code
                    result = new Result(rs);
                }else{
                    result = new Result (ckResponse);
                }
            }else{
                result = new Result (code);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * get list friend
     * @param token
     * @return list friend
     */
    @Override
    public ListResult getFriendList(String token) {
        ListResult result = new ListResult();
        int code = DataChecker.checkToken(token);
        try{
            if (code == ErrorCode.SUCCESSFULLY_CODE){
                //create request
                ViewFriendListRequest or = new ViewFriendListRequest(RequestCode.GETFRIENDLIST_CODE,
                                                                     token);
                //get response
                String str = SendRequest.sendByPost(or, HOST, PORT);
                int ckResponse = DataChecker.checkResponse(str);
                if (ckResponse == ErrorCode.SUCCESSFULLY_CODE){
                    //get list friend
                    int rs = ResponseHandler.getErrorCode(str);
                    List listFriend = ViewFriendListResponse.getFriendList(str);
                    
                    result = new ListResult(listFriend, rs);
                }else{
                    result = new ListResult (ckResponse);
                }
            }else{
                result = new ListResult (code);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    /**
     * change password
     * @param token
     * @param u
     * @param newPass
     * @return 
     */
    @Override
    public Result ChangePassword(String token, User u, String newPass) {
        Result result = new Result();
        int code = DataChecker.checkChangePass(token, u.getPassword(), newPass);
        try {
            if (code == ErrorCode.SUCCESSFULLY_CODE){
                //create request
                ChangePassRequest or = new ChangePassRequest(RequestCode.CHANGEPASSWORD_CODE,
                                                             token, u, newPass);
                //get response
                String str = SendRequest.sendByPost(or, HOST, PORT);
                int ckResponse = DataChecker.checkResponse(str);
                if (ckResponse == ErrorCode.SUCCESSFULLY_CODE){
                    //get list friend
                    int rs = ResponseHandler.getErrorCode(str);
                    result = new Result( rs);
                }else{
                    result = new Result (ckResponse);
                }
            }else{
                result = new Result (code);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        
        
        return result;       
    }
    
}
