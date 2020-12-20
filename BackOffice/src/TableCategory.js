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

function TableCategory() {


    useEffect(() => {
        setTimeout(() => setLoading(false), 150)
    }, [])


    const [content, setContent] = useState();

    const [rerender, setRerender] = useState(false);

    const [loading, setLoading] = useState(true)


    var url = 'http://localhost:8080/table-category/list'


    useEffect(() => {
        fetch(url)
            .then(response => response.json())
            .then(data => {

                setContent(data).then(setLoading(true))
            }).catch(e => {
                console.warn("e : ", e);
            });
    }, []);

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
                onClick={() => history.push('/tablecategoryadd')}>ADD TABLE CATEGORY</Button>



            <br />
            <br />
            <br />




            <table class="table table-dark" size="lg">
                <tr>
                    <th>#</th>
                    <th>Name</th>
                    <th>Table Count</th>

                </tr>

                {

                    content.map(v => {
                        return (

                            <tr>
                                <td>{v.table_category_id}</td>
                                <td><label>{v.name} </label></td>
                                <td><label> {v.count}</label></td>



                                <td><BiEdit /></td>
                                <td><MdDelete></MdDelete></td>
                            </tr>




                        )

                    })

                }
            </table>






        </div>





    )



} export default TableCategory