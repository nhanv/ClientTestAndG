/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package asgclient.result.extend;

import asgclient.result.Result;

/**
 *
 * @author Nguyen Van Nha
 */
public class StringResult extends Result {
    private String result;

    public StringResult() {
        super();
    }

    public StringResult(int code) {
        super(code);
        this.result = null;
    }

    public StringResult(String token, int code) {
        super(code);
        this.result = token;
    }

    public void setResult(String token) {
        this.result = token;
    }

    public String getResult() {
        return result;
    }
}
