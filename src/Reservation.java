import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Reservation {
    private int room;
    private Client client;
    private StayPeriod stayPeriod;

    private List<Client> clients =  new ArrayList<>();


    public Reservation(int room, Client client, StayPeriod stayPeriod) {
        this.room = room;
        this.client = client;
        this.stayPeriod = stayPeriod;
    }

    public int getRoom() {
        return this.room;
    }

    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Room: " + room +
                " | " + client.getName() +
                " | " + client.getEmail() +
                " | " + stayPeriod.getCheckIn().format(formatter)+
                " -> " + stayPeriod.getCheckOut().format(formatter) +
                " | $"+ stayPeriod.income();
    }
}