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

function Waiter() {

    const [rerender, setRerender] = useState(false);

    const [content, setContent] = useState([]);

    const [loading, setLoading] = useState(true)


    const handleDelete = (v) => {




        fetch('http://localhost:8080/waiter/delete/' + v.waiter_id, { method: 'DELETE' })


    }


    var url = 'http://localhost:8080/waiter/list'



    useEffect(() => {
        fetch(url)
            .then(response => response.json())
            .then(data => {

                setContent(data);
            }).then(setRerender(true)).then(setLoading(false))
            .catch(e => {
                console.warn("e : ", e);
            });
    }, [rerender]);

    console.warn(loading)

    if (!content) {
        return null;
    }




    return (


        <div id="wow">

            <view>
                {loading === true ? <div id="loading"> </div> : null}
            </view>


            <br />
            <br />

            <Button id="catadd" size="sm" variant="outline-success"
                onClick={() => history.push('/waiteradd')}>ADD WAITER</Button>


            <br />
            <br />
            <br />


            <div>

                <Table striped bordered hover size="sm" variant="dark">
                    <tr>
                        <th>Img</th>
                        <th>#</th> <th>Name</th>
                        <th>Surname</th>



                    </tr>


                    {

                        content.map(v => {
                            return (

                                <tr>

                                    <td class="tds"> <img width="45" height="30"
                                        src={"data:image/png;base64," + v.media.file_content} /></td>

                                    <td class="tds"> {v.waiter_id}</td>

                                    <td class="tds">{v.name}</td>

                                    <td class="tds"><label>{v.surname} </label> </td>

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



} export default Waiter