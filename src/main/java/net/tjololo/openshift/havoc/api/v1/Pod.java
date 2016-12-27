package net.tjololo.openshift.havoc.api.v1;

/**
 * Created by tjololo on 27/12/16.
 */
public class Pod {
    private String name;
    private String kubeselflink;
    private String killlink;

    public Pod() {
    }

    public Pod(String name, String kubeselflink, String killlink) {
        this.name = name;
        this.kubeselflink = kubeselflink;
        this.killlink = killlink;
    }

    public String getName() {
        return name;
    }

    public String getKubeselflink() {
        return kubeselflink;
    }

    public String getKilllink() {
        return killlink;
    }

    @Override
    public String toString() {
        return "Pod{" +
                "name='" + name + '\'' +
                ", kubeselflink='" + kubeselflink + '\'' +
                ", killlink='" + killlink + '\'' +
                '}';
    }
}
