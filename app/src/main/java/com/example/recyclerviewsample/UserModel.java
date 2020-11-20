package com.example.recyclerviewsample;

import java.io.Serializable;

public class UserModel implements Serializable {

    private String sigla;
    private String userName;
    private String tpi;


    public UserModel(String userName, String tpi, String sigla) {
        this.userName = userName;
       this.sigla = sigla;
        this.tpi = tpi;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

   public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getTpi() {
        return tpi;
    }

    public void setTpi(String tpi) {
        this.tpi = tpi;
    }
}
