const express = require('express');
const app = express();
const path = require('path');
const bodyParser = require('body-parser');
const { route } = require('./routes/lista.routes');
const axios = require('axios');
const bcrypt = require('bcryptjs');

//Inicio de la app
app.use(express.static(path.join(__dirname, '../public')));

//Motor de plantillas Pug
app.set('view engine', 'pug');
app.set('views', path.join(__dirname, 'views'));

//BodyParser
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));


//Routes
app.use(require('./routes/lista.routes'));

/////////////////////////Endpoints de Tareas//////////////////////////////////////

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
    
});

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
    res.status(500).send('Error al eliminar tarea');
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

app.post('/update', async (req, res) => {

  let ultimaModificacion = new Date().toISOString().slice(0, 10);
  let fechaAlta = req.body.fechaAlta
  let tarea = req.body
  let id = tarea.id
  const { titulo, descripcion, fechaFin} = req.body;
  let finalizada = req.body.finalizada === "on";
  try {
    const response = await axios.put(`http://localhost:8080/api/tareas/update`, {
      id,
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
    res.status(500).send('Error al modificar la tarea');
  }
});

///////////////////////////////////Cosas de Usuario////////////////////////////////////

app.post('/registrarusuario', async (req, res) => {
 
  const role = "USER"
  console.log(req.body)
  const { nombre, email, password} = req.body;
  try {
    const userData = {
      nombre,
      email,
      password,
      role,
    };
    console.log("contraseña", password)
      const response = await axios.post(`http://localhost:8080/api/usuarios/nuevo`, {
      nombre,
      email,
      password,
      role,
    });
    console.log(userData)
    res.sendFile(path.join(__dirname, '../public/index.html'))
 
  } catch (error) {
    console.error(error);
    res.status(500).send('Error al registrar al usuario');
  }
});

app.get('/listausuario', async (req, res)=>{

  const response = await axios.get(`http://localhost:8080/api/usuarios/all`);
  const lista = response.data;
  res.render('listausers', {lista:lista})
  
})

app.post('/login', async (req,res) => {

  const { username, password } = req.body;
  console.log({username, password});
  try{
      const userData = {
        username,
        password,
      };
    const response = await axios.post(`http://localhost:8080/api/auth/login`, {
      username,
      password,
    });
   
      const listam = await axios.get(`http://localhost:8080/api/tareas/all`);
      const lista = listam.data;
      res.render('lista', {lista:lista})
 

  }catch(error){
    console.error(error);
    res.status(500).send('Contraseña o nombre de usuario incorrectos.');
  }

});

// Redireccion por defecto si no existe la ruta
app.use((req, res)=>{
  res.sendFile(path.join(__dirname, '../public/404.html'))
});

app.listen(3000, ()=>{

  console.log('Servidor node levantado')

});