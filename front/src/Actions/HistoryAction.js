import {
    GET_DATA_HISTORY,
    ERROR_REQUEST
} from '../Util/scripts/TipoAcciones';
import { getDataHistory } from '../Services/WebService';

export const getHistory = (token,typeFilter,fromDate,toDate,page,size) => async dispatch => {
    try{
        const res = await getDataHistory(token,typeFilter,fromDate,toDate,page,size);
        dispatch( {
            type: GET_DATA_HISTORY,
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