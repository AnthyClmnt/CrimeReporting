import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class District {
    private String districtName;
    private List<Incident> burglaryList = new ArrayList<>();

    /**
     *
     * @param districtName is
     * @param incident is
     */

    public District(String districtName, Incident incident) {
        this.districtName = districtName;
        this.burglaryList.add(incident);
    }

    public String getDistrictName() {
        return districtName;
    }

    public List<Incident> getIncident() {
        return burglaryList;
    }

    public void addIncident(Incident newIncident){
        burglaryList.add(newIncident);
    }

    public Incident maxIncidentVal() {
        List<Double> incValues = new ArrayList<>();
        //Incident maxInc = burglaryList.get(0);
        burglaryList.forEach(name -> {
            incValues.add(name.getValue());
        });

        double maxVal = Collections.max(incValues);
        int maxInc = incValues.indexOf(maxVal);
        return burglaryList.get(maxInc);
    }
}

