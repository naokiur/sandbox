package jp.ne.naokiur.handlers.dynamodb

import com.amazonaws.auth.profile.ProfileCredentialsProvider
import com.amazonaws.regions.Regions
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import java.io.File

class DynamoDBManager {
    private val dynamodb: AmazonDynamoDB

    init {
        println(System.getProperty("user.home"))
        println(File(System.getProperty("user.home"), ".aws"))

        val credentialsProvider = ProfileCredentialsProvider()
        credentialsProvider.credentials

        dynamodb = AmazonDynamoDBClientBuilder
                .standard()
                .withCredentials(credentialsProvider)
                .withRegion(Regions.AP_NORTHEAST_1)
                .build()

    }

    public fun putItem() {
        println("putItem")
    }
}