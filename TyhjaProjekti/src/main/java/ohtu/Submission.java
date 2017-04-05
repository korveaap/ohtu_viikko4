package ohtu;

import java.util.ArrayList;
import java.util.List;

public class Submission {

    private String student_number;
    private String week;
    private String hours;
    private String a1;
    private String a2;
    private String a3;
    private String a4;
    private String a5;
    private String a6;
    private String a7;
    private String a8;
    private String a9;
    private String a10;
    private String a11;
    private String a12;
    private String a13;
    private Course course;

    public void setCourse(Course course) {
        this.course = course;
    }
    
    private List<String> doneTasks ;

    public void setWeek(String week) {
        this.week = week;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public void setA1(String a1) {
        this.a1 = a1;       
    }

    public String getHours() {
        return hours;
    }

    public List<String> getDoneTasks() {
        return doneTasks;
    }

    public void setDoneTasks() {
        doneTasks = new ArrayList();
        if (this.a1 != null && this.a1.equals("true")) {
            doneTasks.add("1");
        }
        if (this.a2 != null && this.a2.equals("true")) {
            doneTasks.add("2");
        }
        if (this.a3 != null && this.a3.equals("true")) {
            doneTasks.add("3");
        }
        if (this.a4 != null && this.a4.equals("true")) {
            doneTasks.add("4");
        }
        if (this.a5 != null && this.a5.equals("true")) {
            doneTasks.add("5");
        }
        if (this.a6 != null && this.a6.equals("true")) {
            doneTasks.add("6");
        }
        if (this.a7 != null && this.a7.equals("true")) {
            doneTasks.add("7");
        }
        if (this.a8 != null && this.a8.equals("true")) {
            doneTasks.add("8");
        }
        if (this.a9 != null && this.a9.equals("true")) {
            doneTasks.add("9");
        }
        if (this.a10 != null && this.a10.equals("true")) {
            doneTasks.add("10");
        }
        if (this.a11 != null && this.a11.equals("true")) {
            doneTasks.add("11");
        }
        if (this.a12 != null && this.a12.equals("true")) {
            doneTasks.add("12");
        }
        if (this.a13 != null && this.a13.equals("true")) {
            doneTasks.add("13");
        }
    }

    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    @Override
    public String toString() {
        String max = course.getWeeklyMax(week);
        String s = "Viikko " + week + ": tehtyjä tehtäviä yhteensä: " + doneTasks.size() + " (maksimi " + max + "), aikaa kului " + hours + " tuntia";

        for (String task : doneTasks) {
            s = s + " " + task;
        }

        return s;
    }

}
