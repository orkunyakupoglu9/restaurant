import React, { Component } from "react";
import { InputGroup } from "react-bootstrap"
import { FormControl } from "react-bootstrap"
import { useState } from 'react';
import { useEffect } from 'react';
import axios from 'axios';
import { Button } from "react-bootstrap";
import { Table } from "react-bootstrap";
import './App.css';
import { Col } from "react-bootstrap"
import { MdDelete } from 'react-icons/md'
import { BiEdit } from "react-icons/bi";
import { DropdownButton } from "react-bootstrap"
import { Dropdown } from "react-bootstrap"
import history from "./history"



function Products() {


    useEffect(() => {
        setTimeout(() => setLoading(false), 150)
    }, [])

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
    const [contentt, setContentt] = useState([]);


    const [loading, setLoading] = useState(true)


    const [description, setDescription] = useState();

    const [category, setcategory] = useState();

    const [categoryname, setcategoryname] = useState();


    const AddButton = (namee, descriptionn, pricee, categoryy) => {


        //alert(token)

        const product = { name: namee, description: descriptionn, price: pricee };


        //axios.post('http://localhost:8080/product/add', product)
        axios.post('http://localhost:8080/category/add-product/' + categoryy, product)

    }



    const choosecategory = (c) => {

        var url = 'http://localhost:8080/category/product/' + c.category_id

        fetch(url)
            .then(response => response.json())
            .then(data => {

                setContentt(data);
            }).catch(e => {
                console.warn("e : ", e);
            });


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


    const [rerender, setRerender] = useState(false);

    var url = 'http://localhost:8080/product/list'


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

    console.warn(rerender)


    return (


        <div id="wow" >

            <view>
                {loading == true ? <div id="loading"> </div> : null}
            </view>

            <br />
            <br />

            <Button id="catadd" size="sm" variant="outline-success"
                onClick={() => history.push('/productadd')}>ADD PRODUCT</Button>


            <br />
            <br />
            <br />


            <Table Table striped bordered hover size="sm" variant="dark">
                <tr>

                    <th> <label>Filter By:</label>

                        <Col xs="auto">
                            <DropdownButton variant="secondary" id="dropdown-item-button" title={categoryname}>
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
                    </th>


                    <th>Name</th>
                    <th>Price</th>
                    <th>Category</th>
                </tr>

                {

                    contentt.map(v => {
                        return (

                            <tr>
                                <td></td>
                                <td><label onClick={() => handleClick(v)}>{v.name}</label></td>
                                <td><label>{v.price}$ </label></td>

                                <td><label>{categoryname}</label></td>


                                <td><BiEdit /> <MdDelete onClick={() => handleDelete(v)}> </MdDelete></td>

                            </tr>




                        )

                    })

                }
            </Table>

            <br />
            <br />



            <Table Table striped bordered hover size="sm" variant="dark" >
                <tr>
                    <th>Img</th>
                    <th>#</th> <th>Name</th>
                    <th>Price</th>

                </tr>

                {

                    content.map(v => {
                        return (

                            <tr>
                                <td><img width="45" height="30"
                                    src={"data:image/png;base64," + v.media.file_content} /></td>
                                <td> {v.id}</td> <td><label onClick={() => handleClick(v)}>{v.name}</label></td>
                                <td><label>{v.price}$ </label></td>





                                <td><BiEdit /> <MdDelete onClick={() => handleDelete(v)}> </MdDelete></td>

                            </tr>




                        )

                    })

                }
            </Table>


            {description}




        </div>


    )


} export default Products