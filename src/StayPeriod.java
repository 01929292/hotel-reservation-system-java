import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;

public class StayPeriod {
    private LocalDate checkIn;
    private LocalDate checkOut;

    public StayPeriod(LocalDate checkIn, LocalDate checkOut) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }
    public LocalDate getCheckIn() {
        return checkIn;
    }
    public LocalDate getCheckOut() {
        return checkOut;
    }

    public BigDecimal income(){
        final BigDecimal entry = new BigDecimal("50.00");
        Duration durantion = Duration.between(checkIn.atStartOfDay(),checkOut.atStartOfDay());
        int days = (int) durantion.toDays();
        return entry.add(BigDecimal.valueOf(days).multiply(BigDecimal.valueOf(100)));
    }
}
