package com.example.demo.dao;

import com.example.demo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {
    private String name;
    private String serviceCode;
    public void addAccount(Account theAccount, boolean vipFlag){
        System.out.println("Doing my DB work: Adding an account");
    }
    public boolean doWork(){
        System.out.println(getClass() + ": doWork()");
        return false;
    }
    public List<Account> findAccounts(){
        List<Account> myAccounts=new ArrayList<>();
        Account temp1=new Account("John","Driver");
        Account temp2=new Account("Madhu","Platinuim");
        Account temp3=new Account("luca","Gold");
        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);
        return myAccounts;
    }

    public String getName() {
System.out.println(getClass() + ": in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + ": in setname()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + ": in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": in setServiceCode()");
        this.serviceCode = serviceCode;

    }
}
