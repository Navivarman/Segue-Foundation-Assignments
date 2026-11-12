
public class Appointment {

    int appointmentId;
    int patientId;
    int urgency;
    int arrivalTime;

    int startTime;
    int endTime;

    Appointment(int appointmentId, int patientId,
                int urgency, int arrivalTime,
                int startTime, int endTime) {

        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.urgency = urgency;
        this.arrivalTime = arrivalTime;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getUrgency() {
        return urgency;
    }

    public void setUrgency(int urgency) {
        this.urgency = urgency;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return appointmentId + " " + patientId + " "
                + urgency + " " + arrivalTime;
    }
}