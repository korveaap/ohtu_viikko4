/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

/**
 *
 * @author aapo
 */
public class Course {
    private String name;
    private String term;
    private String week1;
    private String week2;
    private String week3;
    private String week4;
     private String week5;
    private String week6;
    

    public String getWeeklyMax(String week) {
        if (week.equals("1")) {
            return week1;
        }
        if (week.equals("2")) {
            return week2;
        }
        if (week.equals("3")) {
            return week3;
        }
        if (week.equals("4")) {
            return week4;
        }
        if (week.equals("5")) {
            return week5;
        }
        if (week.equals("6")) {
            return week6;
        }
        return "0";
    }

    @Override
    public String toString() {
        return "Kurssi: "+ name + ", " + term;
    }
   
    
}
