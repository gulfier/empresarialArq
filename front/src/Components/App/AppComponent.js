import './AppComponent.css';
import React, {useState} from 'react';
import { BrowserRouter, Switch, Route, Redirect } from 'react-router-dom';
import LoginComponent from '../Login/LoginComponent';
import HistoryComponent from '../History/HistoryComponent';
import ConsoleComponent from '../Console/ConsoleComponent';

function App() {

  const [redirect, setRedirect] = React.useState(window.localStorage.getItem("login"));

  function renderRedirect(){
    console.log("este es el redirect: ",redirect);
    // if (redirect == "true") {
    //   return <Redirect
    //         from="/"
    //         to="/console" />;
    // }else{
    //   return <Redirect
    //         from="/"
    //         to="/login" />;
    // }
  }

  return (
    <BrowserRouter>
      <div className="App">
        {renderRedirect()}
        <React.Fragment>
          <Route exact path='/login' component={LoginComponent} />
          <Route exact path='/console' component={ConsoleComponent} />
          <Route exact path='/history' component={HistoryComponent} />
        </React.Fragment>
      </div>
    </BrowserRouter>
  );
}

export default App;
