import java.util.List;

public class PatientSearch {

    static void linearSearch(List<Patient> patientList,int pId){
        boolean flag = false;
        for(Patient p : patientList){
            if(p.getPatientId() == pId){
               // System.out.println("Patient found!");
                flag = true;
                break;
            }
        }
       // if(!flag) System.out.println("Patient not found!");
    }

  
    static void binarySearch(List<Patient> patientList,int pId){
        int low = 0, high = patientList.size() - 1;
        boolean flag = false;
        while(low <= high){
            int mid = (low + high) / 2;

            if(patientList.get(mid).getPatientId() == pId){
               // System.out.println("Patient found!");
                flag = true;
                break;
            }
            else if(patientList.get(mid).getPatientId() < pId){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        //if(!flag) System.out.println("Patient not found!");
    }
}
