import json

# import requests
from datetime import datetime

from dynamodb.dynamodb_manager import DynamodbManager


def lambda_handler(event, context):

    dynamodb_manager = DynamodbManager()
    dynamodb_manager.put_item('b', datetime.now())

    return {
        "statusCode": 200,
        "body": json.dumps({
            "message": "hello world",
            # "location": ip.text.replace("\n", "")
        }),
    }
