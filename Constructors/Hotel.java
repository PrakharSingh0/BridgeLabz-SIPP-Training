public class Hotel {
    public String guestName;
    public String roomType;
    public int nights;

    Hotel(){
        guestName="Anyonmus";
        roomType="A1";
        nights=0;
    }

    Hotel(String gName,String roomType,int nights){
        this.guestName=gName;
        this.roomType=roomType;
        this.nights=nights;
    }
    
    Hotel(Hotel hotel){
        this.guestName=hotel.guestName;
        this.roomType=hotel.roomType;
        this.nights=hotel.nights;
    }

    void DisplayOutput(){
        System.err.println("Guest Name :"+this.guestName);
        System.err.println("Room Type :"+this.roomType);
        System.err.println("Nights :"+this.nights);
    }

    public static void main(String[] args) {
        Hotel h=new Hotel();
        h.DisplayOutput();
        Hotel h1=new Hotel("Prakhar","S1",5);
        Hotel h2=new Hotel(h1);
        h2.DisplayOutput();
    }
}
