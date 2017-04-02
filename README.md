Install JSON server:
npm install -g json-server

Create db.json to store data. For ex:
```JSON
{
  "Cars": [
    {
      "model": "some value",
      "id": "model id 123"
    }
  ]
}
```
Run JSON server:
json-server --watch db.json