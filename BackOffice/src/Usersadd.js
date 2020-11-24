import React, { Component } from "react";
import { InputGroup } from "react-bootstrap"
import { FormControl } from "react-bootstrap"
import axios from 'axios';
import { useState } from 'react';
import { useEffect } from 'react';
import { Button } from "react-bootstrap";
import './App.css';
import { Col } from "react-bootstrap"
import { MdDelete } from 'react-icons/md'
import { BiEdit } from "react-icons/bi";



const AddUser = (usernamee, passwordd) => {


    // POST request using fetch with set headers
    const user = { username: usernamee, password: passwordd, enabled: true };
    axios.post('http://localhost:8080/users/add', user)

}


const handleDelete = (v) => {




    fetch('http://localhost:8080/users/delete/' + v.username, { method: 'DELETE' })

}




function Usersadd() {

    const [content, setContent] = useState();

    var username = localStorage.getItem("localusername")
    var password = localStorage.getItem("localpassword")





    var url = 'http://localhost:8080/users/list'


    useEffect(() => {
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
    }





    return (
        <div>


            <InputGroup size="Default" className="mb-3">
                <InputGroup.Prepend>
                    <InputGroup.Text>Username:</InputGroup.Text>
                </InputGroup.Prepend>
                <Col xs="auto">
                    <FormControl aria-label="UsserName" id="username" />
                </Col>
            </InputGroup>
            <br />
            <InputGroup className="mb-3">
                <InputGroup.Prepend>
                    <InputGroup.Text>Password:</InputGroup.Text>
                </InputGroup.Prepend>
                <Col xs="auto">
                    <FormControl
                        aria-label="Password" id="password" />
                </Col>
            </InputGroup>
            <br />
            <InputGroup size="Default">
                <InputGroup.Prepend>
                    <InputGroup.Text >Role:</InputGroup.Text>
                </InputGroup.Prepend>
                <Col xs="auto">
                    <FormControl aria-label="Role" id="role" />
                </Col>
            </InputGroup>
            <br />

            <Button onClick={() =>
                AddUser(document.getElementById("username").value,
                    document.getElementById("password").value,
                    document.getElementById("role").value)}>
                Submit</Button>


            <table class="table table-dark" size="sm">
                <tr>
                    <th>Username</th>
                    <th>Password</th>

                </tr>

                {

                    content.map(v => {
                        return (

                            <tr>
                                <td>{v.username}</td>
                                <td><label>{v.password} </label></td>



                                <td><BiEdit /></td>
                                <td><MdDelete onClick={() => handleDelete(v)}></MdDelete></td>
                            </tr>




                        )

                    })

                }
            </table>




        </div>


    )



} export default Usersadd