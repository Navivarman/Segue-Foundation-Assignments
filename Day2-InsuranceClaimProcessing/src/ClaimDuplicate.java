import java.util.*;

class ClaimKey {
    String policyNumber;
    String incidentDate;

    ClaimKey(String policyNumber, String incidentDate) {
        this.policyNumber = normalize(policyNumber);
        this.incidentDate = normalize(incidentDate);
    }

    private String normalize(String value) {
        return value.replaceAll("\\s+", "")
                .toLowerCase(Locale.ROOT);
    }

}

class ClaimManager {
    private HashSet<ClaimKey> claims = new HashSet<>();

    boolean isDuplicate(String policyNumber, String incidentDate) {
        ClaimKey key = new ClaimKey(policyNumber, incidentDate);

        if (claims.contains(key)) {
            return true;
        }

        claims.add(key);
        return false;
    }

    public static void main(String[] args) {
        System.out.println("\n\n===== TASK 2: HASHING =====");

        ClaimManager manager = new ClaimManager();

        System.out.println(manager.isDuplicate("POL123", "2026-11-10"));
        System.out.println(manager.isDuplicate("pol123", "2026-11-10"));
        System.out.println(manager.isDuplicate("POL 123", "2026-11-11"));
    }
}
