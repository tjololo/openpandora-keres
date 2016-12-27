package net.tjololo.openshift.havoc.api.v1;

/**
 * Created by veg on 21.12.2016.
 */
public class Status {
    private boolean killed;

    public Status(boolean killed) {
        this.killed = killed;
    }

    public boolean isKilled() {
        return killed;
    }
}
