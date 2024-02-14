fetch('http://localhost/pessoas')
.then(response => response.json())
.then(data => {
    const tabela = document.getElementById('tabelaPessoas').getElementsByTagName('tbody')[0];
    data.content.forEach(pessoa => {
        const row = tabela.insertRow();
        row.insertCell(0).textContent = pessoa.id;
        row.insertCell(1).textContent = pessoa.nome;
        row.insertCell(2).textContent = pessoa.sexo;
        row.insertCell(3).textContent = pessoa.email;
        row.insertCell(4).textContent = pessoa.dataNascimento;
        row.insertCell(5).textContent = pessoa.naturalidade;
        row.insertCell(6).textContent = pessoa.nacionalidade;
        row.insertCell(7).textContent = pessoa.cpf;
    });
})
.catch(error => console.error('Erro ao carregar os dados:', error));