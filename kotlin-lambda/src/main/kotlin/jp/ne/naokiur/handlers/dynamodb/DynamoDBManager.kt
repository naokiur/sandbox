package jp.ne.naokiur.handlers.dynamodb

import com.amazonaws.regions.Regions
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import com.amazonaws.services.dynamodbv2.model.AttributeValue
import com.amazonaws.services.dynamodbv2.model.PutItemRequest
import com.amazonaws.services.dynamodbv2.model.PutItemResult
import java.util.*

class DynamoDBManager {
    private val dynamodb: AmazonDynamoDB = AmazonDynamoDBClientBuilder
            .standard()
            .withRegion(Regions.AP_NORTHEAST_1)
            .build()

    private val tableName = "login-history"

    fun putItem(userName: String, loginTime: Calendar): PutItemResult {

        // Convert milli time to time.
        val time: Long = loginTime.time.time / 1000

        val item = mapOf(
                "user_name" to AttributeValue(userName),
                "login_time" to AttributeValue().withN(time.toString())
        )

        val putItemRequest = PutItemRequest(tableName, item)
        return dynamodb.putItem(putItemRequest)
    }
}