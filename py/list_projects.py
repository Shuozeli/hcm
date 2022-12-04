import requests

res = requests.get('http://localhost:8080/api/projects')

print(res.json())
