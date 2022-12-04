import requests

projectIdToDelete = 1
res = requests.delete('http://localhost:8080/api/projects/' + str(projectIdToDelete))

print(res.json())
