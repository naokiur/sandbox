from datetime import datetime
import boto3


class DynamodbManager:
	def __init__(self):
		self.dynamodb = boto3.resource(
				'dynamodb',
				region_name='ap-northeast-1'
		)
		self.table_name = 'login-history'

	def put_item(self, user_name: str, login_time: datetime):
		table = self.dynamodb.Table(self.table_name)
		res = table.put_item(
				Item={
					'user_name': user_name,
					'login_time': int(login_time.timestamp())
				}
		)

		return res
