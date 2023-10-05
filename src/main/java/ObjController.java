
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class ObjController {
    public static ArrayList<SendEmail> sentMailsList = new ArrayList<SendEmail>(); //To store sent emails 
    ArrayList<SendEmail> loadMailList;  //To store deserialized objects.

    public void serialization(SendEmail email) {

        sentMailsList.add(email);//Add email objects to serialize.
        
        // Serialization  
        try {
            // Writing serialized object to file
            FileOutputStream fileStream = new FileOutputStream("Object.ser"); //make a FileOutputStream 
            ObjectOutputStream os = new ObjectOutputStream(fileStream);       //make a objectOutputStream
            os.writeObject(sentMailsList);   //write the object
            os.flush();
            fileStream.close();       //close the FileOutputStream
            os.close();               //close the ObjectOutputStream
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ArrayList<SendEmail> deSerialization() {

        // Deserialization 
        try { 
            FileInputStream fileStream = new FileInputStream("Object.ser");
            ObjectInputStream os = new ObjectInputStream(fileStream);
            //Method to deserialize object 
            loadMailList = (ArrayList<SendEmail>) os.readObject();
            os.close();
            fileStream.close();
            return loadMailList;       //return the deserialized list.
        } catch (IOException ex) {
            System.out.println("IOException occured");
            return null;
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException occured");
            return null;
        }

    }
}



    

