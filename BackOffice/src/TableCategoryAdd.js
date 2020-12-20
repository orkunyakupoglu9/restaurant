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
import usersadd from "./Users"
import products from "./Product"
import { BrowserRouter as Router } from 'react-router-dom'
import { Col } from "react-bootstrap"
import { MdDelete } from 'react-icons/md'
import { BiEdit } from "react-icons/bi";
import { DropdownButton } from "react-bootstrap"
import { Dropdown } from "react-bootstrap"
import history from "./history"


function TableCategoryAdd() {

    const token = sessionStorage.getItem("token");


    const AddTableCategory = (namee, countt) => {


        const token = sessionStorage.getItem("token");

        // POST request using fetch with set headers
        const tableCategory = { name: namee, count: countt };
        axios.post('http://localhost:8080/table-category/add-tablecategory', tableCategory, {
            headers:
            {

                'Authorization': `Basic ${token}`


            }

        });

        history.push('/tablecategory')

    }







    return (


        <div id="inputform" >

            <br />

            <div >
                <InputGroup.Text
                >Table Category:</InputGroup.Text></div>

            <InputGroup size="default" className="mb-3" >

                <FormControl classname="inputs" id="tablecategory" class="col-xs-3" />

            </InputGroup>


            <div > <InputGroup.Text >  Count:</InputGroup.Text>
            </div>

            <InputGroup size="default" className="mb-3" >
                <FormControl classname="inputs"
                    id="tablecount" />

            </InputGroup>





            <Button id="submit" onClick={() =>
                AddTableCategory(document.getElementById("tablecategory").value,
                    document.getElementById("tablecount").value)}>Add</Button>



        </div>







    )






} export default TableCategoryAdd