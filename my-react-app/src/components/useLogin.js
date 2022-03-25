import React, { useState,useEffect } from "react";
import { userConnection } from "./userConnection";
import {useNavigate} from 'react-router-dom';

const useLogin = () => {

    const [data, setData] = useState({email: '', password: ''});
    const [token, setToken] = useState(null);
    const [error, setError] = useState(null);
    const navigate = useNavigate();

    const handleSetEmail = (ev) =>{
        const {name,value} = ev.target;
        if (ev.target.id === "inputEmail"){
            setData( predata => {return {...predata, email: value}});
        };
    };

    function handleSetPass (ev) {
        const {name,value} = ev.target;
        if (ev.target.id === "inputPass"){
            setData({...data, password: value});
        }
    };

    const handleSubmit = async ev => {
        ev.preventDefault();
        authLogin();
    };

    const authLogin = () => {
        userConnection.getToken(data).then(
            token => {setToken(token);
        }).catch(() => {
            console.log(error);
            setError(error);
        });
        authNavi(token);
    };

    const authNavi = (token) =>  {
        if (token != null){
            navigate('/inicio');
        }
    };

    return {handleSetEmail,handleSetPass,handleSubmit,error};

};
export default useLogin;