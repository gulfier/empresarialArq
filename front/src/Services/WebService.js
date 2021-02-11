import {http} from '../Util/scripts/http.service';

// const urlBase = 'http://localhost:';
// const urlBaseLogin = "http://loginbk-persistencia.192.168.99.100.nip.io";
// const urlBaseLogin = "http://web-prosa.192.168.99.104.nip.io";
const urlBaseLogin =  process.env.REACT_APP_URL_BASE_LOGIN;
// const urlBasePersistence = "http://persistenciacmdb-persistencia.192.168.99.100.nip.io";
// const urlBasePersistence = "http://employee-prosa.192.168.99.104.nip.io";
const urlBasePersistence = process.env.REACT_APP_URL_BASE_PERSISTENCE;
const portPersistence = '';
const portWeb = '';
const baseURL = '/v1';

export function getDataConsola(token){
    console.log("url:",urlBasePersistence);
    return http.get(urlBasePersistence+baseURL+'/CambiosAutorizar/',{
        headers: {
            Authorization: token
        }
       });
}

export function getDataLogin(user, password){
    console.log("url login:",process.env);
    console.log("url login:",urlBaseLogin);
    var body = {
        "userName": user,
        "password": password,
        "secret": "ufCwLft4sYsQeXWkHJTR=rCzWS*e!D&7nJc6RUzVb2Ne6w@4*t_$89@WqKRX59Ft",
        "audience": "Interfaz:Mega/Remedy",
        "scope": "api/persistence",
        "issued": "https://www.prosamexico.mx/"
    };
    return http.post(urlBaseLogin+portWeb+baseURL+'/web/login',body,{
       });
}
