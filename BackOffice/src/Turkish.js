import React from "react";
import { useContext } from "react";
import { AppContext } from "./App.js"


const Turkish = () => {

    const context = useContext(AppContext);

    const navigate = () => {

        let appState = Object.assign({}, context.appState);
        appState.screen = "English"
        appState.language = "ENG";
        appState.currency = "USD";
        context.setAppState(appState);
    }

    return (

        <div>
            Turkish...<br />
            {context.appState.language}<br />
            {context.appState.currency}<br />
            <button onClick={() => navigate()}>Go to English</button>


        </div>


    )

}
export default Turkish;