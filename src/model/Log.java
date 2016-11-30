package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Napha on 30.11.2016.
 */
public class Log {
    private List<SdlSig> sdlSigs;
    private List<Stopping> stoppings;

    public Log() {
        sdlSigs = new ArrayList<>();
        stoppings = new ArrayList<>();
    }

    public List<SdlSig> getSdlSigs() {
        return sdlSigs;
    }

    public void setSdlSigs(List<SdlSig> sdlSigs) {
        this.sdlSigs = sdlSigs;
    }

    public List<Stopping> getStoppings() {
        return stoppings;
    }

    public void setStoppings(List<Stopping> stoppings) {
        this.stoppings = stoppings;
    }
}
