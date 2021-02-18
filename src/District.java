import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class District {
    private final String districtName;
    private final List<Incident> burglaryList = new ArrayList<>();

    /**
     *
     * @param districtName is string which stores the name of a district
     * @param incident is a list of Incident objects that have happened in this district
     */

    public District(String districtName, Incident incident) {
        this.districtName = districtName;
        this.burglaryList.add(incident);
    }

    /**
     *
     * @return Get method, which returns the district name
     */

    public String getDistrictName() {
        return districtName;
    }

    /**
     *
     * @return Get method, which returns the incidents that have occurred in the district
     */

    public List<Incident> getIncident() {
        return burglaryList;
    }

    /**
     *
     * @param newIncident function which is called when district already exists, and adds an incident to the burglary list
     */

    public void addIncident(Incident newIncident){
        burglaryList.add(newIncident);
    }

    /**
     *
     * @return function which returns the maximum value of the incidents in the district
     */

    public Incident maxIncidentVal() {
        List<Double> incValues = new ArrayList<>();
        burglaryList.forEach(name -> incValues.add(name.getValue()));
        double maxVal = Collections.max(incValues);
        int maxInc = incValues.indexOf(maxVal);
        return burglaryList.get(maxInc);
    }

    /**
     *
     * @param year is a parameter which the user inputs to know which year to search for
     * @return function which returns the average value of the incidents in the district
     */

    public int avgIncValueInYear(int year) {
        int incAmount = burglaryList.size();
        int totalVal = burglaryList.stream().filter(name -> name.getYear() == year).mapToInt(name -> (int) name.getValue()).sum();
        return (totalVal/incAmount);
    }

    /**
     *
     * @param amount is a parameter which the user inputs to the minimum value to search for
     * @return function which returns the incident with the highest value in the district
     */

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