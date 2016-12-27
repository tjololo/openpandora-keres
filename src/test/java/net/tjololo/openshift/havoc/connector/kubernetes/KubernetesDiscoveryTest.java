package net.tjololo.openshift.havoc.connector.kubernetes;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by veg on 19.12.2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class KubernetesDiscoveryTest {
    private KubernetesDiscovery kubernetesDiscovery;
    @Mock
    private RestTemplate restTemplate;
    private static final String TOKEN="22Token22";

    @Before
    public void setUp() {
        kubernetesDiscovery = new KubernetesDiscovery(restTemplate, TOKEN);
    }

    @Test
    public void check_that_kubernetesDiscovery_not_null() throws Exception {
        assertThat(kubernetesDiscovery, not(nullValue()));
    }
}
