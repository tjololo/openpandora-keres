package contracts.pods.api

/**
 * Created by veg on 21.12.2016.
 */
org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'POST'
        url '/pods/kill/test/fail-pod-1'
        headers {
            header('Content-Type': 'application/keres.pods.v1+json')
        }
    }
    response {
        status 200
        body("""
{"killed":false}
""")
    }
}
