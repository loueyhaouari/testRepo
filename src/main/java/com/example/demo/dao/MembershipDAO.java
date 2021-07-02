package com.example.demo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
public boolean addSillyMember(){
    System.out.println(getClass() + ": Doing stuff: Adding a memberShip account");
return true;
}
public void goToSleep(){
    System.out.println(getClass() + "I'm going to sleep now...");
}
}
