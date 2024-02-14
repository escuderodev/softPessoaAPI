const endpoint = "http://localhost/pessoas"

fetch(endpoint)
.then((res) => res.json())
.then((dados) => console.log(dados.content))
.catch((erro) => console.error(erro))
