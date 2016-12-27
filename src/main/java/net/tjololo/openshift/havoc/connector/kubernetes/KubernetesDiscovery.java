package net.tjololo.openshift.havoc.connector.kubernetes;

import net.tjololo.openshift.havoc.connector.kubernetes.contracts.v1.KubeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by veg on 19.12.2016.
 */
@Service
public class KubernetesDiscovery {
    private RestTemplate restTemplate;
    private String token;

    @Autowired
    public KubernetesDiscovery(RestTemplate restTemplate, @Value("${net.tjololo.openshift.havoc.token}")String token) {
        this.restTemplate = restTemplate;
        this.token = token;
    }

    public KubeResponse listPods(String baseURI, String namespace) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);
        HttpEntity httpEntity = new HttpEntity(headers);
        ResponseEntity<KubeResponse> responseEntity = restTemplate.exchange(baseURI + "/api/v1/namespaces/" + namespace + "/pods", HttpMethod.GET, httpEntity, KubeResponse.class);
        return responseEntity.getBody();
    }

    public boolean killPod(String baseURI, String namespace, String podname) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + token);
        HttpEntity httpEntity = new HttpEntity(headers);
        ResponseEntity<KubeResponse> responseEntity = restTemplate.exchange(baseURI + "/api/v1/namespaces/" + namespace + "/pods/" + podname, HttpMethod.DELETE, httpEntity, KubeResponse.class);
        return responseEntity.getStatusCode() == HttpStatus.OK;
    }
}
