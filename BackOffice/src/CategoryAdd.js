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
import { Dropdown } from "react-bootstrap"
import { DropdownButton } from "react-bootstrap"
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
import { Row } from "react-bootstrap"
import { MdDelete } from 'react-icons/md'
import { BiEdit, BiRefresh } from "react-icons/bi";
import history from "./history"


function CategoryAdd() {

    const [rerender, setRerender] = useState(false);

    const [imageList, setImageList] = useState([]);

    const [image, setImage] = useState();

    const [imageName, setImageName] = useState();


    const chooseimage = (image) => {


        setImage(image);
        setImageName(image.name);

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
    }, [])





    const addCategory = (namee, descriptionn, image) => {

        const category = { name: namee, description: descriptionn, media_id: image.media_id, media: image };

        axios.post('http://localhost:8080/category/add-category', category)



        history.push('/categories')


    }

    return (

        <div id="inputform">

            <br />


            <div >
                <InputGroup.Text
                >Category Name:</InputGroup.Text></div>

            <InputGroup size="default" className="mb-3" >

                <FormControl classname="inputs" id="cname" class="col-xs-3" />

            </InputGroup>




            <div > <InputGroup.Text > Description:</InputGroup.Text>
            </div>

            <InputGroup size="default" className="mb-3" >
                <FormControl classname="inputs"
                    id="cdescription" />

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



            <Button id="submit" onClick={() => addCategory(document.getElementById("cname").value,
                document.getElementById("cdescription").value, image)}>Submit</Button>


        </div>




    )




} export default CategoryAdd