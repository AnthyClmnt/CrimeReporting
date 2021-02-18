public class Incident {
    private String postcode;
    private String value;
    private String month;
    private String year;

    public Incident(String postcode, String value, String month, String year) {
        this.postcode = postcode;
        this.value = value;
        this.month = month;
        this.year = year;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getValue() {
        return value;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }
}
