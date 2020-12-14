import {
    GET_DATA_CONSOLE,
    TERMINAR_REQUEST
} from '../Util/scripts/TipoAcciones';
import axios from 'axios';
import {http} from '../Util/scripts/http.service';
import { getDataConsola } from '../Services/WebService';

export const showUsers = () => async dispatch => {
    try{
        const res = await getDataConsola();
        dispatch( {
            type: GET_DATA_CONSOLE,
            payload: res.data
        })
    }
    catch(e){
        dispatch( {
            type: TERMINAR_REQUEST,
            payload: console.log(e),
        })
    }
    // return (dispatch, getState) => {
    //     console.log("Entro***********************+");
    //     axios.get('http://localhost:8082/persistence/v1/CambiosAutorizar',{
    //             headers: {
    //                 'X-FORWARDED-FOR': '192.168.1.180',
    //                 Authorization: 'Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJndWlsbGVybW8uc2VndXJhQGF4aXR5LmNvbSIsImF1ZCI6IkludGVyZmF6Ok1lZ2EvUmVtZWR5Iiwic2NwIjoiYXBpL3BlcnNpc3RlbmNlIiwiaXNzIjoiaHR0cHM6Ly93d3cucHJvc2FtZXhpY28ubXgvIiwiZXhwIjoxNjA3OTE2Nzc5LCJpYXQiOjE2MDc5MTY0Nzl9.azKeNJA-1Ntq9we5vNsuc4xILX3vJt0S2TMfGkrdHZM'
    //             }
    //            }).then(response => {
    //             console.log("response",response);
    //             store.dispatch( { type: GET_DATA_CONSOLE, payload: response.data } ) 
    //         }).catch(error => {
    //             console.error(error);
    //         });
    // }
}