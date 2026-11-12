import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Initialize sample lists with data
        List<Patient> patientList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            patientList.add(new Patient(10000 + i, "Patient " + i, 20 + (i % 50)));
        }

        List<Appointment> appointmentList = new ArrayList<>();
        appointmentList.add(new Appointment(1, 10001, 2, 900, 930, 1000));
        appointmentList.add(new Appointment(2, 10002, 1, 905, 915, 930));
        appointmentList.add(new Appointment(3, 10003, 3, 910, 1000, 1030));

        System.out.println("=== TASK 1: Patient Searching ===");
        // Linear Search
        long startLinear = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            PatientSearch.linearSearch(patientList, 10000 + i);
        }
        long endLinear = System.nanoTime();
        System.out.println("Linear Search Time: " + (endLinear - startLinear) + " ns\n");

        // Binary Search (Note: patientList is already sorted by ID since we added them sequentially)
        long startBinarySearch = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            PatientSearch.binarySearch(patientList, 10000 + i);
        }
        long endBinarySearch = System.nanoTime();
        System.out.println("Binary Search Time: " + (endBinarySearch - startBinarySearch) + " ns\n");


        System.out.println("=== TASK 2: Appointment Sorting ===");
        // Selection sort - O(N^2)
        int selectionSwaps = AppointmentSorting.selectionSort(new ArrayList<>(appointmentList));
        System.out.println("Selection Sort Swaps: " + selectionSwaps);

        // Quick sort - O(N log N)
        List<Appointment> qSortList = new ArrayList<>(appointmentList);
        int quickSortSwaps = AppointmentSorting.quickSort(qSortList, 0, qSortList.size() - 1);
        System.out.println("Quick Sort Swaps: " + quickSortSwaps + "\n");


        System.out.println("=== TASK 3: Booking Manager (HashSet) ===");
        // Why HashSet is suitable: O(1) average time complexity for lookups/duplicates check compared to O(N) in ArrayList.
        boolean bookingResult = BookingManager.bookAppointment(appointmentList);
        System.out.println("Booking Success: " + bookingResult + "\n");


        System.out.println("=== TASK 4: Custom Queue & Stack ===");
        System.out.println("--- Testing Custom Queue ---");
        CustomQueue q = new CustomQueue(5);
        q.enqueue(101);
        q.enqueue(102);
        q.enqueue(103);
        q.display();
        System.out.println("Removed from Queue: " + q.dequeue());
        System.out.println("Queue Front Peek: " + q.peek());
        q.display();

        System.out.println("\n--- Testing Custom Stack ---");
        CustomStack s = new CustomStack(5);
        s.push(201);
        s.push(202);
        s.push(203);
        s.display();
        System.out.println("Removed from Stack: " + s.pop());
        System.out.println("Stack Top Peek: " + s.peek());
        s.display();
    }
}