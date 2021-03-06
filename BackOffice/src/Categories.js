import './App.css';
import { useState } from 'react';
import { useEffect } from 'react';
import axios from 'axios';
import { InputGroup } from "react-bootstrap"
import { FormControl } from "react-bootstrap"
import { Form } from "react-bootstrap"
import { Button } from "react-bootstrap"
import { Table } from "react-bootstrap"
import { Navbar } from "react-bootstrap"
import { Nav } from "react-bootstrap"
import {
    Route,
    NavLink,
    HashRouter,
    Switch
} from "react-router-dom";
import usersadd from "./Users"
import products from "./Product"
import { BrowserRouter as Router } from 'react-router-dom'
import { Col } from "react-bootstrap"
import { MdDelete } from 'react-icons/md'
import { BiEdit } from "react-icons/bi";
import { BsApp } from 'react-icons/bs';
import history from "./history"




function Categories() {

    const [loading, setLoading] = useState(true)


    const [content, setContent] = useState([]);


    const [rerender, setRerender] = useState(false);




    const handleDelete = (v) => {




        fetch('http://localhost:8080/category/delete/' + v.category_id, { method: 'DELETE' })


    }

    useEffect(() => {
        setTimeout(() => setLoading(false), 150)
    }, [])

    const addCategory = (namee, descriptionn, url) => {

        const category = { name: namee, description: descriptionn, image_url: url };



        const token = sessionStorage.getItem("token");

        axios.post('http://localhost:8080/category/add-category', category, {
            headers:
            {

                'Authorization': `Basic ${token}`


            }

        });


    }



    var url = 'http://localhost:8080/category/list'


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

    console.log(rerender)

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
                onClick={() => history.push('/categoryadd')}>ADD CATEGORY</Button>


            <br />
            <br />
            <br />


            <div>

                <Table striped bordered hover size="sm" variant="dark">
                    <tr>
                        <th>Img</th>
                        <th>#</th> <th>Name</th>
                        <th>Description</th>



                    </tr>


                    {

                        content.map(v => {
                            return (

                                <tr>
                                    <td class="tds"> <img width="45" height="30"
                                        src={"data:image/png;base64," + v.media.file_content} /></td>


                                    <td class="tds"> {v.category_id}</td>

                                    <td class="tds">{v.name}</td>

                                    <td class="tds"><label>{v.description} </label> </td>

                                    <td> <span>  <BiEdit /> <MdDelete
                                        onClick={() => handleDelete(v)}></MdDelete></span></td>


                                </tr>

                            )

                        })

                    }


                </Table>





            </div>


        </div >



    )





} export default Categories