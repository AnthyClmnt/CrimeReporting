import java.util.ArrayList;
import java.util.List;

public class District {
    private String districtName;
    private List<String> burglaryList = new ArrayList<>();

    /**
     *
     * @param districtName
     * @param incident
     */

    public District(String districtName, String incident) {
        this.districtName = districtName;
        this.burglaryList.add(incident);
    }

    public String getDistrictName() {
        return districtName;
    }

    public List<String> getIncident() {
        return burglaryList;
    }

    public void addIncident(String newIncident){
        burglaryList.add(newIncident);
    }


}

