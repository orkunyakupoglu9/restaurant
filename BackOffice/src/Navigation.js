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
import usersadd from "./Users"
import products from "./Product"
import { BrowserRouter as Router } from 'react-router-dom'
import categories from "./Categories"
import info from "./Info"
import categoryadd from "./CategoryAdd"

const Title = () => {

    return (
      <div className="Title">
  
        BackOffice
  
      </div>
  
    )
  
  
  }


function Navigation() {

    return (

        <div classname="App">

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
                            <NavDropdown.Item href="/users">Show</NavDropdown.Item>
                            <NavDropdown.Item href="/users/admin">Admin</NavDropdown.Item>
                            <NavDropdown.Item href="/users/user">User</NavDropdown.Item>
                            
                        </NavDropdown>

                        <NavDropdown title="Tables" id="basic-nav-dropdown">
                            <NavDropdown.Item href="/tablecategory">Add Category</NavDropdown.Item>
                            <NavDropdown.Item href="/addtable">Add Table to Category</NavDropdown.Item>
                            </NavDropdown>

                            <Nav.Link href="/waiters">Waiters</Nav.Link>

                            <Nav.Link href="/media">Media</Nav.Link>



                        

                    </Nav>

                    <Form inline>
                        <Nav.Link href="/info">Info</Nav.Link>
                        <FormControl type="text" placeholder="Search" className="mr-sm-2" />
                        <Button variant="outline-success">Search</Button>
                    </Form>
                </Navbar.Collapse>
            </Navbar>




        </div>


    )



} export default Navigation



