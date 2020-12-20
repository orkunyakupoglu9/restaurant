
import './App.css';
import { useState } from 'react';
import { useEffect } from 'react';
import axios from 'axios';
import { InputGroup } from "react-bootstrap"
import "bootstrap/dist/css/bootstrap.min.css";
import { Tab } from "react-bootstrap"
import { ListGroup } from "react-bootstrap"
import { Button } from "react-bootstrap"
import { Component } from 'react';
import { CardGroup } from "react-bootstrap"
import { CardDeck } from "react-bootstrap"
import { BiMenu } from "react-icons/bi";
import { Card } from 'react-bootstrap'
import { Col } from 'react-bootstrap'
import { Row } from 'react-bootstrap'
import { Table } from 'react-bootstrap'
import { GiShoppingCart } from "react-icons/gi";
import history from "./history"

import React from "react"
import { useContext } from "react";
import { AppContext } from "./Tables.js"






class TablesCart {

  constructor(productnum, totalprice, products) {
    this.productnum = productnum;
    this.totalprice = totalprice;
    this.products = products;
  }
}


var tableid = localStorage.getItem("selectedtableid");
var tablenum = localStorage.getItem("selectedtablenumber");
var tablecat = localStorage.getItem("selectedtablecategory");


const Title = () => {

  


  return (
    <div className="Title" >

      Client
     
    </div>

  )

}

const ShowTable = () => {

  const context = useContext(AppContext);

  //<p> {context.appState.table_category}{context.appState.table_number}</p>
  
  return (
    <div className="ShowTable" >
      
      <p>{tablecat} {tablenum}</p>

    </div>

  )


}



function  App()  {

const context = useContext(AppContext);




 let productss;
 let recentcarttotal;


  if(localStorage.getItem(tableid)==null)
  {
      productss = [];
      recentcarttotal=0;

  }

      else{

      productss =  JSON.parse(localStorage.getItem(tableid)).products;
      recentcarttotal=JSON.parse(localStorage.getItem(tableid)).totalprice;

      }
     

      

  const [cart, setcart] = useState(productss);

  
  // const [cartprice, setcartprice] = useState();

  const [contentt, setContentt] = useState([]);

  const [cartTotal, setCartTotal] = useState(recentcarttotal);

  const [count, setCount] = useState(1);

  const [ordersName, setOrdersName] = useState([]);

  const[selectedCategory,setSelectedCategory]=useState(1);
  
  const [loading, setLoading] = useState(true);

  const[newTotal,setNewTotal]=useState(0);




  useEffect(() => {
    setTimeout(() => setLoading(false), 200)
  }, [])


  const resetTable = () => {

    localStorage.setItem("selectedtablecategory", "on hand");
    localStorage.setItem("selectedtablenumber", "");

  }


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

  const addCart = async (product) => {

    //setcart([...cart, product])

    let newCart = [...cart, product];

   total(product);

    
    let newtotal=0;

    for (let i = 0; i < newCart.length; i++) {
      newtotal += newCart[i].price
    }


    console.log(product)
    console.log(cart);
    console.log(newtotal)

    
    


    var tableid = localStorage.getItem("selectedtableid");

    const num = newCart.length;
    const totalprice = newtotal;


    const newTablesCart = new TablesCart(num, totalprice, newCart);
    console.log(newTablesCart);


    await localStorage.setItem(tableid, JSON.stringify(newTablesCart));

    setcart(newCart)

  }

  const deleteItem = (a) => {

    setCount(count - 1)

    setCartTotal(cartTotal - a.price)

    let hardcopy = [...cart]
    hardcopy = hardcopy.filter(cart => cart.id != a.id)
    setcart(hardcopy)



  }

  const sendCart = (carttotal, ordersname) => {


    let order_name;


    for (let i = 0; i < ordersname.size; i++) {

      order_name = ordersname[i] + ","


    }

    //var tablecat = localStorage.getItem("selectedtablecategory ");
    var tableid = localStorage.getItem("selectedtableid");
    var waiterid = localStorage.getItem("selectedwaiterid")
    var waiter_name = localStorage.getItem("selectedwaitername")


    alert("table id is: " + tableid)
    alert("order taken by:" + waiter_name + waiterid)

    setcart([]);
    localStorage.removeItem(tableid);




    const order = { orders_name: ordersname, total_price: carttotal,
       payment_type: 'cash', waiter_id: waiterid };
    axios.post('http://localhost:8080/order/add-table-to-order/' + tableid, order)


  }

  useEffect(() => {
    fetch('http://localhost:8080/category/product/' + 1)
      .then(response => response.json())
      .then(data => {

        setContentt(data);
      }).then(setLoading(true)).catch(e => {
        console.warn("e : ", e);
      });
  }, []);

  



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

    <div >
      
      <view>
      {loading == true ? <div id="loading"> </div> : null}
      </view>

      <Row>

        <br />
        <br />

        <Col xs={3} id="categoryheader">
          <div class="headers" >
            <InputGroup.Text class="headers"
            >Categories</InputGroup.Text></div>
            
            <br/>

          <div class="categoryinside">


            {


              content.map(v => {

               
                return (

                  <ListGroup>
                    <br />
                   
                    <div> <ListGroup.Item variant="primary" id="categoryelement"
                    
                      action onClick={() =>

                  
                        fetch('http://localhost:8080/category/product/' + v.category_id)
                          .then(response => response.json())
                          .then(data => {
                            setContentt(data);
                          }).catch(e => {
                            console.warn("e : ", e);
                          })

                          
                         
                          }>
                      <label id="categorynames">{v.name}  </label>

                    </ListGroup.Item>

                    <img id="images" width="60" height="45" 
                      src={"data:image/png;base64," + v.media.file_content} />
                    
                    </div>
                    

                  </ListGroup>




                )

              })
            }

          </div>

        </Col>



        <Col xs={6}  >
          <div class="cards" >
            <InputGroup.Text class="cards"
            >Products</InputGroup.Text></div>

          <br />

          <div class="cardsinside">

            <Row >

              {
                contentt.map(product => {

                  return (


                    <Col xs={6}>
                      <br/>
                      

                      <Card style={{ width: '16rem' }}>
                        <Card.Img variant="top" 
                        src=
                        {"data:image/png;base64," + product.media.file_content} />
                        <Card.Body>
                          <Card.Title>{product.name}</Card.Title>
                          <Card.Subtitle>{product.categories[0].name}</Card.Subtitle>
                          <br />
                          <Card.Subtitle>{product.price}$</Card.Subtitle>

                          <Card.Text>
                            {product.description}
                          </Card.Text>

                        </Card.Body>
                        <Button onClick={() => addCart(product)}>
                          ADD</Button>
                      </Card>

                    </Col>

                  )



                })

              }

            </Row>

          </div>

        </Col>




        <Col xs={3}  >
          <div class="shoppingcart">
            <InputGroup.Text class="shoppingcart"
            >Cart</InputGroup.Text>
            <GiShoppingCart />
            <Button onClick={() => resetTable()}>Reset Table</Button>
            
            

          </div>
          <br/>



          <div id="tablecart">

            <Table size="sm" id="cart">


              <tr>
                <th>Name:</th>
                <th>Price:</th>
                <th><ShowTable /> </th>
              </tr>

              {

                cart.map(c => {

                  return (

                    <tr>

                      <td>{c.name}</td>
                      <td>{c.price}$</td>
                      <td><Button onClick={() => increaseItem(c)}>+</Button>
                        <label>{count}</label>
                        <Button onClick={() => deleteItem(c)}>-</Button></td>

                    </tr>

                  )

                })


              }
              <tr>

                <td></td>
                <th>Total:{cartTotal}$</th>
                <th><Button  variant="danger" onClick={() => sendCart(cartTotal, ordersName)}>Pay</Button></th>


              </tr>

            </Table>



          </div>



        </Col>

      </Row>
    </div >
  );
}

export default App;
