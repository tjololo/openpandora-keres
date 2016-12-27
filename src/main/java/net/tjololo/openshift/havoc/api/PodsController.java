package net.tjololo.openshift.havoc.api;

import net.tjololo.openshift.havoc.api.v1.Pod;
import net.tjololo.openshift.havoc.api.v1.Status;
import net.tjololo.openshift.havoc.connector.kubernetes.KubernetesDiscovery;
import net.tjololo.openshift.havoc.connector.kubernetes.contracts.v1.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by veg on 20.12.2016.
 */
@RestController
public class PodsController {
    private KubernetesDiscovery kubernetesDiscovery;
    private String defaultURI;
    private static final String PODS_JSON_V1 = "application/keres.pods.v1+json";
    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public PodsController(KubernetesDiscovery kubernetesDiscovery, @Value("${net.tjololo.openshift.havoc.master.uri}") String defaultURI) {
        this.kubernetesDiscovery = kubernetesDiscovery;
        this.defaultURI = defaultURI;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/pods/{namespace}", consumes = PODS_JSON_V1, produces = PODS_JSON_V1)
    public List<Pod> getRunningPods(@RequestParam(value = "uri", required = false) String overrideURI, @PathVariable String namespace) {
        List<Pod> podList = kubernetesDiscovery.listPods(getURI(overrideURI), namespace).getItems().stream()
                .filter(i -> "Running".equals(i.getStatus().getPhase()))
                .map(i ->
                        new Pod(
                                i.getMetadata().getName(),
                                i.getMetadata().getSelfLink(),
                                "/pods/kill/" + i.getMetadata().getNamespace() + "/" + i.getMetadata().getName()
                        )
                )
                .collect(Collectors.toList());
        log.info(podList.toString());
        return podList;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/pods/kill/{namespace}/{podname}", consumes = PODS_JSON_V1, produces = PODS_JSON_V1)
    public Status killPod(@RequestParam(value = "uri", required = false) String overrideURI, @PathVariable String namespace, @PathVariable String podname) {
        return new Status(kubernetesDiscovery.killPod(getURI(overrideURI), namespace, podname));
    }

    private String getURI(@RequestParam(value = "uri", required = false) String overrideURI) {
        if (StringUtils.isEmpty(overrideURI)) {
            return defaultURI;
        }
        return overrideURI;
    }
}
