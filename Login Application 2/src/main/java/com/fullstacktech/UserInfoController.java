package com.fullstacktech;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

/**
 * Created by TRUNGNGUYENHAU on 9/4/2018.
 */
@Action(value = "userInfo",
        results = {
                @Result(name = "userInfoPage", location = "/WEB-INF/pages/userinfo.jsp")
        }
)
public class UserInfoController extends ActionSupport {
    private static final long serialVersionUID = 1L;
    @Override
    public String execute() {
        return "userInfoPage";
    }

}