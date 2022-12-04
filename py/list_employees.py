import requests

res = requests.get('http://localhost:8080/api/employees')

print(res.json())
