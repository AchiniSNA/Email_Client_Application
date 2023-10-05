
public class Official extends Recipient{
    private String designation;

    public Official(String name, String address, String designation) {
        this.setAddress(address);
        this.setName(name);
        this.designation = designation;
    }

    public String getDesignation() {
        return designation;
    }
    
}
