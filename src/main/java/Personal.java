
public class Personal extends Recipient  {
    private String nick_name;
    private String birthday;

    public Personal(String name, String nick_name, String address, String birthday) {
        this.setAddress(address);
        this.setName(name);
        this.nick_name = nick_name;
        this.birthday = birthday;
    }

    public String getNickName() {
        return nick_name;
    }

    public String getBirthday() {
        return birthday;
    }
    
}
