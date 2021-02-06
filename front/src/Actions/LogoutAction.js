import {
    LOG_OUT
} from '../Util/scripts/TipoAcciones';

const initialState = {
        "code": 0,
        "message": "OK",
        "response": {
            "token": null
        }
};

export const removeToken = () => async dispatch => {
    
            dispatch( {
                type: LOG_OUT,
                payload: initialState
            })
}