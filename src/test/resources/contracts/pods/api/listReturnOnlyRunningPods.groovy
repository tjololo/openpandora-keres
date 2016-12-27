package contracts.pods.api

/**
 * Created by veg on 21.12.2016.
 */
org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        url '/pods/test'
        headers {
            header('Content-Type': 'application/keres.pods.v1+json')
        }
    }
    response {
        status 200
        body("""
[
    {
        "name": "test-pod-1-adfx2",
        "kubeselflink": "/api/v1/namespaces/test/pods/test-pod-1-adfx2",
        "killlink": "/pods/kill/test/test-pod-1-adfx2"
    }
]
""")
    }
}