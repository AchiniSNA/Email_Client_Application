import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DetailsController {
    private static int resipientcount;                       //static variable for count the recipients
    public static ArrayList<Recipient> allRecipientData = new ArrayList<Recipient>();// to store every recipients details . 
    public static ArrayList<Recipient> friendsData = new ArrayList<Recipient>();// to store details of  friends(official and non official). . 

    ObjController obj = new ObjController();

    public void writeDetails(String details) { //write details of recipients to the file.

        try {
            addObject(details);
            FileWriter writer = new FileWriter("clientList.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(details);
            bufferedWriter.newLine();
            bufferedWriter.close();            
        } 
        catch (IOException e) {
             e.printStackTrace();
        }
    }
    
   
    public void readDetails() { //read the details of recipients from the file
        try {
            FileReader reader = new FileReader("clientList.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                addObject(line);
            }
            reader.close();
        } 
        catch (IOException e) {
             e.printStackTrace();
        }
    }

    public void addObject(String details) {//store objects in the list . 
        String recpType = details.split(":")[0];
        String[] data = details.split(":")[1].split(",");
        Recipient r;
        if (recpType.equals("Official")) {
            r = new Official(data[0], data[1], data[2]);
        }         
        else if (recpType.equals("Office_friend")) {
            r = new OfficeFriends(data[0], data[1], data[2], data[3]);
            friendsData.add(r);
        }         
        else {
            r = new Personal(data[0], data[1], data[2], data[3]);
            friendsData.add(r);
        }
        allRecipientData.add(r);
    }
	
    

    public void findBdayTodayRecipients(String date) { //find recepients who have bithday today
        int count = 0;
        for (Recipient r : friendsData) {

            if (r instanceof Personal) {

                String birthday = ((Personal) r).getBirthday();            //downcasting
                if (birthday.equals(date)) {
                    count += 1;
                    System.out.println(count + "." + ((Personal) r).getName());
                }

            } else {
                String birthday = ((OfficeFriends) r).getBirthday();      //downcasting
                if (birthday.equals(date)) {
                    count += 1;
                    System.out.println(count + "." + ((OfficeFriends) r).getName());
                }
            }
        }
        if (count == 0) {
            System.out.println("No Recipients who have birthday on that day");
        }
    }

    public int getCount() {  //get the count of all recipients
        resipientcount = allRecipientData.size();
        return resipientcount;
    }

    
    public void getSentEmailDetails(String date) {  //get details of sentEmails
        int count = 0;
        ArrayList<SendEmail> sentMailList = obj.deSerialization();

        for (SendEmail se : sentMailList) {
            if ((date.trim()).contentEquals(se.date)) {
                count += 1;
                System.out.print("Subject :" + se.getSubject()+" , Recipient :" +se.getAddress());   
            }
        }

        if (count == 0) {
            System.out.println("No email sent on that day");
        }
    }

}

