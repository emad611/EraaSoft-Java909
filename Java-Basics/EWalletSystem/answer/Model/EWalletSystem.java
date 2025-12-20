package com.java;

import java.util.HashSet;
import java.util.Set;

public class EWalletSystem {
    public Set<String> getUsernames() {
        return Usernames;
    }

    public Set<String> getPhoneNumbers() {
        return PhoneNumbers;
    }

    private Set<String>Usernames=new HashSet<>();
    private Set<String>PhoneNumbers=new HashSet<>();
    private Set<Account>Accounts=new HashSet<>();

boolean validateUsername (String username){
    if(username==null||username.isEmpty()){
            return false;
        }
    if(username.length()<3||username.length()>20){
        return false;
    }

    if(Usernames.contains(username)){
        return false;
    }
    Usernames.add(username);
    username=username.substring(0,1).toUpperCase() + username.substring(1);
    return true;
}
boolean validatePassword (String password){
    if(password==null||password.isEmpty()){
        return false;
    }
    if(password.length()<8){
        return false;
    }
    boolean hasupper=false;
    boolean haslower=false;
    boolean hasnumber=false;
    for(int i=0;i<password.length();i++){
if(password.charAt(i)>='A'&&password.charAt(i)<='Z'){
    hasupper=true;
}
if(password.charAt(i)>='a'&&password.charAt(i)<='z'){
    haslower=true;
}
if(password.charAt(i)>='0'&&password.charAt(i)<='9'){
    hasnumber=true;
}
        }
if(hasupper&&haslower&&hasnumber){
    return true;
}
return false;
}
boolean valditeAge(int age){
    return age>=18;
}

    public Set<Account> getAccounts() {
        return Accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        Accounts = accounts;
    }

    boolean valditePhonenumber(String phonenumber){
    if(phonenumber==null||phonenumber.isEmpty()){
        return false;
    }
    if(phonenumber.length()!=11){
        return false;
    }
    boolean starts = phonenumber.substring(0, 2).equals("01");
    boolean hasdigit=true;
    for(int i=0;i<phonenumber.length();i++){
        if(phonenumber.charAt(i)<'0'||phonenumber.charAt(i)>'9'){
            hasdigit=false;
        }
    }
    if(this.PhoneNumbers.contains(phonenumber)){
        return false;
    }
    if(hasdigit&&starts){
        return true;
    }
    return false;
}
}
