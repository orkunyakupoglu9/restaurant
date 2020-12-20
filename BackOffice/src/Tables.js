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
import history from "./history"
import { DropdownButton } from "react-bootstrap"
import { Dropdown } from "react-bootstrap"

function Tables() {

    const [contenttablecategory, setcontenttablecategory] = useState([]);
    const [tablecategory, settablecategory] = useState();
    const [tablecategoryname, settablecategoryname] = useState();


    const choosetablecategory = (c) => {




        settablecategory(c.table_category_id)
        settablecategoryname(c.name)


    }

    const AddTable = (idd, tablecategory) => {


        // POST request using fetch with set headers
        const table = { table_number: idd };


        axios.post('http://localhost:8080/table-category/add-table/' + tablecategory, table)



    }






    var urltablecategory = 'http://localhost:8080/table-category/list'


    useEffect(() => {
        fetch(urltablecategory)
            .then(response => response.json())
            .then(data => {

                setcontenttablecategory(data);
            }).catch(e => {
                console.warn("e : ", e);
            });
    }, []);








    return (

        <div>
            <InputGroup size="Default" className="mb-3">
                <InputGroup.Prepend>
                    <InputGroup.Text>Table Number:</InputGroup.Text>
                </InputGroup.Prepend>
                <Col xs="auto">
                    <FormControl aria-label="TABLEID" id="table_id" />
                </Col>
            </InputGroup>
            <br />

            <InputGroup className="mb-3">
                <InputGroup.Prepend>
                    <InputGroup.Text>Table Category:</InputGroup.Text>
                </InputGroup.Prepend>
                <Col xs="auto">

                    <DropdownButton id="dropdown-item-button" title={tablecategoryname}>
                        {

                            contenttablecategory.map(c => {
                                return (


                                    <Dropdown.Item as="button" onClick
                                        ={() => choosetablecategory(c)}>{c.name}</Dropdown.Item>

                                )

                            })

                        }
                    </DropdownButton>



                </Col>
            </InputGroup>

            <br />

            <Button onClick={() =>
                AddTable(document.getElementById("table_id").value, tablecategory)}>
                Submit</Button>



        </div>


    );






} export default Tables