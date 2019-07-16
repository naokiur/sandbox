import json

# import requests
from s3.s3_manager import S3Manager


def lambda_handler(event, context):
    s3 = S3Manager()
    result: str = s3.load_object_content('sample-650800120138', 'records.csv')

    line_separated_result = result.split('\n')
    csv_data = [
        line.split(',')
        for line in line_separated_result
        # not isBlank
        if line.strip()
    ]

    sum_id = sum([
        int(line[0])
        for line in csv_data
    ])

    return {
        "statusCode": 200,
        "body": json.dumps({
            "message": sum_id,
            # "location": ip.text.replace("\n", "")
        }),
    }
