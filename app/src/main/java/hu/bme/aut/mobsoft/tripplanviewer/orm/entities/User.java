package hu.bme.aut.mobsoft.tripplanviewer.orm.entities;

import com.orm.SugarRecord;

/**
 * Created by Resi Tamas on 07/04/2017.
 */

public class User extends SugarRecord {

    String userId;
    String name;

    public User() {

    }

    public User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }




}
