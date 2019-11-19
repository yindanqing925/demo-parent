package org.nh.service.base.user.model;

import java.util.Date;

public class User {
    private Integer id;

    private String usernname;

    private String password;

    private Double balance;

    private Date created;

    private Date updated;

    private Integer adress;

    private String phone;

    private String tips;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsernname() {
        return usernname;
    }

    public void setUsernname(String usernname) {
        this.usernname = usernname == null ? null : usernname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Integer getAdress() {
        return adress;
    }

    public void setAdress(Integer adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips == null ? null : tips.trim();
    }
}