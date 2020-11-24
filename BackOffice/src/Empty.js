import './App.css';
import { useState } from 'react';
import { useEffect } from 'react';
import axios from 'axios';
//import "bootstrap/dist/bootstrap.min.css";
import 'bootstrap/dist/css/bootstrap.min.css';
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
import app from "./App"
import { useHistory } from "react-router-dom";
import { withRouter } from 'react-router-dom'
import history from './history';
import login from './Login';
import categories from './Categories'



function Empty() {


    return (

        <div>




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
                        <FormControl type="text" placeholder="Search" className="mr-sm-2" />
                        <Button variant="outline-success">Search</Button>
                    </Form>
                </Navbar.Collapse>
            </Navbar>


            <br />





            <Router>

                <Switch>
                    <Route path="/categories" component={categories} />
                    <Route path="/login" component={login} />
                    <Route path="/home" component={app} />
                    <Route path="/products" component={products} />
                    <Route path="/users/add" component={usersadd} />


                </Switch>




            </Router>


        </div>

    );

} export default Empty