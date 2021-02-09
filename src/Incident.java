public class Incident {
    private String postcode;
    private String value;
    private String date;

    public Incident(String postcode, String value, String date) {
        this.postcode = postcode;
        this.value = value;
        this.date = date;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getValue() {
        return value;
    }

    public String getDate() {
        return date;
    }
}
