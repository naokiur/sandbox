import csv


def generate():
	records = [
		["{},sample{}".format(i, i)]
		for i in range(1000)
	]

	with open('records.csv', 'w') as f:
		writer: csv.DictWriter = csv.writer(f, lineterminator='\n')
		writer.writerows(records)


generate()
