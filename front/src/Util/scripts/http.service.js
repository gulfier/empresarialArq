import axios from 'axios';
// Se crea instancia http con valores default

export const http = axios.create( {
    timeout: 1000,
    headers: {'X-FORWARDED-FOR': '192.168.1.180'}
});