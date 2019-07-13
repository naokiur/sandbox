package jp.ne.naokiur.handlers.s3

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class S3ManagerTest {

    @Test
    fun describeBuckets() {
    }

    @Test
    fun loadObjectContent() {
        val s3Manager = S3Manager()
        val result = s3Manager.loadObjectContent("sample-650800120138", "records.csv")

        val csv = result.split("\n").filter { it.isNotEmpty() }.map { it.split(",") }
//        val sumId = csv.map { it[0] }
        val sumId = csv.map { it[0].toInt() }.sum()

        println(sumId)
    }
}