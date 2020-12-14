import axios from 'axios';
// Se crea instancia http con valores default
export const http = axios.create( {
    baseURL: 'http://localhost:8082/persistence/v1/CambiosAutorizar'
});