package jp.ne.naokiur.handlers

import java.util.Collections
import java.util.HashMap

/**
 * POJO containing response object for API Gateway.
 */
class GatewayResponse(val body: String, headers: Map<String, String>, val statusCode: Int) {
    val headers: Map<String, String>

    init {
        this.headers = Collections.unmodifiableMap(HashMap(headers))
    }
}
