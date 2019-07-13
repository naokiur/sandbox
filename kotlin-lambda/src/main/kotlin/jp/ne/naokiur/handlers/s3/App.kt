package jp.ne.naokiur.handlers.s3

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import jp.ne.naokiur.handlers.GatewayResponse
import java.util.*

/**
 * Handler for requests to Lambda function.
 */
class App : RequestHandler<Any, Any> {

    override fun handleRequest(input: Any, context: Context): Any {
        val headers = HashMap<String, String>()
        headers["Content-Type"] = "application/json"
        headers["X-Custom-Header"] = "application/json"

        val s3Manager = S3Manager()
        val result = s3Manager.loadObjectContent("sample-650800120138", "records.csv")
        val csv = result
                .split("\n")
                .filter { it.isNotEmpty() }
                .map { it.split(",") }

        // CSV内の1カラム目（id）の合計を算出する
        val sumId = csv.map { it[0].toInt() }.sum()


        return GatewayResponse("result: $sumId", headers, 200)
    }
}
