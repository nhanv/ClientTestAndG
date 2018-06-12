package asgclient.result.extend;

import asgclient.result.Result;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nguyen Van Nha
 * @param <T>
 */
public class ListResult<T> extends Result {
    private List<T> list;

    public ListResult() {
        super ();
        list = null;
    }

    public ListResult(List<T> user) {
        super ();
        this.list = user;
    }

    public ListResult(List<T> user, int code) {
        super(code);
        this.list = user;
    }

    public void setList(List<T> user) {
        this.list = user;
    }

    public ListResult(int code) {
        super(code);
        this.list = null;
    }

    public List<T> getList() {
        return list;
    }
}
