import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class BdayWishController {
    public static DateFormat Format = new SimpleDateFormat("yyyy/MM/dd");
    public static String Today = Format.format(new Date());                 // take Today

    public boolean comp2days(String date1, String date2) {  //compare two days except year

        String[] day1 = date1.split("/");
        String[] day2 = date2.split("/");
        if (day1[1].contentEquals(day2[1]) && day1[2].contentEquals(day2[2])){
            return true;
        }
        return false;
    }

    public void sendWish() {  // send birthday wishes to the recipients who have birthday today

        for (Recipient r : DetailsController.allRecipientData) {
            if (r instanceof Personal) {
                String birthday = ((Personal) r).getBirthday();            //downcasting
                if (comp2days(Today, birthday)) {
                    SendEmail email = new SendEmail(((Personal) r).getAddress(), "Birth day wish", "Hugs and love on your birthday. Achini Sanjula");
                    ObjController obj = new ObjController();
                    obj.serialization(email);//serialize object and input to object.ser file
                }
            } else if (r instanceof OfficeFriends) {
                String birthday = ((OfficeFriends) r).getBirthday();      //downcasting
                if (comp2days(Today, birthday)) {
                    SendEmail email = new SendEmail(((OfficeFriends) r).getAddress(), "Birth day wish", "Wish you a Happy Birthday. Achini Sanjula");
                    ObjController obj = new ObjController();
                    obj.serialization(email);//serialize object and input to object.ser file
                }
            } else {
                System.out.println("");

            }
        }

    }

    
}
