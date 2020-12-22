import {http} from '../Util/scripts/http.service';

const TOKEN = 'Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJndWlsbGVybW8uc2VndXJhQGF4aXR5LmNvbSIsImF1ZCI6IkludGVyZmF6Ok1lZ2EvUmVtZWR5Iiwic2NwIjoiYXBpL3BlcnNpc3RlbmNlIiwiaXNzIjoiaHR0cHM6Ly93d3cucHJvc2FtZXhpY28ubXgvIiwiZXhwIjo2MTYwNzkzNjI2MSwiaWF0IjoxNjA3OTM2MzIxfQ.J_gAk5pwbXjpm6aLF-mBIes66vKvpLIBWMZsoFxo6v4';

const urlBase = 'http://localhost:';
const portPersistence = '8082';
const portWeb = '8083';
const baseURL = '/persistence/v1';

export function getDataConsola(){
    return http.get(urlBase+portPersistence+baseURL+'/CambiosAutorizar/',{
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
    return http.post(urlBase+portWeb+baseURL+'/web/login',body,{
       });
}
