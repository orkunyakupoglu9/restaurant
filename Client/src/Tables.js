
import './App.css';
import { useState } from 'react';
import { useEffect } from 'react';
import axios from 'axios';
import React from "react"
import "bootstrap/dist/css/bootstrap.min.css";
import { Tab } from "react-bootstrap"
import { ListGroup } from "react-bootstrap"
import { Button } from "react-bootstrap"
import { Component } from 'react';
import { Table } from "react-bootstrap"
import { CardGroup } from "react-bootstrap"
import { BiMenu } from "react-icons/bi";
import { Card } from 'react-bootstrap'
import { Col } from 'react-bootstrap'
import { Row } from 'react-bootstrap'
import { Modal } from 'react-bootstrap'
import { Badge } from 'react-bootstrap'

import history from './history';






function MyVerticallyCenteredModal(props) {

    const [waiterName, setWaiterName] = useState();
    const [waiterId, setWaiterId] = useState();



    const selectwaiter = (t) => {

        localStorage.setItem("selectedwaiterid", t.waiter_id);
        localStorage.setItem("selectedwaitername", t.name);

        setWaiterId(t.waiter_id);
        setWaiterName(t.name);

        history.push('/cart')



    }



    const [waiters, setWaiters] = useState([]);



    var waiterurl = 'http://localhost:8080/waiter/list'

    useEffect(() => {
        fetch(waiterurl)
            .then(response => response.json())
            .then(data => {

                setWaiters(data);
            }).catch(e => {
                console.warn("e : ", e);
            });
    }, [props]);



    return (
        <Modal
            {...props}
            size="lg"
            aria-labelledby="contained-modal-title-vcenter"
            centered
        >
            <Modal.Header closeButton>
                <Modal.Title id="contained-modal-title-vcenter">
                    Please Choose Yourself
          </Modal.Title>
            </Modal.Header>
            <Modal.Body>

                {


                    waiters.map(v => {
                        return (

                            <ListGroup>
                                <br />
                                <ListGroup.Item variant="primary" id="categoryelement"

                                    onClick={() => selectwaiter(v)}>
                                    {v.name + " " + v.surname}

                                </ListGroup.Item>

                                <img width="45" height="30"
                                    src={"data:image/png;base64," + v.media.file_content} />



                            </ListGroup>




                        )

                    })
                }

            </Modal.Body>
            <Modal.Footer>
                <Button onClick={props.onHide}>Close</Button>
            </Modal.Footer>
        </Modal>


    );
}

export const AppContext = React.createContext();


function Tables() {

    const [content, setContent] = useState();
    const [tables, setTables] = useState([]);
    const [tablecategory, setTableCategory] = useState();
    const [tableNumber, setTableNumber] = useState();
    const [tablecategoryid, setTableCategoryid] = useState();


    const [appState, setAppState] = useState({
        table_category: tablecategory,
        table_number: tableNumber
    });



    const [modalShow, setModalShow] = React.useState(false);

    var url = 'http://localhost:8080/table-category/list'


    useEffect(() => {
        fetch(url)
            .then(response => response.json())
            .then(data => {

                setContent(data);
            }).catch(e => {
                console.warn("e : ", e);
            });
    }, []);

    if (!content) {
        return null;
    }


    const showtables = (category) => {

        var url2 = 'http://localhost:8080/table-category/list/table/' + category.table_category_id;

        fetch(url2)
            .then(response => response.json())
            .then(data => {

                setTables(data);
            }).catch(e => {
                console.warn("e : ", e);
            });


        setTableCategory(category)
        setTableCategoryid(category.table_category_id)
        setTableNumber(category.table_number)




    }

    const selecttable = (t) => {


        setModalShow(true)



        //localStorage.setItem("selectedtablecategory", tablecategoryid);
        localStorage.setItem("selectedtableid", t.table_id);
        localStorage.setItem("selectedtablenumber", t.table_number);
        localStorage.setItem("selectedtablecategory", tablecategory.name);




    }


    const tableitem = (t) => {

        if (localStorage.getItem(t) != null) {
            var cartt = JSON.parse(localStorage.getItem(t));

            let productnumm = cartt.productnum;
            return productnumm;

        }



    }



    return (
        <AppContext.Provider
            value={{
                appState: appState, setAppState: setAppState
            }}>
            <div>
                <Row >
                    <CardGroup >
                        {
                            content.map(a => {

                                return (
                                    <Col xs={6}>
                                        <Card style={{ width: '25rem' }}>
                                            <Button onClick={() => showtables(a)}>
                                                <Card.Body>
                                                    <Card.Title>{a.name}</Card.Title>

                                                </Card.Body>
                                            </Button>
                                        </Card>
                                    </Col>
                                )
                            })
                        }
                    </CardGroup>
                </Row>

                <br />
                <br />
                <br />

                <MyVerticallyCenteredModal
                    show={modalShow}
                    onHide={() => setModalShow(false)}
                />




                <Row >
                    <CardGroup>

                        {

                            tables.map(t => {


                                return (


                                    <Col xs={3}>


                                        <Card style={{ width: '10rem' }}>
                                            <Button onClick={() => selecttable(t)} >

                                                <Badge variant="danger">

                                                    {tableitem(t.table_id)}</Badge>
                                                <Card.Body >
                                                    <Card.Title>{t.table_number}</Card.Title>
                                                </Card.Body>
                                            </Button>
                                        </Card>
                                    </Col>
                                )
                            })
                        }

                    </CardGroup>
                </Row>






            </div>

        </AppContext.Provider>

    )



} export default Tables