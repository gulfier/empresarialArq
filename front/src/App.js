import './App.css';
import React, {useState} from 'react';
import { BrowserRouter, Switch, Route, Redirect } from 'react-router-dom';
import LoginComponent from './Components/LoginComponent/LoginComponent';
import ConsoleComponent from './Components/ConsoleComponent/ConsoleComponent';
import Dashboard from './Components/ConsoleComponent/Dashboard';

function App() {

  const [redirect, setRedirect] = React.useState(window.localStorage.getItem("login"));

  function renderRedirect(){
    if (redirect == "true") {
      return <Redirect
            from="/"
            to="/console" />;
    }else{
      return <Redirect
            from="/"
            to="/login" />;
    }
  }

  return (
    <BrowserRouter>
      <div>
        {renderRedirect()}
        <Switch>
          <Route path='/login' component={LoginComponent} />
          <Route path='/console' component={Dashboard} />
        </Switch>
      </div>
    </BrowserRouter>
  );
}

export default App;
