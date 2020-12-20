
import './App.css';
import React, { useCallback } from "react";
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
import { BrowserRouter as Router } from 'react-router-dom'
import history from './history';


export const AppContext = React.createContext();



const logintoLocal = (username, password) => {

    const token = Buffer.from(`${username}:${password}`, 'utf8').toString('base64');

    localStorage.setItem("localusername", username)
    localStorage.setItem("localpassword", password)
    localStorage.setItem("token", token)


}



function Login() {




    const [valid, setValid] = useState();
    const [username, setUsername] = useState();
    const [password, setPassword] = useState();



    const isvalid = () => {


        const user = { username: username, password: password };


        axios.post('http://localhost:8080/login/check', user).
            then(response => setValid(response.data)).catch((error) => {
                console.error(error)
            });


        console.log(valid)



        if (valid === "true") {



            alert("yessss")
            history.push('/menu')

        }

        else if (valid === "false") {

            alert("Sorry not valid credentials")

        }

        else {
            alert("üzgünüm beceremedin")
        }


        /* axios.post('http://localhost:8080/login/check', user)
             .then((res) => {
                 validation = JSON.stringify(res.data);
                 console.log(res.data)
             })
             .catch((error) => {
                 console.error(error)
             })*/


    };




    return (


        <div className="Login">
            <Form>
                <Form.Group size="lg">
                    <Form.Label>Username</Form.Label>
                    <Form.Control
                        autoFocus
                        type="text"
                        onChange={(e) => setUsername(e.target.value)}

                    />
                </Form.Group>

                <Form.Group size="lg">
                    <Form.Label>Password</Form.Label>
                    <Form.Control
                        autoFocus
                        type="password"
                        onChange={(e) => setPassword(e.target.value)}
                    />
                </Form.Group>
                <Button block size="lg" onClick={() => isvalid()}>
                    Login
        </Button>



                <div className="form-actions">
                    <br />
                    <div className="form-check">
                        <input
                            type="checkbox"
                            className="form-check-input"
                            name="checkbox"
                            onClick={() => logintoLocal(username, password)}
                        // required
                        />
                        <label>
                            Remember me
                    </label>
                    </div>
                </div>

            </Form>
        </div>



    );





} export default Login