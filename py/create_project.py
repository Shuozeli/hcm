import requests

res = requests.post('http://localhost:8080/api/employees', json={
    'name': 'HCM system',
    'description': 'Build the HCM system using Java Spring Boot',
})

print(res.json())
