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
        burglaryList.forEach(name -> incValues.add(name.getValue()));

        double maxVal = Collections.max(incValues);
        int maxInc = incValues.indexOf(maxVal);
        return burglaryList.get(maxInc);
    }

    public int avgIncValueInYear(int year) {
        int incAmount = burglaryList.size();
        int totalVal = burglaryList.stream().filter(name -> name.getYear() == year).mapToInt(name -> (int) name.getValue()).sum();
        return (totalVal/incAmount);
    }

    public List<Incident> incWithValGtrThan(int amount) {
        List<Incident> incidentsOverAmount = new ArrayList<>();
        burglaryList.forEach(name -> {
            if (name.getValue() > Integer.parseInt(String.valueOf(amount))) {
                incidentsOverAmount.add(name);
            }
        });
        return incidentsOverAmount;
    }
}


