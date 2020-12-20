import React from "react";
import App from "./App";
import { AppContext } from "./App"

export default class English extends React.Component {

    navigateToHome = (context) => {
        let appState = Object.assign({}, context.appState);
        appState.screen = "Turkish"
        appState.language = "TUR";
        appState.currency = "TRY"

        context.setAppState(appState)
    }

    render() {
        return (

            <AppContext.Consumer>
                {

                    (context) => {
                        return (
                            <div>
                                English...<br />
                                {context.appState.language}<br />
                                {context.appState.currency}<br />
                                <button onClick={() => this.navigateToHome(context)}>Go to Turkish</button>

                            </div>


                        )

                    }



                }
            </AppContext.Consumer>


        )


    }

}