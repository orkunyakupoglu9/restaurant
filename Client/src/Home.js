import './App.css';
import { useState } from 'react';
import { useEffect } from 'react';
import axios from 'axios';
import { Form } from "react-bootstrap"
import "bootstrap/dist/css/bootstrap.min.css";
import { Tab } from "react-bootstrap"
import { ListGroup } from "react-bootstrap"
import { Button } from "react-bootstrap"
import React, { Component } from 'react';
import { Table } from "react-bootstrap"
import { CardGroup } from "react-bootstrap"
import { CardDeck } from "react-bootstrap"
import { BiMenu } from "react-icons/bi";
import { Card } from 'react-bootstrap'
import { Col } from 'react-bootstrap'
import { Row } from 'react-bootstrap'
import history from "./history"

const Title = () => {

    return (
      <div className="Title" >
  
        Client
  
      </div>
  
    )
  
  }

  


function Home() {




    return (
      <div> 
        
        <div class="Home">

            <Title />


            <BiMenu onClick={() => history.push('/menu')}></BiMenu>

            </div>




        </div>


    )


} export default Home