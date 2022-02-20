package edu.jsu.mcis.cs310;

import java.util.Scanner;
import org.json.simple.*;

public class Main {

    public static void main(String[] args) {
        
        Database db = new Database("cs310_p2_user", "P2!user", "localhost");
        
        int termid = 0;
        String subjectid = "";
        int studentid = 0;
        String num = "";
        int crn = 0;
        
        if (db.isConnected())
            
            System.err.println("Connected Successfully!");
        
    }
    
    
    
    Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter 1 to search for a course\n"
                + "Enter 2 to register for a course\n"
                + "Enter 3 to drop a course\n"
                + "Enter 4 to withdraw from every course registered\n"
                + "Enter 5 to list all of your registered courses\n");
        int userChoice = userInput.nextInt();
        
        switch(userChoice){
            case 1:
                System.out.println("Enter your Term ID (Integer) ");
                termid = userInput.nextInt();
            
                System.out.println("Enter your Subject ID ");
                subjectid = userInput.next();

                System.out.println("Enter your Course Number ");
                num = userInput.next();
                
                String result = db.getSectionsAsJSON(termid, subjectid, num);
                System.out.println(result);
                break;
            case 2:
                studentid = db.getStudentId("estjohn123");
                
                System.out.println("Enter your Term ID (Integer) ");
                termid = userInput.nextInt();
                
                System.out.println("Enter your CRN ");
                crn = userInput.nextInt();
                
                int resultRegister = db.register(studentid, termid, crn);
                System.out.println("Rows Affected: " + resultRegister);
                break;  
                
            case 3:
                studentid = db.getStudentId("estjohn123");
                
                System.out.println("Enter your Term ID (Integer) ");
                termid = userInput.nextInt();
                
                System.out.println("Enter your CRN ");
                crn = userInput.nextInt();
                
                int resultDrop = db.drop(studentid, termid, crn);
                System.out.println("Rows Affected: " + resultDrop);
                
                break;
            case 4:
                studentid = db.getStudentId("estjohn123");
                
                System.out.println("Enter your Term ID (Integer) ");
                termid = userInput.nextInt();
                
                int resultWithdraw = db.withdraw(studentid, termid);
                System.out.println("Rows Affected: " + resultWithdraw);
                
                break;
                
            case 5:
                studentid = db.getStudentId("estjohn123");
                
                System.out.println("Enter your Term ID (Integer) ");
                termid = userInput.nextInt();
                
                String resultSchedule = db.getScheduleAsJSON(studentid, termid);
                System.out.println(resultSchedule);
                
            default:
                break;
        }
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
}