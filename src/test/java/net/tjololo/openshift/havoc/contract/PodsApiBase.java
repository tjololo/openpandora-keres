package net.tjololo.openshift.havoc.contract;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import net.tjololo.openshift.havoc.api.PodsController;
import net.tjololo.openshift.havoc.connector.kubernetes.KubernetesDiscovery;
import net.tjololo.openshift.havoc.connector.kubernetes.contracts.v1.Item;
import net.tjololo.openshift.havoc.connector.kubernetes.contracts.v1.KubeResponse;
import net.tjololo.openshift.havoc.connector.kubernetes.contracts.v1.Metadata;
import net.tjololo.openshift.havoc.connector.kubernetes.contracts.v1.Status;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Created by veg on 21.12.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class PodsApiBase {
    @Mock
    private KubernetesDiscovery kubernetesDiscovery;

    @Before
    public void setup() {
        setupListMocks();
        setupKillMocks();
        RestAssuredMockMvc.standaloneSetup(new PodsController(kubernetesDiscovery, "https://10.2.2.2:8443"));
    }

    private void setupListMocks() {
        when(kubernetesDiscovery.listPods("https://10.2.2.2:8443", "empty"))
                .thenReturn(new KubeResponse("PodList", Collections.emptyList()));
        ArrayList<Item> items = getItems(
                getItem("test-pod-1-adfx2", "Running"),
                getItem("test-pod-1-build", "Failed")
        );
        when(kubernetesDiscovery.listPods("https://10.2.2.2:8443", "test"))
                .thenReturn(new KubeResponse("PodList", items));
        ArrayList<Item> items2 = getItems(
                getItem("newbase-pod-1-adfx2", "Running"),
                getItem("newbase-pod-1-build", "Failed")
        );
        when(kubernetesDiscovery.listPods("https://openshift.org:8443", "test"))
                .thenReturn(new KubeResponse("PodList", items2));
    }

    private Item getItem(String name, String phase) {
        return new Item(
                new Metadata(name, "/api/v1/namespaces/test/pods/" + name, "test"),
                new Status(phase)
        );
    }

    private ArrayList<Item> getItems(Item... items) {
        ArrayList<Item> itemsList = new ArrayList<>();
        Collections.addAll(itemsList, items);
        return itemsList;
    }

    private void setupKillMocks() {
        when(kubernetesDiscovery.killPod("https://10.2.2.2:8443", "test", "ok-pod-1"))
                .thenReturn(true);
        when(kubernetesDiscovery.killPod("https://10.2.2.2:8443", "test", "fail-pod-1"))
                .thenReturn(false);
        when(kubernetesDiscovery.killPod("https://openshift.org:8443", "other", "other-pod-1"))
                .thenReturn(true);
    }

    @Test
    public void dummyTest_do_I_really_need_this() {
        assertThat(true, is(true));
    }
}
