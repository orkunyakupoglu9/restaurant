import './App.css';
import { useState } from 'react';
import { useEffect } from 'react';
import axios from 'axios';
//import "bootstrap/dist/bootstrap.min.css";
import 'bootstrap/dist/css/bootstrap.min.css';
import { Form } from "react-bootstrap"
import { Button } from "react-bootstrap"
import {
    Route,
    NavLink,
    HashRouter,
    Switch
} from "react-router-dom";
import usersadd from "./Users"
import products from "./Product"
import app from "./App"
import { useHistory } from "react-router-dom";
import { withRouter } from 'react-router-dom'
import history from './history';





function Login() {


    const logintoLocal = (username, password) => {

        const token = Buffer.from(`${username}:${password}`, 'utf8').toString('base64');

        sessionStorage.setItem("sessionusername", username)
        sessionStorage.setItem("sessionpassword", password)

        sessionStorage.setItem("token", token);



    }




    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");




    function handleSubmit(event) {
        event.preventDefault();
    }





    localStorage.setItem("localusername", username)
    localStorage.setItem("localpassword", password)





    return (



        <div className="Login">
            <Form>
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
                <Button block size="lg"
                    onClick={() => history.push('/home')} >
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