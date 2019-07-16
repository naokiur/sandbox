import json

# import requests


def lambda_handler(event, context):
    output = sum(list(range(1, 1001)))

    return {
        "statusCode": 200,
        "body": json.dumps({
            "message": output,
            # "location": ip.text.replace("\n", "")
        }),
    }
