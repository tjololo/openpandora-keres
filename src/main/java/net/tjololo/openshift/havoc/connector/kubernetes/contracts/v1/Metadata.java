package net.tjololo.openshift.havoc.connector.kubernetes.contracts.v1;

/**
 * Created by veg on 20.12.2016.
 */
public class Metadata {
    private String name;
    private String selfLink;
    private String namespace;

    public Metadata() {
    }

    public Metadata(String name, String selfLink, String namespace) {
        this.name = name;
        this.selfLink = selfLink;
        this.namespace = namespace;
    }

    public String getName() {
        return name;
    }

    public String getSelfLink() {
        return selfLink;
    }

    public String getNamespace() {
        return namespace;
    }
}
