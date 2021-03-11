package com.example.project

public class MessageUtil {

   private String message;

   //Constructor
   //@param message to be printed
   public MessageUtil(String message){
      this.message = message;
   }

   public String printMessage(){
      System.out.println(message);
      return message;
   }   
}