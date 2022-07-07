package iface;

public class Profile {
    private String firstName;
    private String lastName;
    private String age;
    private String genre;
    private String relationship;
    private String cellPhone;


    public Profile(){
        this.firstName = "______";
        this.lastName = "______";
        this.age = "0";
        this.genre = "______";
        this.relationship = "______";
        this.cellPhone = "(00)0 0000-0000";

    }
   
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getRelationship() {
        return relationship;
    }
    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }
    public String getCellPhone() {
        return cellPhone;
    }
    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

}
