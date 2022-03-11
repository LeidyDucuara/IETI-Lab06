import {useState, useEffect} from 'react'

const Task = () => {

	const [task, setTask] = useState('');
	const [error, setError] = useState('');
        
	useEffect(() => {
        const requestOptions = {
            mode: 'cors',
            method: 'GET',
            headers:{'Content-Type': 'application/json'}
        }

		const fetchResource = async() => {
            try{
            let res = await fetch('http://localhost:8080/v1/tasks')
            console.log(res.statusText)
            let data = await res.json()
            setTask(data)
            }catch(error){
                setError(error)
            }
        } 
        fetchResource()
    })
    return (
        <h1>Inicio</h1>
    )
}

export default Task