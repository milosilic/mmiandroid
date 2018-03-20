package bitgear.mmwa.installation.manholemonitorinstallation.network;

import java.io.IOException;

/**
 * Created by ila on 20.3.18..
 */
//http://www.migapro.com/detect-offline-error-in-retrofit-2/
public class NoConnectivityException extends IOException {

    @Override
    public String getMessage() {
        return "No connectivity exception";
    }

}