import React  from "react";
import {useState, useEffect} from 'react';
import {useNavigate} from 'react-router-dom'
import {Avatar,Paper, Button, Grid, TextField} from '@mui/material';
import AccountCircleIcon from '@mui/icons-material/AccountCircle';

const Login =()=>{

    const paperStyle={padding:20, height: "40vhFF7000", width:200, margin:"20px auto"}
    const avatarStyle={backgroundColor:'#C500FF'}
    const btnStyle={margin:'8px 0'}
    const[email,setEmail] = useState('')
    const[password,setPassword] = useState('')
    const navigate = useNavigate();

    const handleSetEmail = (event) =>{
        const {name,value} = event.currentTarget;
        setEmail(value);
    }

    const handleSetPass = (event) =>{
        const {name,value} = event.currentTarget;
        setPassword(value);
    }

    const useFetchPost = () => {

        const [token, setToken] = useState(null)
        const [error, setError] = useState(null)
        useEffect(() => {
            const requestOptions = {
                mode: 'cors',
                method: 'POST',
                headers:{'Content-Type': 'application/json'},
                body: JSON.stringify({
                    "email":email,
                    "password":password
                })
            }
    
            const fetchResource = async() => {
                try{
                    let res = await fetch('http://localhost:8080/v1/auth',requestOptions)
                    .then(json =>{window.$token=json.token;
                                window.$expiration=json.expirationDate;})
                    console.log(res.statusText)
                    let data = await res.json()
                    setToken(data)
                    navigate("/inicio")
                }catch(error){
                    setError(error)
                }
            } 
            fetchResource()
        })
        return{token,error}
    }
     
    return(
        <Grid>
            <form onSubmit={useFetchPost}>
                <Paper elevation = {10} style = {paperStyle}>
                    <Grid align= 'center'>
                    <Avatar style={avatarStyle}><AccountCircleIcon/></Avatar>
                        <h2>Iniciar Sesión </h2>    
                    </Grid>      
                    <TextField label = 'Usuario' placeholder="Ingresa tu correo" color="secondary" fullWidth required type = 'email' variant="standard" value={email?.email} onChange={handleSetEmail}/>
                    <TextField label = 'Contraseña' placeholder="Ingresa tu contraseña" color="secondary" fullWidth required type='password' variant="standard" value ={password} onChange={handleSetPass}/>
                    <Button style={btnStyle} type= 'submit' variant="outlined" color = 'secondary' fullWidth>Ingresar</Button>
                </Paper>
            </form>
        </Grid>
    )
}

export default Login