const express = require('express');
const bodyParser = require('body-parser');
const dotenv = require('dotenv');
const axios = require('axios');
const app = express();
const path = require('path');

dotenv.config();

app.use(bodyParser.urlencoded({ extended: false }));
app.use(express.static(path.join(__dirname, 'public'))); // Sirve archivos estáticos en la carpeta public

app.get('/', (req, res) => {
  res.sendFile(path.join(__dirname, 'index.html')); // Sirve el formulario HTML en la ruta /
});

app.post('/', async (req, res) => {
  const { titulo, descripcion, fechaFin } = req.body;
  try {
    const response = await axios.post(`${process.env.API_URL}/nueva`, {
      titulo,
      descripcion,
      fechaFin,
    });
    console.log(response.data);
    res.send('tarea registrada correctamente');
  } catch (error) {
    console.error(error);
    res.status(500).send('Error al registrar tarea');
  }
});

// Iniciar el servidor
const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
  console.log(`Servidor escuchando en el puerto ${PORT}`);
});