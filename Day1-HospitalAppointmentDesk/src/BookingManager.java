
import java.util.HashSet;
import java.util.List;

public class BookingManager {

    static HashSet<String> bookedSlots = new HashSet<>();

    //Time Complexity: O(1)
    static boolean bookAppointment(List<Appointment> appointmentList) {
        boolean flag = false;
        for (Appointment a : appointmentList) {

            String key = a.patientId + "_" +
                    a.startTime + "_" +
                    a.endTime;

            if (bookedSlots.contains(key)) {
                System.out.println("Double booking detected!");
                flag = false;
                break;
            }

            bookedSlots.add(key);

            System.out.println("Appointment booked successfully.");
            flag = true;
        }

        if(!flag) return false;
        return true;
    }
}