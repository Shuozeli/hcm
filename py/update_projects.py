import requests

projectIdToUpdate = 1
res = requests.put('http://localhost:8080/api/projects/' + str(projectIdToUpdate), json={
    'name': 'foo',
    'description': 'new project description'
})

print(res.json())
