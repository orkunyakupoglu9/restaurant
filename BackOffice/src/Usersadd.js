import React, { Component } from "react";
import { InputGroup } from "react-bootstrap"
import { FormControl } from "react-bootstrap"
import axios from 'axios';
import { useState } from 'react';
import { useEffect } from 'react';
import { DropdownButton } from "react-bootstrap";
import { Button } from "react-bootstrap";
import { Dropdown } from "react-bootstrap";
import './App.css';
import { Col } from "react-bootstrap"
import { MdDelete } from 'react-icons/md'
import { BiEdit } from "react-icons/bi";
import history from "./history"
import DropdownItem from "react-bootstrap/esm/DropdownItem";
import { Form } from "react-bootstrap"

function UsersAdd() {

    const [roleList, setRoleList] = useState([]);

    const [role, setRole] = useState();

    const [roleName, setRoleName] = useState();

    const [roles, setRoles] = useState([]);


    const chooserole = async (role) => {

        let sendRoles = [...roles, role];

        await setRoles(sendRoles);


        //setRole(role);
        setRoleName(role.name);

    }



    const AddUser = (usernamee, passwordd, rolee) => {

        let roleids = [];
        //alert(categoryy)
        for (var i = 0; i < rolee.length; i++) {

            roleids.push(rolee[i].role_id);
            alert(rolee[i].role_id)

        }


        // POST request using fetch with set headers
        const user = {
            username: usernamee, password: passwordd, enabled: true, role: rolee,
            roles_id: roleids
        };


        const token = sessionStorage.getItem("token");



        axios.post('http://localhost:8080/users/add', user, {
            headers:
            {

                'Authorization': `Basic ${token}`


            }

        });



        history.push('/users')

    }


    const handleDelete = (v) => {




        fetch('http://localhost:8080/users/delete/' + v.username, { method: 'DELETE' })

    }

    useEffect(() => {



        var requestOptions = {

            method: "GET",
            redirect: "follow"

        };

        fetch("http://localhost:8080/users/roles-list", requestOptions)
            .then(response => response.text())
            .then(result => setRoleList(JSON.parse(result)))
            .catch(error => console.log("error", error));
    }, [])







    return (

        <div id="inputform">

            <br />

            <div >
                <InputGroup.Text
                >Username:</InputGroup.Text></div>

            <InputGroup size="default" className="mb-3" >

                <FormControl classname="inputs" id="username" class="col-xs-3" />

            </InputGroup>


            <div > <InputGroup.Text > Password:</InputGroup.Text>
            </div>

            <InputGroup size="default" className="mb-3" >
                <FormControl classname="inputs"
                    id="password" />

            </InputGroup>



            <Form.Group controlId="exampleForm.ControlSelect2">


                <InputGroup.Text>Roles:</InputGroup.Text>

                <Form.Control id="catego" as="select" multiple>
                    {

                        roleList.map(r => {
                            return (




                                <option as="button" onClick
                                    ={() => chooserole(r)}>{r.name}
                                </option>


                            )

                        })
                    }


                </Form.Control>
            </Form.Group>



            <br />



            <Button id="submit" onClick={() =>
                AddUser(document.getElementById("username").value,
                    document.getElementById("password").value,
                    roles)
            }>
                Submit</Button>


        </div>



    )



} export default UsersAdd