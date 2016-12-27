package net.tjololo.openshift.havoc.connector.kubernetes.contracts.v1;

/**
 * Created by veg on 20.12.2016.
 */
public class Item {
    private Metadata metadata;
    private Status status;

    public Item() {
    }

    public Item(Metadata metadata, Status status) {
        this.metadata = metadata;
        this.status = status;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public Status getStatus() {
        return status;
    }
}
