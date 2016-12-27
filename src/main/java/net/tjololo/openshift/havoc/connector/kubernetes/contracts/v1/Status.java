package net.tjololo.openshift.havoc.connector.kubernetes.contracts.v1;

/**
 * Created by veg on 20.12.2016.
 */
public class Status {
    private String phase;

    public Status() {
    }

    public Status(String phase) {
        this.phase = phase;
    }

    public String getPhase() {
        return phase;
    }
}
