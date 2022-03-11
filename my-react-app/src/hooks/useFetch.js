import {useState, useEffect, useNavigate} from 'react'

const useFetchPost = url => {

	const [token, setToken] = useState(null)
    const [error, setError] = useState(null)
	/*const navigate = useNavigate()*/
	useEffect(() => {
        const requestOptions = {
            method: 'POST',
            headers:{'Contecnt-Type': 'application/jason'},
            body: JSON.stringify({
                "email":"prueba200@gmail.com",
                "password":"1234"
            })
        }

		const fetchResource = async() => {
            try{
            let res = await fetch(url,requestOptions)
            console.log(res.statusText)
            let data = await res.json()
            setToken(data)
            /*navigate("/")*/
            }catch(error){
                setError(error)
            }
        } 
        fetchResource()
    },[url])
    return{token,error}
}

export default useFetchPost