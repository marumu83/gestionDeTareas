const formElement = document.getElementById("fomularioRegistroTarea");

formElement.addEventListener("submit", (event) => {
    event.preventDefault();

    let titulo = document.getElementById("nombreTarea").value;
    let descripcion = document.getElementById("descripcionTarea").value;
    let fechaFin = document.getElementById("fechaFin").value;
    let fechaAlta = new Date().toISOString().slice(0, 10);
    let finalizada = new Boolean(false);
    let tarea = {titulo : titulo, fechaAlta:fechaAlta , fechaFin : fechaFin , descripcion: descripcion, finalizada : finalizada}
    let tareaJson = JSON.stringify(tarea);
    console.log(tareaJson);  
    
    fetch('http://localhost:8080/tarea/new', {

        method : 'Post',

            headers : {

                'Accept': 'application/json',
                'Content-Type' : 'application/json'
            },

        body : tareaJson
    })
    .then(x => console.log(tareaJson))

})