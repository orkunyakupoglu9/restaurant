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
import { Table } from "react-bootstrap"
import {
    Route,
    NavLink,
    HashRouter,
    Switch
} from "react-router-dom";
import usersadd from "./Users"
import products from "./Product"
import { BrowserRouter as Router } from 'react-router-dom'
import app from "./App"
import categories from './Categories'


function Info() {

    const [content, setContent] = useState([]);

    const [profile, setProfile] = useState();

    var url = "http://localhost:8080/info/server"


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

    var url2 = "http://localhost:8080/info/mode"


    fetch(url)
        .then(response => response.json())
        .then(data => {

            setProfile(data);
        }).catch(e => {
            console.warn("e : ", e);
        });








    return (

        <div>

            <title>{profile}</title>





            <Table>


                <tr>
                    <th> Profile</th>

                    <th> Server</th>

                    <th> Driver</th>

                    <th> DDL-AUTO</th>

                    <th> DataSourceUrl</th>

                    <th> HibernateType</th>
                </tr>


                <tr>
                    {

                        content.map(v => {
                            return (

                                <td> {v}</td>


                            )

                        })



                    }


                </tr>

            </Table>










        </div>




    );




} export default Info