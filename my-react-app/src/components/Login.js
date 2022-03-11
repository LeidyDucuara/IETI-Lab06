import React  from "react";
import {Avatar,Paper, Button, Grid, TextField} from '@mui/material';
import AccountCircleIcon from '@mui/icons-material/AccountCircle';
import useFetchPost from '../hooks/useFetch';

const Login =()=>{

    const paperStyle={padding:20, height: "40vh", width:200, margin:"20px auto"}

    const avatarStyle={backgroundColor:'#FF7000'}

    const btnStyle={margin:'8px 0'}

    const {token,error} = useFetchPost('http://localhost:8080/v1/user')

    return(
        <Grid>
            <Paper elevation = {10} style = {paperStyle}>
                <Grid align= 'center'>
                <Avatar style={avatarStyle}><AccountCircleIcon/></Avatar>
                    <h2>Iniciar Sesión </h2>    
                </Grid>      
                <TextField label = 'Usuario' placeholder="Ingresa tu correo" fullWidth required variant="standard"/>
                <TextField label = 'Contraseña' placeholder="Ingresa tu contraseña" fullWidth required type='password' variant="standard"/>
                <Button style={btnStyle} type= 'submit' variant="contained" color = 'primary' fullWidth>Ingresar</Button>
            </Paper>
        </Grid>
    )
}

export default Login