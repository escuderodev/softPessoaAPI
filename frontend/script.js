const form = document.querySelector("form");

form.addEventListener("submit", evento => {
    evento.preventDefault();
    
    const formData = new FormData(form);
    const data = Object.fromEntries(formData);

    console.log(data);

    fetch("http://localhost/pessoas", {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data)
    }).then(res => res.json()).then(data => console.log(data))
})
