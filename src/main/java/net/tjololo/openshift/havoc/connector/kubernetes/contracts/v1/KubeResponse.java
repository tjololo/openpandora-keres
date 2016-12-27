package net.tjololo.openshift.havoc.connector.kubernetes.contracts.v1;

import java.util.List;

/**
 * Created by veg on 20.12.2016.
 */
public class KubeResponse {
    private String kind;
    private List<Item> items;

    public KubeResponse() {
    }

    public KubeResponse(String kind, List<Item> items) {
        this.kind = kind;
        this.items = items;
    }

    public String getKind() {
        return kind;
    }

    public List<Item> getItems() {
        return items;
    }
}
