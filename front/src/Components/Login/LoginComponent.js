import '../../Util/css/LoginComponent.css';
import React, {useEffect, useState} from 'react';
import { connect } from 'react-redux';
import { getToken } from "../../Actions/LoginAction";
import { Redirect } from 'react-router-dom';

function LoginComponent(props) {

  const [dataLogin, setData] = useState({
    user: '',
    password: ''
  });

  useEffect(() => {
  },[]);

  const handleInputChange = (event) => {
    // console.log(event.target.name)
    // console.log(event.target.value)
    setData({
        ...dataLogin,
        [event.target.name] : event.target.value
    })
}

  function login(){
    console.log("Se envio peticion con: ",dataLogin.user,dataLogin.password);
    props.getToken(dataLogin.user,dataLogin.password);
  }

  return (
    <div className="Login d-flex align-items-center justify-content-center">
      {props.token.response.token!==null && <Redirect to="/console"/>}
      <div className="card">
        <div className="card-body">
          <h5 className="card-title">Login</h5>
          <p className="card-text">Hopedy</p>
          <card>
            <div className="form-group">
              <label for="exampleInputEmail1">Nombre de usuario</label>
              <input type="text" className="form-control" id="exampleInputEmail1" onChange={handleInputChange} name="name" aria-describedby="emailHelp" placeholder=""/>
            </div>
            <div className="form-group">
              <label for="exampleInputPassword1">Contraseña</label>
              <input type="password" className="form-control" id="exampleInputPassword1" onChange={handleInputChange} name="password" placeholder=""/>
            </div>
            <small id="emailHelp" className="form-text text-muted">Ingresar con sus credenciales de PROSA</small>
            <div className="mt-4 d-flex justify-content-end">
              <button className="btn btn-primary" onClick={login}>Inicio</button>
            </div>
          </card>
        </div>
      </div>
    </div>
  );
}

function mapStateToProps (state) {
  console.log("token",state);
  return{
    ...state,
    token: state.login.data
  };
}

export default connect (mapStateToProps, { getToken })( LoginComponent);