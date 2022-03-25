export const userConnection = (() => {

    const url = 'http://localhost:8080/v1/auth';
    return{
        getToken: async creLogin => {
            let res = await fetch(this.url,{
                method: 'POST',
                headers: new Headers({'Content-Type': 'application/json',
                        'Access-Control-Allow-Origin': '*'}),
                body: JSON.stringify(creLogin),
            }).then(res =>{
                console.log(res);
            });
            if(!res.ok) throw new Error('Fallo de conexion');
            return res.json();
        }
    };

})();