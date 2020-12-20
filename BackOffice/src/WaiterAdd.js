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

function WaiterAdd() {


    const [imageList, setImageList] = useState([]);

    const [image, setImage] = useState();

    const [imageName, setImageName] = useState();


    const [rerender, setRerender] = useState(false);



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





    const chooseimage = (image) => {


        setImage(image);
        setImageName(image.name);

    }




    const addWaiter = (namee, surnamee, image) => {

        const waiter = { name: namee, surname: surnamee, media_id: image.media_id, media: image };
        //axios.post('http://localhost:8080/product/add', product)

        const token = sessionStorage.getItem("token");

        axios.post('http://localhost:8080/waiter/add', waiter, {
            headers:
            {

                'Authorization': `Basic ${token}`


            }

        });



        history.push('/waiters')


    }



    return (


        <div id="inputform">

            <br />


            <div >
                <InputGroup.Text
                > Name:</InputGroup.Text></div>

            <InputGroup size="default" className="mb-3" >

                <FormControl classname="inputs" id="wname" class="col-xs-3" />

            </InputGroup>




            <div > <InputGroup.Text >  Surname:</InputGroup.Text>
            </div>

            <InputGroup size="default" className="mb-3" >
                <FormControl classname="inputs"
                    id="wsurname" />

            </InputGroup>


            <InputGroup size="Default" className="mb-3">

                <InputGroup.Text>Set Image:</InputGroup.Text>

                <DropdownButton variant="secondary" id="dropdown-item-button" title={imageName}>
                    {

                        imageList.map(im => {
                            return (




                                <Dropdown.Item as="button" onClick
                                    ={() => chooseimage(im)}>{im.name}
                                    <img width="150" height="110" src={"data:image/png;base64," + im.file_content} /></Dropdown.Item>


                            )

                        })
                    }

                </DropdownButton>

            </InputGroup>




            <Button id="submit" onClick={() => addWaiter(document.getElementById("wname").
                value, document.getElementById("wsurname").value, image)}>Submit</Button>


        </div>







    )



} export default WaiterAdd