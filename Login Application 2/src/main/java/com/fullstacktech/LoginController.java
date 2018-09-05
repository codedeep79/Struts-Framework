package com.fullstacktech;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



/**
 * Created by TRUNGNGUYENHAU on 9/4/2018.
 */

@Results({@Result(name = "showForm", location = "/WEB-INF/pages/login.jsp"),
          @Result(name = "loginError", location = "/WEB-INF/pages/login.jsp"),
          // loginSuccess: Redirect to /userInfo
          @Result(name = "loginSuccess", type="redirect", location= "/userInfo")
        })
public class LoginController extends ActionSupport {
    private static final long serialVersionUID = 7299264265184515893L;
    private String username;
    private String password;

    public LoginController() {
    }

    @Action(value = "/login")
    public String execute() {
        if (this.username == null && this.password == null) {
            return "showForm";
        }
        HttpServletRequest request = ServletActionContext.getRequest();
        // Username và password hợp lệ.
        if ("ngocnt".equals(this.username) && "admin".equals(this.password)) {
            HttpSession session = request.getSession();
            // Lưu trữ userName vào trong trong session.
            session.setAttribute("loginedUsername", this.username);
            return "loginSuccess";
        }
        // Username hoặc password không đúng
        else {
            // ** Xem trong ApplicationResources.properties
            String message = getText("error.login");
            addActionError(message);
            return "loginError";
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}