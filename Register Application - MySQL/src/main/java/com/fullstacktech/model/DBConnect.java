package com.fullstacktech.model;

import com.fullstacktech.controller.RegisterController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 * Created by TRUNGNGUYENHAU on 9/5/2018.
 */
public class DBConnect {
    final static String DB_NAME = "";
    final static String TABLE_USER = "user_details";
    final static String COLUMN_FIRSTNAME = "FIRST_NAME";
    final static String COLUMN_LASTNAME = "LAST_NAME";
    final static String COLUMN_USERNAME = "USER_NAME";
    final static String COLUMN_PASSWORD = "PASSWORD";
    final static String COLUMN_EMAIL = "EMAIL";
    final static String COLUMN_PHONE = "PHONE";

    private static Connection conn() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/struts_demo2", "root", "");
    }

    public static int register(RegisterController registerController) {
        int flag = 0;
        try {
            // Phải ghi rõ như thế này thì hạn chế sai
            PreparedStatement preparedStatement
                    = conn().prepareStatement("INSERT INTO " + TABLE_USER
                        + "(" + COLUMN_FIRSTNAME + "," + COLUMN_LASTNAME + ","
                              +  COLUMN_USERNAME + "," + COLUMN_PASSWORD + ","
                              +  COLUMN_EMAIL + "," + COLUMN_PHONE +")"
                              + " VALUES(?,?,?,?,?,?)");
            // AUTOINCREMENT thì set 0
            // Cột nào ghi đầu tiên từ trái sang phải trong câu lệnh truy vấn thì bắt đầu từ 1
            // Các chuổi giá trị trong text không được quá dài quá 50 vì đã set trong csdl
            preparedStatement.setString(1, registerController.getFirstname());
            preparedStatement.setString(2, registerController.getLastname());
            preparedStatement.setString(3, registerController.getUsername());
            preparedStatement.setString(4, registerController.getPassword());
            preparedStatement.setString(5, registerController.getEmail());
            preparedStatement.setString(6, registerController.getPhone());
            flag = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public static boolean getUser(String userName, String password) throws Exception {
        PreparedStatement preparedStatement = conn().prepareStatement("SELECT * FROM " + TABLE_USER
                + " WHERE " + COLUMN_PASSWORD + " = "
                + password + " AND " + COLUMN_USERNAME + " = " + userName);
        ResultSet rs = preparedStatement.executeQuery();
        boolean result  = rs.next();
        return result;
    }

    public static int updatePassword(String email, String password) throws Exception {
        PreparedStatement preparedStatement = conn().prepareStatement("update " + TABLE_USER + " set password=? where email=?");
        preparedStatement.setString(1, password);
        preparedStatement.setString(2, email);
        int result = preparedStatement.executeUpdate();
        return result;
    }
} 