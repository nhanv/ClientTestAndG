/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package asgclient.connecthandler;

import asgclient.entity.request.Request;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Nguyen Van Nha
 */
public class SendRequest {
    
    /**
     * send data to server by method get
     * @param un
     * @param pw
     * @param host
     * @param port
     * @return a string response from server
     * @throws UnsupportedEncodingException 
     */
    public static String sendByGet(String un, String pw, String host, int port)
                         throws UnsupportedEncodingException {
        String result = "";
        String charset = "UTF-8";
        String query = String.format("id=%s&password=%s",
                URLEncoder.encode(un, charset),
                URLEncoder.encode(pw, charset));

        try {
            String urlStr = "http://" + host + ":" + port + "/";
            URL u = new URL(urlStr + query);
            //open connection
            HttpURLConnection conn = (HttpURLConnection) u.openConnection();
            conn.setRequestProperty("Accept-charset", charset);

            //get data response from server
            InputStream is = conn.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader buf = new BufferedReader(isr);

            //read data
            result = buf.readLine();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * send data to server by method post
     * @param or
     * @param host
     * @param port
     * @return 
     */
    public static String sendByPost(Request or, String host, int port) {
        String result = "";
        String charset = "UTF-8";

        try {
            String urlStr = "http://" + host + ":" + port + "/";
            JSONObject js = or.toJSON();
            //System.out.println("JSON:" + js.toString());
            URL u = new URL(urlStr);

            //open connect
            HttpURLConnection conn = (HttpURLConnection) u.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");

            //provide data
            StringBuilder posData = new StringBuilder();
            posData.append(js);
            String encodeData = posData.toString();
            byte[] postDataByte = posData.toString().getBytes(charset);

            //send data
            conn.setRequestProperty("Content-Language", "en-US");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", (new Integer(encodeData.length())).toString());

            OutputStream out = conn.getOutputStream();
            out.write(postDataByte);
            out.close();

            //get response from server
            InputStream is = conn.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader buf = new BufferedReader(isr);

            //read data
            JSONParser jsp = new JSONParser();
            JSONObject jso = (JSONObject)jsp.parse(isr);
            
            result = jso.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}
