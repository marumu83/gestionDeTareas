const express = require('express')
const router = express.Router()
const controller = require('../controllers/lista.controller')


router.get('/', controller.lista)

module.exports = router;