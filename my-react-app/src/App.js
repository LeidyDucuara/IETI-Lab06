import './App.css';
import {BrowserRouter as Router,Routes, Route} from 'react-router-dom';
import Login from './components/Login';
import Inicio from './components/Inicio';

const a = 0;

function App() {
  return (
    <Router>
      <Routes>
        <Route exact path = '/' element = {<Login/>}/>
        <Route exact path = '/inicio' element = {<Inicio/>}/>
      </Routes>
    </Router>
  );
}

export default App;
