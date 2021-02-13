import {
    GET_DATA_CONSOLE,
    ERROR_REQUEST
} from '../Util/scripts/TipoAcciones';
import { getDataConsola } from '../Services/WebService';

export const getDataConsole = (token,page,size) => async dispatch => {
    try{
        const res = await getDataConsola(token,page,size);
        dispatch( {
            type: GET_DATA_CONSOLE,
            payload: res.data
        })
    }
    catch(e){
        dispatch( {
            type: ERROR_REQUEST,
            payload: console.log(e),
        })
    }
}