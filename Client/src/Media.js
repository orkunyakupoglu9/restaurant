
import './App.css';
import { useState } from 'react';
import { useEffect } from 'react';
import axios from 'axios';
import { InputGroup } from "react-bootstrap"
import "bootstrap/dist/css/bootstrap.min.css";
import { Tab } from "react-bootstrap"

import { ListGroup } from "react-bootstrap"
import { Button } from "react-bootstrap"
import React, { Component } from 'react';
import { CardGroup } from "react-bootstrap"
import { CardDeck } from "react-bootstrap"
import { BiMenu } from "react-icons/bi";
import { Card } from 'react-bootstrap'
import { Col } from 'react-bootstrap'
import { Row } from 'react-bootstrap'
import { Table } from 'react-bootstrap'
import { GiShoppingCart } from "react-icons/gi";
import history from "./history"


function Media() {


    const [imageList, setImageList] = useState([]);

    const [content, setContent] = useState([]);



    /*fetch("http://localhost:8080/file/list")
        .then(response => response.json())
        .then(data => {

            setContent(data);
        }).catch(e => {
            console.warn("e : ", e);
        });


    if (!content) {
        return null;
    }*/



    useEffect(() => {

        var requestOptions = {

            method: "GET",
            redirect: "follow"

        };

        fetch("http://localhost:8080/file/list", requestOptions)
            .then(response => response.text())
            .then(result => setImageList(JSON.parse(result)))
            .catch(error => console.log("error", error));
    }, [])

    let list = [];


    imageList.map(v => {
        list.push(<li>
            <img src={"data:image/png;base64," + v.file_content} />
        </li>)
    })




    return (
        <div>
            <ul>
                {list}
            </ul>





        </div>

    )


} export default Media