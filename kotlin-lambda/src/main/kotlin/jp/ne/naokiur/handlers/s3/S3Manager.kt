package jp.ne.naokiur.handlers.s3

import com.amazonaws.regions.Regions
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder
import com.amazonaws.services.dynamodbv2.model.AttributeValue
import com.amazonaws.services.dynamodbv2.model.PutItemRequest
import com.amazonaws.services.dynamodbv2.model.PutItemResult
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import com.amazonaws.services.s3.model.S3ObjectInputStream
import java.util.*

class S3Manager {
    private val s3: AmazonS3 = AmazonS3ClientBuilder
            .standard()
            .withRegion(Regions.AP_NORTHEAST_1)
            .build()

    fun describeBuckets() {
        for (bucket in s3.listBuckets()) {
            println(bucket)
        }
    }
    fun loadObjectContent(bucketName: String, objectKey: String): S3ObjectInputStream {
        return s3.getObject(bucketName, objectKey).objectContent
    }
}