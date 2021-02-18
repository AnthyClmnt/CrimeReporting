public class Incident {
    private final String postcode;
    private final double value;
    private final String month;
    private final int year;

    /**
     *
     * @param postcode is string which stores the postcode the incident occurred in
     * @param value is a double which stores the value of goods stolen in the incident
     * @param month is a string which stores the month in which the incident occurred
     * @param year is a int which stores the year in which the incident occurred
     */

    public Incident(String postcode, double value, String month, int year) {
        this.postcode = postcode;
        this.value = value;
        this.month = month;
        this.year = year;
    }

    /**
     *
     * @return Get method, which returns the postcode of the incident
     */
    public String getPostcode() { return postcode; }

    /**
     *
     * @return Get method, which returns the value of the incident
     */

    public double getValue() { return value; }

    /**
     *
     * @return Get method, which returns the month of the incident
     */

    public String getMonth() { return month; }

    /**
     *
     * @return Get method, which returns the year of the incident
     */

    public int getYear() { return year; }
}
