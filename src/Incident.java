public class Incident {
    private String postcode;
    private double value;
    private String month;
    private int year;

    public Incident(String postcode, double value, String month, int year) {
        this.postcode = postcode;
        this.value = value;
        this.month = month;
        this.year = year;
    }

    public String getPostcode() {
        return postcode;
    }

    public double getValue() {
        return value;
    }

    public String getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}
