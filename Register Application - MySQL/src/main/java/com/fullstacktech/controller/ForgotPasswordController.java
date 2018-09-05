package com.fullstacktech.controller;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

/**
 * Created by TRUNGNGUYENHAU on 9/5/2018.
 */
@Action(value = "/forgot", results= {
    @Result(name = "forgotPassword", location = "/WEB-INF/pages/forgotpassword.jsp"),
    @Result(name = "updatePaswordFailed", location = "/WEB-INF/pages/forgotpassword.jsp"),
    @Result(name = "updatePaswordSuccess", location = "/WEB-INF/pages/updatedpassword.jsp")
})
public class ForgotPasswordController extends ActionSupport {
    private String password, confirmPassword, email;
    @Override
    public String execute() throws Exception {
        return "forgotPassword";
    }
    // Implement getter and setter
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}