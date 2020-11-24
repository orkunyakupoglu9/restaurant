import logo from './logo.svg';
import './App.css';
import { useState } from 'react';
import { useEffect } from 'react';
import axios from 'axios';

import "bootstrap/dist/css/bootstrap.min.css";
import { Tab } from "react-bootstrap"
import { ListGroup } from "react-bootstrap"
import Cart from './Cart'
import { Button } from "react-bootstrap"
import React, { Component } from 'react';
import { Table } from "react-bootstrap"
import { CardGroup } from "react-bootstrap"
import { CardDeck } from "react-bootstrap"
import { BiMenu } from "react-icons/bi";
import { Card } from 'react-bootstrap'
import { Col } from 'react-bootstrap'
import { Row } from 'react-bootstrap'





const Title = () => {

  return (
    <div className="Title" >

      Client

    </div>

  )

}





function App() {




  // const [cartname, setcartname] = useState();

  // const [cartprice, setcartprice] = useState();



  const [contentt, setContentt] = useState([]);

  const [cart, setcart] = useState([]);

  const [cartTotal, setCartTotal] = useState(0);

  const [count, setCount] = useState(1);

  const [ordersName, setOrdersName] = useState([]);




  const total = (el) => {

    let totalVal = el.price;

    for (let i = 0; i < cart.length; i++) {
      totalVal += cart[i].price
    }
    setCartTotal(totalVal)

  }

  const increaseItem = (el) => {

    total(el);
    setCount(count + 1)


  }




  const addCart = (el) => {


    //setCount(count + 1)

    setcart([...cart, el])

    total(el);

    setOrdersName(...ordersName, el.name)





    console.log(cart)

    /*setcartname(a);
    setcartprice(b);*/


  }

  const deleteItem = (a) => {

    setCount(count - 1)

    setCartTotal(cartTotal - a.price)

    let hardcopy = [...cart]
    hardcopy = hardcopy.filter(cart => cart.id != a.id)
    setcart(hardcopy)



  }

  const sendCart = (a, b) => {



    let order_name;


    for (let i = 0; i < b.size; i++) {

      order_name = b[i] + ","



    }

    alert("hello")




    const order = { orders_name: b, total_price: a, payment_type: 'cash' };
    axios.post('http://localhost:8080/order/add', order)


  }






  const [content, setContent] = useState();

  var url = 'http://localhost:8080/category/list'


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



  return (

    <div className="App">

      <Title />



      <BiMenu />






      {
        content.map(v => {
          return (

            <div class="container-fluid">
              <div class="row justify-content-left">


                <ListGroup>
                  <ListGroup.Item action onClick={() =>

                    fetch('http://localhost:8080/category/product/' + v.category_id)
                      .then(response => response.json())
                      .then(data => {
                        setContentt(data);
                      }).catch(e => {
                        console.warn("e : ", e);
                      })}>
                    {v.name}

                  </ListGroup.Item>

                </ListGroup>

              </div>
            </div>


          )


        })
      }

      <Cart />



      <table size="sm" align="right">
        <tr>
          <th>Name</th>
          <th>Price</th>
          <th>Total:{cartTotal}$</th>
          <td><Button onClick={() => sendCart(cartTotal, ordersName)}>Pay</Button></td>

        </tr>

        {
          cart.map(c => {

            return (


              <tr>



                <th>{c.name}</th>
                <th>{c.price}$</th>
                <th><Button onClick={() => increaseItem(c)}>+</Button>
                  <label>{count}</label>
                  <Button onClick={() => deleteItem(c)}>-</Button></th>
                <th></th>

              </tr>

            )

          })


        }

      </table>






      <Row className="justify-content-md-center">
        <CardGroup >




          {
            contentt.map(a => {




              return (


                <Col xs={6}>

                  <Card style={{ width: '20rem' }}>
                    <Card.Img variant="top" src="https://blog.n11.com/wp-content/uploads/2014/11/yemek-fotografi-kompozisyonu.jpg" />
                    <Card.Body>
                      <Card.Title>{a.name}</Card.Title>
                      <Card.Subtitle>{a.category}</Card.Subtitle>
                      <br />
                      <Card.Subtitle>{a.price}$</Card.Subtitle>

                      <Card.Text>
                        {a.description}
                      </Card.Text>

                    </Card.Body>
                    <Button onClick={() => addCart(a)}>
                      ADD</Button>
                  </Card>

                </Col>

              )



            })

          }



        </CardGroup>
      </Row>







    </div >
  );
}

export default App;
