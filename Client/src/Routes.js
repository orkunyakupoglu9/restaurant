import React, { Component } from "react";
import { Router, Switch, Route } from "react-router-dom";
import app from "./App"
import tables from "./Tables"
import menu from "./Menu"
import login from "./Login"
import home from "./Home"
import media from "./Media"

import history from './history';


export default class Routes extends Component {
    render() {
        return (

            <Router history={history}>
                <Switch>
                    <Route path="/home" component={home} />
                    <Route exact path="/" component={login} />
                    <Route path="/cart" component={app} />
                    <Route path="/tables" component={tables} />
                    <Route path="/menu" component={menu} />
                    <Route path="/media" component={media} />



                </Switch>
            </Router>
        )
    }
}