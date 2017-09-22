package compioneerx1.github.whattopack.models;

import org.parceler.Parcel;

@Parcel
public class Trip {
    String location;
    String purpose;
    private String pushId;

    public Trip() { }

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

    public String getPushId() {
        return pushId;
    }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }

}
