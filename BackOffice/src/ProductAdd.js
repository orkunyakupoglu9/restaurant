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


function ProductAdd() {


    const [imageList, setImageList] = useState([]);

    const [imageName, setImageName] = useState();

    const [image, setImage] = useState();



    useEffect(() => {



        var requestOptions = {

            method: "GET",
            redirect: "follow"

        };

        fetch("http://localhost:8080/file/list", requestOptions)
            .then(response => response.text())
            .then(result => setImageList(JSON.parse(result)))
            .catch(error => console.log("error", error));
    }, []);


    const chooseimage = async (image) => {


        await setImage(image);
        setImageName(image.name);

    }



    const [contentcategory, setContentCategory] = useState([])

    const [categories, setCategories] = useState([]);

    const [categoryname, setcategoryname] = useState();


    const [rerender, setRerender] = useState(false);

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

    const AddButton = (namee, descriptionn, pricee, categoryy, imagee) => {


        let categoryids = [];
        //alert(categoryy)
        for (var i = 0; i < categoryy.length; i++) {

            categoryids.push(categoryy[i].category_id);
            alert(categoryy[i].category_id)

        }


        const product = {
            name: namee, description: descriptionn, price: pricee,
            category_id: categoryids, media_id: image.media_id, media: image
        };


        const token = sessionStorage.getItem("token");

        axios.post('http://localhost:8080/category/add-product', product, {
            headers:
            {

                'Authorization': `Basic ${token}`


            }

        })
            .then(r => { setRerender(!rerender) });



        history.push('/products')

    }

    const choosecategory = async (c) => {


        let sendCategories = [...categories, c];

        await setCategories(sendCategories);
        setcategoryname(c.name)

        //alert(document.getElementById("catego").value)
        //alert(categories);


    }





    return (

        <div id="inputform">

            <br />



            <div >
                <InputGroup.Text
                >Product Name:</InputGroup.Text></div>

            <InputGroup size="default" className="mb-3" >

                <FormControl classname="inputs" id="name" class="col-xs-3" />

            </InputGroup>


            <div > <InputGroup.Text >  Description:</InputGroup.Text>
            </div>

            <InputGroup size="default" className="mb-3" >
                <FormControl classname="inputs"
                    id="description" />

            </InputGroup>


            <InputGroup.Text >Price:</InputGroup.Text>

            <InputGroup size="default" className="mb-3" >
                <FormControl classname="inputs" id="price" />



                <br />


            </InputGroup>
            <Form.Group controlId="exampleForm.ControlSelect2">
                <InputGroup.Text>Categories:</InputGroup.Text>
                <Form.Control id="catego" as="select" multiple>

                    {
                        contentcategory.map(c => {
                            return (


                                <option as="button" onClick
                                    ={() => choosecategory(c)}>{c.name}</option>
                            )
                        })
                    }

                </Form.Control>
            </Form.Group>



            <br />

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







            <Button id="submit" onClick={() =>
                AddButton(document.getElementById("name").value,
                    document.getElementById("description").value,
                    parseInt(document.getElementById("price").value), categories, image)}>
                Submit</Button>





        </div>





    )




} export default ProductAdd