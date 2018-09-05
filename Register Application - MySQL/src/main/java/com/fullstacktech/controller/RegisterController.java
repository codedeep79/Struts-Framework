package com.fullstacktech.controller;

import com.fullstacktech.model.DBConnect;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by TRUNGNGUYENHAU on 9/5/2018.
 */
@Action(value = "/register", results= {
    @Result(name = "registerAccount", location = "/WEB-INF/pages/register.jsp"),
    @Result(name = "registerSuccess", location = "/WEB-INF/pages/registered.jsp"),
    @Result(name = "registerFailed", location = "/WEB-INF/pages/register.jsp")
})
public class RegisterController extends ActionSupport {
    private int id;
    private String firstname, lastname, username, password, email, phone;
    @Override
    public String execute() throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();

        if (this.firstname == null && this.lastname == null
                && this.username == null && this.password == null
                && this.email == null && this.phone == null) {
            return "registerAccount";
        }
        else
        {
            int var = DBConnect.register(this);
            HttpSession session = request.getSession();
            session.setAttribute("firstname", this.firstname);
            session.setAttribute("lastname", this.lastname);
            session.setAttribute("username", this.username);
            session.setAttribute("email", this.email);
            // Do chỉ set được tối đa 6 cột nên phone giá trị là do sesion lấy từ form
            session.setAttribute("phone", this.phone);
            if (var > 0) {
                session.setAttribute("status", "Successfully");
                return "registerSuccess";
            } else {
                return "registerFailed";
            }
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Implement getter and setter
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}