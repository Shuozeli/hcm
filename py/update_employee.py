import requests

employeeIdToUpdate = 1
res = requests.put('http://localhost:8080/api/employees/' + str(employeeIdToUpdate), json={
    'name': 'foo',
    'title': 'Painter',
})

print(res.json())
