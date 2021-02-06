import {http} from '../Util/scripts/http.service';

const TOKEN = 'Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJndWlsbGVybW8uc2VndXJhQGF4aXR5LmNvbSIsImF1ZCI6IkludGVyZmF6Ok1lZ2EvUmVtZWR5Iiwic2NwIjoiYXBpL3BlcnNpc3RlbmNlIiwiaXNzIjoiaHR0cHM6Ly93d3cucHJvc2FtZXhpY28ubXgvIiwiZXhwIjo2MTYwNzkzNjI2MSwiaWF0IjoxNjA3OTM2MzIxfQ.J_gAk5pwbXjpm6aLF-mBIes66vKvpLIBWMZsoFxo6v4';

// const urlBase = 'http://localhost:';
// const urlBaseLogin = "http://loginbk-persistencia.192.168.99.100.nip.io";
const urlBaseLogin = "http://web-prosa.192.168.99.104.nip.io";
// const urlBasePersistence = "http://persistenciacmdb-persistencia.192.168.99.100.nip.io";
const urlBasePersistence = "http://employee-prosa.192.168.99.104.nip.io";
const portPersistence = '';
const portWeb = '';
const baseURL = '/v1';

export function getDataConsola(){
    return http.get(urlBasePersistence+baseURL+'/CambiosAutorizar/',{
        headers: {
            Authorization: TOKEN
        }
       });
}

export function getDataLogin(user, password){
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
