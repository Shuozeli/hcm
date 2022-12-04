import requests

employeeIdToGet = 1
res = requests.get('http://localhost:8080/api/employees/' + str(employeeIdToGet))

print(res.json())
