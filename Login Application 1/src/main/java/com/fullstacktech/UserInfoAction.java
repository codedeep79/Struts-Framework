package com.fullstacktech;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by TRUNGNGUYENHAU on 9/4/2018.
 */


public class UserInfoAction extends ActionSupport {
    private static final long serialVersionUID = 7299264265184515893L;

    @Override
    public String execute() {

        return "userInfoPage";
    }
} 