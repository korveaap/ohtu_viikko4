package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.Set;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // vaihda oma opiskelijanumerosi seuraavaan
        String studentNr = "014608294";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "http://ohtustats2017.herokuapp.com/students/"+studentNr+"/submissions";
        String courseUrl = "https://ohtustats2017.herokuapp.com/courses/1.json";

        String bodyText = Request.Get(url).execute().returnContent().asString();
        String courseText = Request.Get(courseUrl).execute().returnContent().asString();

        //System.out.println("json-muotoinen data:");
        

        Gson mapper = new Gson();        
        
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        Course course = mapper.fromJson(courseText, Course.class);
        System.out.println(course);
        System.out.println("");
        
        System.out.println("Opiskelijanumero: " + studentNr);
        System.out.println("");
        
        int hourTotal = 0;
        int taskTotal = 0; 
        
        for (Submission submission : subs) {
            submission.setDoneTasks();
            submission.setCourse(course);
            
            hourTotal += Integer.parseInt(submission.getHours());
            taskTotal += submission.getDoneTasks().size();
            System.out.println(submission);
        }
        System.out.println("");
        System.out.println("yhteensä: " + taskTotal + " tehtävää " + hourTotal + " tuntia");

    }
}
