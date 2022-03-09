import React  from "react";
import {Avatar,Paper, Button, Grid, TextField} from "@material-ui/core"
import AccountCircleIcon from '@material-ui/icons/AccountCircle';

const login =()=>{

    const paperStyle={padding:20, height: "40vh", width:200, margin:"20px auto"}

    const avatarStyle={backgroundColor:'#FF7000'}

    const btnStyle={margin:'8px 0'}
    return(
        <Grid>
            <Paper elevation = {10} style = {paperStyle}>
                <Grid align= 'center'>
                <Avatar style={avatarStyle}><AccountCircleIcon/></Avatar>
                    <h2>Iniciar Sesión </h2>    
                </Grid>      
                <TextField label = 'Usuario' placeholder="Ingresa tu correo" fullWidth required/>
                <TextField label = 'Contraseña' placeholder="Ingresa tu contraseña" fullWidth required type='password'/>
                <Button style={btnStyle} type= 'submit' variant="contained" color = 'primary' fullWidth>Ingresar</Button>
            </Paper>
        </Grid>
    )
}

export default login