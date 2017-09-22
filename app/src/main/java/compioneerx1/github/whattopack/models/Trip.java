package compioneerx1.github.whattopack.models;

public class Trip {
    String location;
    String purpose;

    public Trip(String location, String purpose) {
        this.location = location;
        this.purpose = purpose;
    }

    public String getLocation() {
        return location;
    }

    public String getPurpose() {
        return purpose;
    }

}
