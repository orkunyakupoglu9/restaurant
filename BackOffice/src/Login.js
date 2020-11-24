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
import empty from './Empty'






function Login() {




    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");




    function handleSubmit(event) {
        event.preventDefault();
    }




    function handleClick() {


        history.push("/empty");
    }

    localStorage.setItem("localusername", username)
    localStorage.setItem("localpassword", password)






    return (

        <Router>





            <div className="Login">
                <Form onSubmit={handleSubmit}>
                    <Form.Group size="lg" controlId="username">
                        <Form.Label>Username</Form.Label>
                        <Form.Control
                            autoFocus
                            type="text"
                            value={username}
                            onChange={(e) => setUsername(e.target.value)}
                        />
                    </Form.Group>
                    <Form.Group size="lg" controlId="password">
                        <Form.Label>Password</Form.Label>
                        <Form.Control
                            type="password"
                            value={password}
                            onChange={(e) => setPassword(e.target.value)}
                        />
                    </Form.Group>
                    <Button block size="lg" type="submit" component={empty}>
                        Login
        </Button>
                </Form>



            </div>








        </Router>



    );





} export default Login