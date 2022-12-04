import requests

res = requests.post('http://localhost:8080/api/employees', json={
    'name': 'foo',
    'email': 'foo@gmail.com',
    'title': 'Driver',
})

print(res.json())
