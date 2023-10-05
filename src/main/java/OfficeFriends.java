
public class OfficeFriends extends Official{
    private String birthday;

    public OfficeFriends(String name, String address, String designation, String birthday) {
        super(name, address, designation);
        this.birthday = birthday;
    }

    public String getBirthday() {
        return birthday;
    }
    
   
  
    
}
