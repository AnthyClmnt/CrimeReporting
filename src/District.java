

public class District {
    private String districtName;
    private int incidentCount;

    /**
     *
     * @param districtName
     * @param incident
     */

    public District(String districtName, int incident) {
        this.districtName = districtName;
        this.incidentCount = incident;
    }

    public String getDistrictName() {
        return districtName;
    }

    public int getIncident() {
        return incidentCount;
    }

    public void addIncident() {
        this.incidentCount += 1;
    }
}
