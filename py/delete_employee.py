import requests

employeeIdToDelete = 1
res = requests.delete('http://localhost:8080/api/employees/' + str(employeeIdToDelete))

print(res.json())
