import {http} from '../Util/scripts/http.service';
import { renderToStaticNodeStream } from 'react-dom/server';

// const urlBase = 'http://localhost:';
// const urlBaseLogin = "http://loginbk-persistencia.192.168.99.100.nip.io";
// const urlBaseLogin = "http://localhost:8085";
const urlBaseLogin =  process.env.REACT_APP_URL_BASE_LOGIN;
// const urlBasePersistence = "http://persistenciacmdb-persistencia.192.168.99.100.nip.io";
// const urlBasePersistence = "http://localhost:8084";
const urlBasePersistence = process.env.REACT_APP_URL_BASE_PERSISTENCE;
const portPersistence = '';
const portWeb = '';
const baseURL = '/v1';

export function getDataHistory(token,typeFilter,fromDate,toDate,page,size){
    console.log("url:",urlBasePersistence);
    return http.get(urlBasePersistence+baseURL+'/CambiosAutorizar/history',{
        headers: {
            Authorization: token,
            type: typeFilter,
            initDate: fromDate,
            endDate: toDate,
            PAGE: page,
            SIZE: size
        }
       });
}

export function getDataConsola(token,page,size){
    console.log("url:",urlBasePersistence);
    return http.get(urlBasePersistence+baseURL+'/CambiosAutorizar/',{
        headers: {
            Authorization: token,
            PAGE: page,
            SIZE: size
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
