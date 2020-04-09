package com.ppe.user;

import com.ppe.Context;

public class User {

    private boolean isConnected;

    private String username;
    private String password;
    private String name;
    private String lastname;
    private String birthdate;
    private String adresse;
    private int idCompte;
    private int grade;

    public User(){
        this.isConnected = false;
    }

    public void test(){

        System.out.println(username);
        System.out.println(password);
        System.out.println(name);
        System.out.println(lastname);
        System.out.println(birthdate);
        System.out.println(adresse);
        System.out.println(idCompte);
        System.out.println(grade);

    }

    //------------------------------------------getters and setter------------------------------------------------------

    public int getIdCompte() {
        return idCompte;
    }

    public int getGrade() {
        return grade;
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

    public boolean isConnected() {
        return isConnected;
    }

    public void setConnected(boolean connected) {
        isConnected = connected;
    }

    public void setIdCompte(int idCompte) {
        this.idCompte = idCompte;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
