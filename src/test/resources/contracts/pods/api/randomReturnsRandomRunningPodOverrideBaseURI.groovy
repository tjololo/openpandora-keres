package contracts.pods.api

/**
 * Created by veg on 21.12.2016.
 */
org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        url '/pod/random/test?uri=https://openshift.org:8443'
        headers {
            header('Content-Type': 'application/keres.pods.v1+json')
        }
    }
    response {
        status 200
        body([
                    "name": $(regex(/newbase-pod-1-adfx2/)),
                    "kubeselflink": $(regex(/\/api\/v1\/namespaces\/test\/pods\/newbase-pod-1-adfx2/)),
                    "killlink": $(regex(/\/pods\/kill\/test\/newbase-pod-1-adfx2/))
        ])
    }
}