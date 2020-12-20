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



function Media() {

    const [selectedFile, setSelectedFile] = useState();
    const [imageList, setImageList] = useState([]);


    const onImageChange = event => {

        if (event.target.files && event.target.files[0]) {
            setSelectedFile(event.target.files[0]);
        }


    }

    const add = () => {


        const data = new FormData();
        data.append('file', selectedFile);
        data.append('imageName', document.getElementById("image").value);



        fetch("http://localhost:8080/file/add", {

            method: "POST",
            mode: "no-cors",
            body: data
        }).then(response => response.text()).
            then(result => console.warn(result)).
            catch(error => console.warn(error));


        alert("File Saved")


    }

    const onFileUpload = () => {

        if (!selectedFile) {

            alert("no file selected")
        }

        return;

    }

    useEffect(() => {

        var requestOptions = {

            method: "GET",
            redirect: "follow"

        };

        fetch("http://localhost:8080/file/list", requestOptions)
            .then(response => response.text())
            .then(result => setImageList(JSON.parse(result)))
            .catch(error => console.log("error", error));
    }, [selectedFile])








    return (
        <div>
            <input type="text" name="imageName" id="image"></input>
            <input type="file" name="file" onChange={(e) => onImageChange(e)} />
            <Button onClick={() => add()}>Save</Button>



        </div>




    )


} export default Media