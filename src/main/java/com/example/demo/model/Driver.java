//package com.example.demo.model;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import java.io.File;
//
//public class Driver {
//    public static void main(String[] args) {
//        try {
//            ObjectMapper mapper=new ObjectMapper();
//            Student theStudent=mapper.readValue(new File("data/sample-full.json"),Student.class);
//            System.out.println("First Name " + theStudent.getFirstName());
//            System.out.println("Last Name " +theStudent.getLastName());
//            Address tempAddress = theStudent.getAddress();
//
//            System.out.println("Street = " + tempAddress.getStreet());
//            System.out.println("City = " + tempAddress.getCity());
//
//            // print out languages
//
//            for (String tempLang : theStudent.getLanguages()) {
//                System.out.println(tempLang);
//            }
//
//        }catch (Exception exc){
//            exc.printStackTrace();
//
//        }
//    }
//}
