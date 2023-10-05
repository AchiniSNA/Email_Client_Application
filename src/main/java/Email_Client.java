//Index Number_200004U
import java.util.Scanner;

public class Email_Client {
    static {
        //send wishes to those who have Birthday on that day
        DetailsController detailsController = new DetailsController();
        BdayWishController bdayWishController = new BdayWishController();
        detailsController.readDetails();//read details in the textfile.
        bdayWishController.sendWish(); 

    }
    public static void main(String[] args) {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter option type: \n"
                + "1 - Adding a new recipient\n"
                + "2 - Sending an email\n"
                + "3 - Printing out all the recipients who have birthdays\n"
                + "4 - Printing out details of all the emails sent\n"
                + "5 - Printing out the number of recipient objects in the application\n"
                + "6 - End\n"
                + "_________________________________________________________________");

        A:
        while (true) {
            int option = scanner1.nextInt();
            Scanner scanner2 = new Scanner(System.in).useDelimiter("\n");
            switch (option) {

                case 1:
                    //store details in clientList.txt file
                    System.out.println("Enter new recipient details(input format - Ex: Official: nimal,nimal@gmail.com,ceo) ");
                    String newRecipient = scanner2.next();// Use a single input to get all the details of a recipient
                    DetailsController recipientListFile = new DetailsController();
                    recipientListFile.writeDetails(newRecipient);
                    System.out.println("_____________________________________________________________");                    
                    break;

                case 2:
                    //send an email 
                    System.out.println("Enter new mail details (input format - email, subject, content) :");
                    String mailDetails = scanner2.next();                    
                    SendEmail email = new SendEmail(mailDetails.split(",")[0], mailDetails.split(",")[1], mailDetails.split(",")[2]);
                    ObjController obj = new ObjController();
                    obj.serialization(email);//serialize object and input to abj.ser file
                    System.out.println("______________________________________________________________");
                    break;

                case 3:
                    //To get name of recipients who have birthdays on that day
                    System.out.println("Enter birthday (input format - yyyy/MM/dd (ex: 2018/09/17)) :");
                    String birthday = scanner2.next();
                    DetailsController recipientName = new DetailsController();
                    System.out.println("Recipients who have birthdays on that day  :-");
                    recipientName.findBdayTodayRecipients(birthday); 
                    System.out.println("______________________________________________________________");
                    break;

                case 4:
                    //print the details of all the emails sent on the input date
                    System.out.println("Enter date (input format - yyyy/MM/dd (ex: 2018/09/17)) :");
                    String date = scanner2.next();
                    DetailsController details = new DetailsController();
                    details.getSentEmailDetails(date);
                    System.out.println("_______________________________________________________________");
                    break;

                case 5:
                    //print the number of recipient objects in the application
                    DetailsController count = new DetailsController();
                    System.out.println("The number of recipient objects in the application : " + count.getCount());
                    System.out.println("________________________________________________________________");

                    break;
                case 6:
                    //brake the while loop
                	System.out.println("END");
                    break A;

            }
        }
    }    
}
