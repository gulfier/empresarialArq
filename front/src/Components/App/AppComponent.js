import './AppComponent.css';
import React, {useState} from 'react';
import { BrowserRouter, Switch, Route, Redirect } from 'react-router-dom';
import LoginComponent from '../Login/LoginComponent';
import HistoryComponent from '../History/HistoryComponent';
import ConsoleComponent from '../Console/ConsoleComponent';

function App() {

  const [redirect, setRedirect] = React.useState(window.localStorage.getItem("login"));

  function renderRedirect(){
    if (redirect == "true") {
      return <Redirect
            from="/"
            to="/history" />;
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
          <Route path='/console' component={ConsoleComponent} />
          <Route path='/history' component={HistoryComponent} />
        </Switch>
      </div>
    </BrowserRouter>
  );
}

export default App;
