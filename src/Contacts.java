public class Contacts {
    private String name;
    private String number;
    private String color;
    public Contacts(){

    }
    public Contacts(String name, String number, String color){
        this.name = name;
        this.number = number;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String returnContacts(){
        return this.name + " " + this.number;
    }
}