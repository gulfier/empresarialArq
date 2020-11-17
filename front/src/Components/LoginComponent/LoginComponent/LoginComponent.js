import './LoginComponent.css';

function LoginComponent() {
  return (
    <div className="Login d-flex align-items-center justify-content-center">
      <div className="card">
        <div className="card-body">
          <h5 className="card-title">Login</h5>
          <p className="card-text">Hopedy</p>
          <form>
            <div className="form-group">
              <label for="exampleInputEmail1">Nombre de usuario</label>
              <input type="email" className="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder=""/>
            </div>
            <div className="form-group">
              <label for="exampleInputPassword1">Contraseña</label>
              <input type="password" className="form-control" id="exampleInputPassword1" placeholder=""/>
            </div>
            <small id="emailHelp" className="form-text text-muted">Ingresar con sus credenciales de PROSA</small>
            <div className="mt-4 d-flex justify-content-end">
              <button type="submit" className="btn btn-primary">Inicio</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
}

export default LoginComponent;
