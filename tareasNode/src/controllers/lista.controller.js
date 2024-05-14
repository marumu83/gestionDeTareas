const axios = require('axios');
const controller = {}



controller.lista = async (req, res) =>{

    const response = await axios.get(`http://localhost:8080/all`);
    const lista = response.data;
    res.render('lista', {lista:lista})
}

module.exports = controller