package hu.bme.aut.mobsoft.tripplanviewer.orm.entities;

import com.orm.SugarRecord;
import com.orm.dsl.Unique;

/**
 * Created by Resi Tamas on 07/04/2017.
 */

public class User extends SugarRecord {

    @Unique
    int userId;

    String name;

    public User() {

    }

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }




}
