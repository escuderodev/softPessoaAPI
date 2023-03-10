const formulario = document.querySelector(".form");
const INome = document.getElementById("nome");
const ISexo = document.getElementById("sexo");
const IEmail = document.getElementById("mail");
const IDataNascimento = document.getElementById("data_nasc");
const INaturalidade = document.getElementById("naturalidade");
const INacionalidade = document.getElementById("nacionalidade");
const ICpf = document.getElementById("cpf");

function cadastrar() {
    fetch("http://localhost:8080/pessoa",
    {
        headers: {
            'Accept' : 'application/json',
            'Content-Type' : 'application/json'
        },
        method: 'POST',
        body: JSON.stringify({
            nome: INome.value,
            sexo: ISexo.value,
            email: IEmail.value,
            dataNascimento: IDataNascimento.value,
            naturalidade: INaturalidade.value,
            nacionalidade: INacionalidade.value,
            cpf: ICpf.value
        })
    })
    .then(function(res) {console.log(res)})
    .catch(function(res) {console.log(res)})
}

function limparCampos() {
    INome.value = "";
    ISexo.value = "";
    IEmail.value = "";
    IDataNascimento.value = "";
    INaturalidade.value = "";
    INacionalidade.value = "";
    ICpf.value = "";
}

formulario.addEventListener('submit', function(event) {
    event.preventDefault();

    cadastrar();
    limparCampos();
});