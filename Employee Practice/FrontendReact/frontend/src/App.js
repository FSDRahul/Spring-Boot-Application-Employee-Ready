import logo from './logo.svg';
import './App.css';
import ListEmployeeComponent from './Component/ListEmployeeComponent';
import HeaderComponent from './Component/HeaderComponent';
import FooterComponent from './Component/FooterComponent';
import {BrowserRouter, Route, Routes} from 'react-router-dom'
import EmployeeComponent from './Component/EmployeeComponent';

function App() {
  return (

    <>
      <BrowserRouter>
        <HeaderComponent />
          <Routes>
            <Route path='/' element={<ListEmployeeComponent />}></Route>
            <Route path='/employees' element={<ListEmployeeComponent />}></Route>
            <Route path='/add-employee' element={<EmployeeComponent/>}></Route>
            <Route path='/edit-employee/:id' element={<EmployeeComponent/>}></Route>
          </Routes>        
        <FooterComponent />
      </BrowserRouter>     
    </>
  );
}

export default App;
