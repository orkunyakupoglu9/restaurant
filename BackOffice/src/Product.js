import React, { Component } from "react";
import { InputGroup } from "react-bootstrap"
import { FormControl } from "react-bootstrap"
import { useState } from 'react';
import { useEffect } from 'react';
import axios from 'axios';
import { Button } from "react-bootstrap";
import './App.css';
import { Col } from "react-bootstrap"
import { MdDelete } from 'react-icons/md'
import { BiEdit } from "react-icons/bi";
import { DropdownButton } from "react-bootstrap"
import { Dropdown } from "react-bootstrap"



function Products() {




    var username = localStorage.getItem("localusername");
    var password = localStorage.getItem("localpassword");


    const token = Buffer.from(`${username}:${password}`, 'utf8').toString('base64');



    const [contentcategory, setContentCategory] = useState([])

    var urlcategory = 'http://localhost:8080/category/list'


    useEffect(() => {
        fetch(urlcategory)
            .then(response => response.json())
            .then(data => {

                setContentCategory(data);
            }).catch(e => {
                console.warn("e : ", e);
            });
    }, []);





    const [content, setContent] = useState();

    //const [categories, setCategories] = useState();

    const [description, setDescription] = useState();

    const [category, setcategory] = useState();

    const [categoryname, setcategoryname] = useState();


    const AddButton = (namee, descriptionn, pricee, categoryy) => {


        //alert(token)
        // POST request using fetch with set headers
        const product = { name: namee, description: descriptionn, price: pricee };

        //const category = { category_id: categoryy, description: "aaaaaaa" }
        //axios.post('http://localhost:8080/product/add', product)
        axios.post('http://localhost:8080/category/add-product/' + categoryy, product)

    }

    const openinput = () => {

        return (

            <div className="Title">
                SA</div>



        )



    }

    const choosecategory = (c) => {


        setcategory(c.category_id)
        setcategoryname(c.name)


    }




    const handleClick = (d) => {


        console.warn(d);
        setDescription(d.description)

    }

    const handleDelete = (v) => {




        fetch('http://localhost:8080/product/' + v.id, { method: 'DELETE' })

    }



    var url = 'http://localhost:8080/product/list'


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




        <div className="Input" >




            <InputGroup size="default" >
                <InputGroup.Prepend >
                    <InputGroup.Text >Product Name:</InputGroup.Text>
                </InputGroup.Prepend>
                <Col xs="auto">
                    <FormControl aria-label="Product Name" id="name" class="col-xs-3" />
                </Col>
            </InputGroup>
            <br />
            <InputGroup className="mb-3">
                <InputGroup.Prepend>
                    <InputGroup.Text>Description:</InputGroup.Text>
                </InputGroup.Prepend>
                <Col xs="auto">
                    <FormControl
                        aria-label="Description" id="description" />
                </Col>
            </InputGroup>

            <InputGroup size="Default">
                <InputGroup.Prepend>
                    <InputGroup.Text >Price:</InputGroup.Text>
                </InputGroup.Prepend>
                <Col xs="auto">
                    <FormControl aria-label="Price" id="price" />
                </Col>
            </InputGroup>
            <br />
            <InputGroup size="Default">
                <InputGroup.Prepend>
                    <InputGroup.Text>Category</InputGroup.Text>
                </InputGroup.Prepend>
                <Col xs="auto">
                    <DropdownButton id="dropdown-item-button" title={categoryname}>
                        {

                            contentcategory.map(c => {
                                return (


                                    <Dropdown.Item as="button" onClick
                                        ={() => choosecategory(c)}>{c.name}</Dropdown.Item>




                                )

                            })

                        }
                    </DropdownButton>

                </Col>
            </InputGroup>

            <br />



            <Button onClick={() =>
                AddButton(document.getElementById("name").value,
                    document.getElementById("description").value,
                    parseInt(document.getElementById("price").value), category)}>
                Submit</Button>


            <br />


            <table class="table table-dark" size="sm">
                <tr>
                    <th>#</th> <th>Name</th>
                    <th>Price</th>
                    <th>Category</th>
                </tr>

                {

                    content.map(v => {
                        return (

                            <tr>
                                <td> {v.id}</td> <td><label onClick={() => handleClick(v)}>{v.name}</label></td>
                                <td><label>{v.price}$ </label></td>

                                <td><label> {categoryname}</label></td>



                                <td><BiEdit /></td>
                                <td><MdDelete onClick={() => handleDelete(v)}> </MdDelete></td>
                            </tr>




                        )

                    })

                }
            </table>





            {description}

            <br />






        </div>


    )





} export default Products