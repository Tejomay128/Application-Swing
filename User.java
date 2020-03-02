package com.mycompany.myproject;


public class User {
    String usrname;
    int age;
    String email;
    String passwd;
    String phoneno;

    public String getUsrname() {
        return usrname;
    }

    public void setUsrname(String name) {
        this.usrname = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }
}
