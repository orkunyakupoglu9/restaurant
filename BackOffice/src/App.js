import './App.css';
import React from "react";
import { useState } from 'react';
import { useEffect } from 'react';
import axios from 'axios';

import {
  Route,
  NavLink,
  HashRouter,
  Switch
} from "react-router-dom";
import usersadd from "./Users"
import products from "./Product"
import categories from "./Categories"
import info from "./Info"
import categoryadd from "./CategoryAdd"

import English from "./English"
import Turkish from "./Turkish"


export const AppContext = React.createContext();



const Title = () => {

  return (
    <div className="Title">

      BackOffice

    </div>

  )


}


function App() {

  const [appState, setAppState] = useState({
    language: "ENG",
    currency: "USD",
    screen: "English"
  })


  function getViewByScreen() {

    if (appState.screen == "Turkish") {

      return <Turkish />

    }

    return <English />

  }



  return (

    <AppContext.Provider value={{ appState: appState, setAppState: setAppState }}>
      <div className="App">
        {getViewByScreen()}

      </div >
    </AppContext.Provider>
  );
}

export default App;
