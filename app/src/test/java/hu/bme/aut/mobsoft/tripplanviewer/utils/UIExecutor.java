package hu.bme.aut.mobsoft.tripplanviewer.utils;

import android.os.Handler;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;

/**
 * Created by Resi Tamas on 13/05/2017.
 */

public class UIExecutor implements Executor {

    private Handler handler;

    public UIExecutor(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void execute(@NonNull Runnable command) {
        handler.post(command);
    }

}
