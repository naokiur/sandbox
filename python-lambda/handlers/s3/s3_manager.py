import boto3


class S3Manager:
	def __init__(self):
		self.s3 = boto3.resource(
				's3',
				region_name='ap-northeast-1'
		)

	def load_object_content(self, bucket_name: str, key: str):
		obj = self.s3.Object(bucket_name, key)

		return obj.get()['Body'].read().decode('utf-8')
