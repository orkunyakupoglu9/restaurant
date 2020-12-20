import React, { Component } from "react";
import { InputGroup } from "react-bootstrap"
import { FormControl } from "react-bootstrap"
import axios from 'axios';
import { useState } from 'react';
import { useEffect } from 'react';
import { Button } from "react-bootstrap";
import { Table } from "react-bootstrap"
import './App.css';
import { Col } from "react-bootstrap"
import { MdDelete } from 'react-icons/md'
import { BiEdit } from "react-icons/bi";
import history from "./history"



const AddUser = (usernamee, passwordd) => {


    // POST request using fetch with set headers
    const user = { username: usernamee, password: passwordd, enabled: true };
    axios.post('http://localhost:8080/users/add', user)

}


const handleDelete = (v) => {




    fetch('http://localhost:8080/users/delete/' + v.user_id, { method: 'DELETE' })

}




function Users() {

    const [content, setContent] = useState();

    const [loading, setLoading] = useState(true)

    const [rerender, setRerender] = useState(false);

    var username = localStorage.getItem("localusername")
    var password = localStorage.getItem("localpassword")



    useEffect(() => {
        setTimeout(() => setLoading(false), 150)
    }, [])


    var url = 'http://localhost:8080/users/list'


    useEffect(() => {
        fetch(url)
            .then(response => response.json())
            .then(data => {

                setContent(data);
            }).then(setRerender(true)).then(setLoading(true))
            .catch(e => {
                console.warn("e : ", e);
            });

    }, [rerender]);

    if (!content) {
        return null;
    }



    return (



        <div id="wow">

            <view>
                {loading == true ? <div id="loading"> </div> : null}
            </view>


            <br />
            <br />


            <Button id="catadd" size="sm" variant="outline-success"
                onClick={() => history.push('/usersadd')}>ADD USER</Button>


            <br />
            <br />
            <br />


            <Table Table striped bordered hover size="sm" variant="dark" >
                <tr>
                    <th>Username</th>
                    <th>Password</th>
                    <th>Roles</th>

                </tr>

                {

                    content.map(v => {

                        return (

                            <tr>
                                <td>{v.username}</td>
                                <td><label>{v.password} </label></td>
                                <td>{v.roles[0].name},{v.roles.length > 1 ? v.roles[1].name : null
                                }
                                </td>



                                <td><BiEdit /> <MdDelete onClick={() => handleDelete(v)}></MdDelete> </td>

                            </tr>




                        )

                    })

                }
            </Table>




        </div>


    )



} export default Users