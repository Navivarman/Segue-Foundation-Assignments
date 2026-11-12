import java.util.List;

public class AppointmentSorting {
    static boolean isBefore(Appointment a, Appointment b) {
        if (a.urgency != b.urgency) {
            return a.urgency < b.urgency;
        }
        return a.arrivalTime < b.arrivalTime;
    }

    static int selectionSort(List<Appointment> appointmentList) {
        int swap = 0, n = appointmentList.size();

        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (isBefore(appointmentList.get(j), appointmentList.get(min))) {
                    min = j;
                }
            }
            if (min != i) {
                Appointment temp = appointmentList.get(min);
                appointmentList.set(min, appointmentList.get(i));
                appointmentList.set(i, temp);
                swap++;
            }
        }

        return swap;
    }

    
    static int partition(List<Appointment> appointmentList, int low, int high) {
        Appointment pivot = appointmentList.get(high);
        int i = low - 1;
        int swap = 0;

        for (int j = low; j < high; j++) {
            if (isBefore(appointmentList.get(j), pivot)) {
                i++;
                Appointment temp = appointmentList.get(i);
                appointmentList.set(i, appointmentList.get(j));
                appointmentList.set(j, temp);
            }
        }

        Appointment temp = appointmentList.get(i + 1);
        appointmentList.set(i + 1, appointmentList.get(high));
        appointmentList.set(high, temp);

        return i + 1;
    }

    static int quickSort(List<Appointment> appointmentList, int low, int high) {
        int swap = 0;
        if (low < high) {
            int pIndex = partition(appointmentList, low, high);

            swap += quickSort(appointmentList, low, pIndex - 1);
            swap += quickSort(appointmentList, pIndex + 1, high);
        }
        return swap;
    }
}