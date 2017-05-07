package hu.bme.aut.mobsoft.tripplanviewer.orm.entities;

/**
 * Created by Resi Tamas on 06/05/2017.
 */

public class TravelSight {

    Travel travel;
    Sight sight;

    public TravelSight(Travel travel, Sight sight) {
        this.travel = travel;
        this.sight = sight;
    }

    public Travel getTravel() {
        return travel;
    }

    public void setTravel(Travel travel) {
        this.travel = travel;
    }

    public Sight getSight() {
        return sight;
    }

    public void setSight(Sight sight) {
        this.sight = sight;
    }
}
