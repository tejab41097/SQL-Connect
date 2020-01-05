package com.tejab.sqlserver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginProcess {
    Connection connect;
    String ConnectionResult = "";
    String ip;

    public String login_check(String eemail,String epassword) {
        String email,password;
        ConnectionResult="Check Email or password!!";
        IpClass ipClass=new IpClass();
        ip=ipClass.getIP();
        try
        {
            ConnectClass conStr=new ConnectClass();
            connect =conStr.connections(ip);
            if(connect==null)
            {
                ConnectionResult = "Check Your Internet Access!";
            }
            else
            {
                String query = "select * from login where email='"+eemail+"' and password='"+epassword+"';";
                Statement stmt = connect.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()){
                    email= rs.getString("email").toString();
                    password=rs.getString("password").toString();
                    if(email.equals(eemail) && epassword.equals(password)){
                        ConnectionResult="successful";
                        break;
                    }
                }
                connect.close();
            }
        }
        catch (Exception ex)
        {
            ConnectionResult = ex.getMessage();
        }
        return ConnectionResult;
    }

    public String check_registerCustomer(String type,String cat,String name,String phone,String email,String password){
        IpClass ipClass=new IpClass();
        ip=ipClass.getIP();
        if (email.equals("")||password.equals("")) {
            ConnectionResult = "Please enter valid id & password!!";
        }
        else
        {
        try {
            ConnectClass conStr = new ConnectClass();
            connect = conStr.connections(ip);

                if (connect == null) {
                    ConnectionResult = "Check Your Internet Access!";
                } else {
                    if (Not_already_exist(email)) {
                        String query = "insert into login(type,category,name,phone,email,password) values ('"+ type +"','"+ cat +"','"+ name +"','"+ phone +"','" + email + "','" + password + "');";
                        Statement stmt = connect.createStatement();
                        stmt.executeUpdate(query);
                        ConnectionResult = "successful";
                        connect.close();

                    } else {
                        ConnectionResult = "Id already exist!! please use another id!!";
                    }
                }
            }
        catch(Exception ex)
            {
                ConnectionResult = ex.getMessage();
            }
        }
        return ConnectionResult;
    }
    public String check_registerVendor(String type,String org,String gst,String enpol,String phone,String email,String password){
        IpClass ipClass=new IpClass();
        ip=ipClass.getIP();
        if (email.equals("")||password.equals("")) {
            ConnectionResult = "Please enter valid id & password!!";
        }
        else
        {
            try {
                ConnectClass conStr = new ConnectClass();
                connect = conStr.connections(ip);

                if (connect == null) {
                    ConnectionResult = "Check Your Internet Access!";
                } else {
                    if (Not_already_exist(email)) {
                        String query = "insert into login(type,organisation,gst,enpolio,phone,email,password) values ('"+ type +"','"+ org +"','"+ gst +"','"+ enpol +"','"+ phone +"','" + email + "','" + password + "');";
                        Statement stmt = connect.createStatement();
                        stmt.executeUpdate(query);
                        ConnectionResult = "successful";
                        connect.close();

                    } else {
                        ConnectionResult = "Id already exist!! please use another id!!";
                    }
                }
            }
            catch(Exception ex)
            {
                ConnectionResult = ex.getMessage();
            }
        }
        return ConnectionResult;
    }

    public boolean Not_already_exist(String email) throws SQLException {
        String query="select * from login where email='"+email+"';";
        Statement stmt=connect.createStatement();
        ResultSet rs=stmt.executeQuery(query);
        if (!rs.next()){
            return true;
        }else
            return false;
    }
    }
