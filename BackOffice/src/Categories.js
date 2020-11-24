import './App.css';
import { useState } from 'react';
import { useEffect } from 'react';
import axios from 'axios';
import { InputGroup } from "react-bootstrap"
import { FormControl } from "react-bootstrap"
import { Form } from "react-bootstrap"
import { Button } from "react-bootstrap"
import { Navbar } from "react-bootstrap"
import { Nav } from "react-bootstrap"
import {
    Route,
    NavLink,
    HashRouter,
    Switch
} from "react-router-dom";
import usersadd from "./Usersadd"
import products from "./Product"
import { BrowserRouter as Router } from 'react-router-dom'
import { Col } from "react-bootstrap"
import { MdDelete } from 'react-icons/md'
import { BiEdit } from "react-icons/bi";





function Categories() {


    const [content, setContent] = useState([]);


    const handleDelete = (v) => {




        fetch('http://localhost:8080/category/delete/' + v.category_id, { method: 'DELETE' })


    }

    const addCategory = (namee, descriptionn, url) => {

        const category = { name: namee, description: descriptionn, image_url: url };
        //axios.post('http://localhost:8080/product/add', product)
        axios.post('http://localhost:8080/category/add-category', category)


    }






    var url = 'http://localhost:8080/category/list'




    useEffect(() => {
        fetch(url)
            .then(response => response.json())
            .then(data => {

                setContent(data);
            }).catch(e => {
                console.warn("e : ", e);
            });
    }, []);



    return (

        <div>

            <InputGroup size="default" >
                <InputGroup.Prepend >
                    <InputGroup.Text >Category Name:</InputGroup.Text>
                </InputGroup.Prepend>
                <Col xs="auto">
                    <FormControl aria-label="Category Name" id="cname" class="col-xs-3" />
                </Col>
            </InputGroup>
            <br />
            <InputGroup className="mb-3">
                <InputGroup.Prepend>
                    <InputGroup.Text>  Description:</InputGroup.Text>
                </InputGroup.Prepend>
                <Col xs="auto">
                    <FormControl
                        aria-label=" Category Description" id="cdescription" />
                </Col>
            </InputGroup>

            <InputGroup size="Default">
                <InputGroup.Prepend>
                    <InputGroup.Text >Image Url:</InputGroup.Text>
                </InputGroup.Prepend>
                <Col xs="auto">
                    <FormControl aria-label="Image Url:" id="cimageurl" />
                </Col>
            </InputGroup>
            <br />




            <Button onClick={() => addCategory(document.getElementById("cname").value,
                document.getElementById("cdescription").value,
                document.getElementById("cimageurl").value)}>Submit</Button>


            <br />

            <table class="table table-dark" size="sm">
                <tr>
                    <th>#</th> <th>Name</th>
                    <th>Description</th>

                </tr>


                {

                    content.map(v => {
                        return (

                            <tr>
                                <td> {v.category_id}</td> <td><label
                                >{v.name}</label></td>
                                <td><label>{v.description} </label></td>




                                <td><BiEdit /></td>
                                <td><MdDelete onClick={() => handleDelete(v)}></MdDelete></td>
                            </tr>


                        )

                    })

                }

            </table>










        </div>



    )



} export default Categories