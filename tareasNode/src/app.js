const express = require('express')
const app = express()
const path = require('path')
const bodyParser = require('body-parser');
const { route } = require('./routes/lista.routes');
const axios = require('axios');

//
app.use(express.static(path.join(__dirname, '../public')))

//Motor de plantillas Pug
app.set('view engine', 'pug')
app.set('views', path.join(__dirname, 'views'))

//
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));


//Routes
app.use(require('./routes/lista.routes'))

app.post('/crear', async (req, res) => {

    //se crean los valores de alta con el dia actual y por defecto no finalizada
    let fechaAlta = new Date().toISOString().slice(0, 10);
    let ultimaModificacion = new Date().toISOString().slice(0, 10);
    let finalizada = Boolean(false);
  
    const { titulo, descripcion, fechaFin} = req.body;
    try {
      const response = await axios.post(`http://localhost:8080/api/tareas/nueva`, {
        titulo,
        descripcion,
        fechaFin,
        fechaAlta,
        ultimaModificacion,
        finalizada
      });
      const lis = await axios.get(`http://localhost:8080/api/tareas/all`);
      const lista = lis.data;
      res.render('lista', {lista:lista})
    } catch (error) {
      console.error(error);
      res.status(500).send('Error al registrar tarea');
    }
  });

app.get('/lista', async (req, res)=>{

    const response = await axios.get(`http://localhost:8080/api/tareas/all`);
    const lista = response.data;
    res.render('lista', {lista:lista})
    
})

app.post('/delete', async(req, res) =>{ 
  
    const id = req.body.id; 
    console.log(id) 
  try {
    const response = await axios.delete(`http://localhost:8080/api/tareas/eliminar/${id}`);
     res.status(200);
     const lis = await axios.get(`http://localhost:8080/api/tareas/all`);
     const lista = lis.data;
     res.render('lista', {lista:lista})
  } catch (error) {
    console.error(error);
    res.status(500).send('Error al registrar tarea');
  }

});


app.post('/modificar', async(req, res) =>{ 

  const id = req.body.id; 
  console.log(id)
  let temp= await axios.get(`http://localhost:8080/api/tareas/id/${id}`);
  let tarea= temp.data
  console.log(tarea)
  
  res.render('actualiza', {tarea:tarea});

});

// Redireccion por defecto si no existe la ruta
app.use((req, res)=>{
    res.sendFile(path.join(__dirname, '../public/404.html'))
})

app.listen(3000, ()=>{

    console.log('Servidor node levantado')

})

