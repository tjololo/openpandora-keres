package contracts.pods.api

/**
 * Created by veg on 21.12.2016.
 */
org.springframework.cloud.contract.spec.Contract.make {
    request {
        method 'GET'
        url '/pod/random/empty'
        headers {
            header('Content-Type': 'application/keres.pods.v1+json')
        }
    }
    response {
        status 404
    }
}