const express = require('express')
const cors = require('cors')

const app = express()
const port = 8081

app.use(
    express.urlencoded({
        extended: true
    })
)

app.use(express.json({
        type: "*/*"
    })
)

app.use(cors())

app.get('/get', (req,res,) => {
    res.send('Funsiona con get')
})

app.post('/post', (req,res,) => {
    res.send('Funsiona con post')
})

app.listen(port, () => {
    console.log('Se ejecuta en el puerto el localhost')
})