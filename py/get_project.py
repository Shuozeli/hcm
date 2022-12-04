import requests

projectIdToGet = 1
res = requests.get('http://localhost:8080/api/projects/' + str(projectIdToGet))

print(res.json())
