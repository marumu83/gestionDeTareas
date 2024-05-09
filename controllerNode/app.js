const express = require('express');
const bodyParser = require('body-parser');
const dotenv = require('dotenv');
const axios = require('axios');
const app = express();
const path = require('path');

dotenv.config();

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(express.static(path.join(__dirname, 'public'))); // Sirve archivos estáticos en la carpeta public

app.get('/', (req, res) => {
  res.sendFile(path.join(__dirname, 'index.html')); // Sirve el formulario HTML en la ruta /
});

app.post('/', async (req, res) => {

  //se crean los valores de alta con el dia actual y por defecto no finalizada
  fechaAlta = new Date().toISOString().slice(0, 10);
  ultimaModificacion = new Date().toISOString().slice(0, 10);
  finalizada = new Boolean(false);

  const { titulo, descripcion, fechaFin} = req.body;
  try {
    const response = await axios.post(`${process.env.API_URL}/nueva`, {
      titulo,
      descripcion,
      fechaFin,
      fechaAlta,
      ultimaModificacion,
      finalizada
    });
    console.log(response.data);
    res.send('tarea registrada correctamente');
  } catch (error) {
    console.error(error);
    res.status(500).send('Error al registrar tarea');
  }
});

app.get('/todos', async(req, res) => {
  try {
    const response = await axios.get(`${process.env.API_URL}/all`);
    const lista = response.data;
    console.log(response.data);
    
    res.status(200).json(lista)
  } catch (error) {
    console.error(error);
    res.status(500).send('Error al registrar tarea');
  }
});

app.delete('/delete/:id', async(req, res) =>{ 
  
  const id = req.params.id;
  console.log(id);
  
  try {
    const response = await axios.delete(`${process.env.API_URL}/delete/`, id);
     res.status(200).json(lista)
  } catch (error) {
    console.error(error);
    res.status(500).send('Error al registrar tarea');
  }

});

// Iniciar el servidor
app.listen(process.env.PORT, () => {
  console.log(`Servidor escuchando en el puerto ${process.env.PORT}`);
});
