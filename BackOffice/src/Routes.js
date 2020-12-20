import React, { Component } from "react";
import { Router, Switch, Route } from "react-router-dom";
import products from "./Product"
import categories from "./Categories"
import info from "./Info"
import app from "./App"
import categoryadd from "./CategoryAdd"
import productadd from "./ProductAdd"
import users from "./Users"
import usersadd from "./UsersAdd"
import tables from "./Tables"
import tablecategory from "./TableCategory"
import navigation from "./Navigation.js"
import login from "./Login.js"
import tablecategoryadd from "./TableCategoryAdd.js"
import history from './history';
import waiter from "./Waiter.js"
import waiteradd from "./WaiterAdd.js"
import media from "./Media.js"


export default class Routes extends Component {
    render() {
        return (



            <Router history={history}>
                <Switch>

                    <Route exact path="/" component={login} />
                    <Route path="/home" component={app} />
                    <Route path="/products" component={products} />
                    <Route path="/categories" component={categories} />
                    <Route path="/users" component={users} />
                    <Route path="/info" component={info} />
                    <Route path="/categoryadd" component={categoryadd} />
                    <Route path="/productadd" component={productadd} />
                    <Route path="/usersadd" component={usersadd} />
                    <Route path="/addtable" component={tables} />
                    <Route path="/tablecategory" component={tablecategory} />
                    <Route path="/tablecategoryadd" component={tablecategoryadd} />
                    <Route path="/waiters" component={waiter} />
                    <Route path="/waiteradd" component={waiteradd} />
                    <Route path="/media" component={media} />





                </Switch>
            </Router>
        )
    }
}





