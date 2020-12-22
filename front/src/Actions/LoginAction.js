import {
    GET_LOGIN,
    ERROR_REQUEST
} from '../Util/scripts/TipoAcciones';
import { getDataLogin } from '../Services/WebService';

export const getToken = (user,password) => async dispatch => {
    try{
        const res = await getDataLogin(user,password);
        if(res.data.code===200){
            console.log("Data:",res.data);
            window.localStorage.setItem("token",res.data.response.token);
            window.localStorage.setItem("login",true);
            dispatch( {
                type: GET_LOGIN,
                payload: res.data
            })
        }else{
            console.log("Error al ingresar");
            dispatch( {
                type: ERROR_REQUEST,
                payload: console.log(res.data),
            })
        }
    }
    catch(e){
        dispatch( {
            type: ERROR_REQUEST,
            payload: console.log(e),
        })
    }
}