package net.tjololo.openshift.havoc.api.v1;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by tjololo on 27/12/16.
 */
public class PodTest {

    @Test
    public void empty_constructor_creates_blank_object() throws Exception {
        Pod pod = new Pod();
        assertThat(pod.getName(), nullValue());
        assertThat(pod.getKubeselflink(), nullValue());
        assertThat(pod.getKilllink(), nullValue());
    }

    @Test
    public void constructor_with_values_set_properties() throws Exception {
        Pod pod = new Pod("name", "/kubes/link", "/kill/link");
        assertThat(pod.getName(), equalTo("name"));
        assertThat(pod.getKubeselflink(), equalTo("/kubes/link"));
        assertThat(pod.getKilllink(), equalTo("/kill/link"));
    }
}