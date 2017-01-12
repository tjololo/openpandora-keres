package contracts.pods.api

/**
 * Created by veg on 21.12.2016.
 */
org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        url '/pod/random/randompod'
        headers {
            header('Content-Type': 'application/keres.pods.v1+json')
        }
    }
    response {
        status 200
        body([
                    "name": $(regex(/random-pod-[0-9]-adfx2/)),
                    "kubeselflink": $(regex(/\/api\/v1\/namespaces\/randompod\/pods\/random-pod-[0-9]-adfx2/)),
                    "killlink": $(regex(/\/pods\/kill\/randompod\/random-pod-[0-9]-adfx2/))
        ])
    }
}