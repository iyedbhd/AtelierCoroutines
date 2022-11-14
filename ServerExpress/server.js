import express from 'express';
import morgan from 'morgan';
import cors from 'cors';




const app = express();
const port = 1337;

console.log(process.env.TOKEN_KEY)


app.use(cors());
app.use(morgan('dev'));
app.use(express.json());
app.use(express.urlencoded({ extended: true }));




app.get('/getData', async (req, res) => {
    await new Promise(resolve => setTimeout(resolve, 2000));
    res.status(200).json({data: 'Hello World!'}); // envoyer la réponse au requérant
})


app.listen(port, () => {
console.log(`Server running at http://localhost:${port}/`);
});



