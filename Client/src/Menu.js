
import './App.css';
import { useState } from 'react';
import { useEffect } from 'react';
import axios from 'axios';
//import "bootstrap/dist/bootstrap.min.css";
import 'bootstrap/dist/css/bootstrap.min.css';
import { BsTrash } from "react-icons/bs";
import { InputGroup } from "react-bootstrap"
import { FormControl } from "react-bootstrap"
import { Form } from "react-bootstrap"
import { Button } from "react-bootstrap"
import { Navbar } from "react-bootstrap"
import { Nav } from "react-bootstrap"
import { NavDropdown } from "react-bootstrap"
import {
    Route,
    NavLink,
    HashRouter,
    Switch
} from "react-router-dom";
import { BrowserRouter as Router } from 'react-router-dom'
import { Card } from "react-bootstrap"
import { Col } from "react-bootstrap"
import { Row } from "react-bootstrap"
import { CardGroup } from "react-bootstrap"
import { Link } from 'react-router-dom';

import history from './history';





function Menu() {



    return (

        <div class="Menu">

            <br />
            <br />
            <br />


            <Row className="justify-content-md-center">
                <CardGroup >


                    <Col xs={6}>

                        <Card style={{ width: '30rem' }}>



                            <Button onClick={() => history.push('/cart')}>

                                <Card.Body>
                                    <Card.Title>CART</Card.Title>


                                </Card.Body>
                            </Button>



                        </Card>
                        <br />

                        <Card style={{ width: '30rem' }}>
                            <Button onClick={() => history.push('/tables')}>

                                <Card.Body>
                                    <Card.Title>TABLES</Card.Title>


                                </Card.Body>
                            </Button>

                        </Card>
                        <br />
                        <Card style={{ width: '30rem' }}>

                            <Button>

                                <Card.Body>
                                    <Card.Title>REPORTS</Card.Title>


                                </Card.Body>
                            </Button>

                        </Card>
                        <br />
                        <Card style={{ width: '30rem' }}>

                            <Button>

                                <Card.Body>
                                    <Card.Title>PRODUCTS</Card.Title>


                                </Card.Body>
                            </Button>

                        </Card>


                        <br />
                        <Card style={{ width: '30rem' }}>
                            <Button>

                                <Card.Body>
                                    <Card.Title>USERS</Card.Title>


                                </Card.Body>
                            </Button>

                        </Card>

                        <br />
                        <Card style={{ width: '30rem' }}>
                            <Button onClick={() => history.push('/media')}>

                                <Card.Body>
                                    <Card.Title>MEDIA</Card.Title>


                                </Card.Body>
                            </Button>

                        </Card>




                    </Col>


              )



        </CardGroup>
            </Row>



        </div>





    )













} export default Menu