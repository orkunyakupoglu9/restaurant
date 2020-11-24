import logo from './logo.svg';
import './App.css';
import { useState } from 'react';
import { useEffect } from 'react';
import axios from 'axios';
import { BsTrash } from "react-icons/bs";
import { InputGroup } from "react-bootstrap"
import { FormControl } from "react-bootstrap"
import { Form } from "react-bootstrap"
import { Button } from "react-bootstrap"
import { Navbar } from "react-bootstrap"
import { Nav } from "react-bootstrap"
import { NavDropdown } from "react-bootstrap"
import {
  Route,
  NavLink,
  HashRouter,
  Switch
} from "react-router-dom";
import usersadd from "./Usersadd"
import products from "./Product"
import { BrowserRouter as Router } from 'react-router-dom'
import categories from "./Categories"
import info from "./Info"





const Title = () => {

  return (
    <div className="Title">

      BackOffice

    </div>

  )


}



function App() {


  const [content, setContent] = useState();

  const [description, setDescription] = useState();



  const handleClick = (d) => {


    console.warn(d);
    setDescription(d.description)

  }





  var url = 'http://localhost:8080/product/list'


  /* useEffect(() => {
     fetch(url)
       .then(response => response.json())
       .then(data => {
 
         setContent(data);
       }).catch(e => {
         console.warn("e : ", e);
       });
   }, []);
 
   if (!content) {
     return null;
   }*/





  return (
    <div className="App">
      <Title />



      <Navbar bg="light" expand="lg">
        <Navbar.Brand href="/home">HomePage</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="mr-auto">
            <Nav.Link href="/categories">Categories</Nav.Link>
            <Nav.Link href="/products">Products</Nav.Link>
            <Nav.Link href="/reports">Reports</Nav.Link>
            <NavDropdown title="Users" id="basic-nav-dropdown">
              <NavDropdown.Item href="/users/add">Add/Show</NavDropdown.Item>
              <NavDropdown.Item href="/users/admin">Admin</NavDropdown.Item>
              <NavDropdown.Item href="/users/user">User</NavDropdown.Item>



            </NavDropdown>
          </Nav>

          <Form inline>
            <Nav.Link href="/info">Info</Nav.Link>
            <FormControl type="text" placeholder="Search" className="mr-sm-2" />
            <Button variant="outline-success">Search</Button>
          </Form>
        </Navbar.Collapse>
      </Navbar>


      <br />


      <Router>
        <Switch>
          <Route path="/home" component={this} />
          <Route path="/products" component={products} />
          <Route path="/categories" component={categories} />
          <Route path="/users/add" component={usersadd} />
          <Route path="/info" component={info} />
        </Switch>
      </Router>









    </div >
  );
}

export default App;
