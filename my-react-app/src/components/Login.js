import React  from "react";
import {Avatar,Paper, Button, Grid, TextField} from '@mui/material';
import AccountCircleIcon from '@mui/icons-material/AccountCircle';
import useLogin from './useLogin';

const Login =()=>{

    const paperStyle={padding:20, height: "40vhFF7000", width:200, margin:"20px auto"}
    const avatarStyle={backgroundColor:'#C500FF'}
    const btnStyle={margin:'8px 0'}

    const {handleSetEmail,handleSetPass,handleSubmit,errors} = useLogin();
     
    return(
        <Grid>
            <form onSubmit={handleSubmit}>
                <Paper elevation = {10} style = {paperStyle}>
                    <Grid align= 'center'>
                    <Avatar style={avatarStyle}><AccountCircleIcon/></Avatar>
                        <h2>Iniciar Sesión </h2>    
                    </Grid>      
                    <TextField label = 'Usuario' placeholder="Ingresa tu correo" color="secondary" fullWidth required type = 'email' id = 'inputEmail' variant="standard"  onChange={handleSetEmail}/>
                    <TextField label = 'Contraseña' placeholder="Ingresa tu contraseña" color="secondary" fullWidth required type='password' id = 'inputPass' variant="standard"  onChange={handleSetPass}/>
                    <Button style={btnStyle} type= 'submit' variant="outlined" color = 'secondary' fullWidth >Ingresar</Button>
                </Paper>
            </form>
        </Grid>
    )
}

export default Login