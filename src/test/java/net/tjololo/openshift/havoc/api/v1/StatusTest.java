package net.tjololo.openshift.havoc.api.v1;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by tjololo on 27/12/16.
 */
public class StatusTest {
    @Test
    public void isKilled_retrun_false_when_status_created_with_false() throws Exception {
        Status status = new Status(false);
        assertThat(status.isKilled(), is(false));
    }

    @Test
    public void isKilled_retrun_true_when_status_created_with_true() throws Exception {
        Status status = new Status(true);
        assertThat(status.isKilled(), is(true));
    }
}