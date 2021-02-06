import {
    GET_LOGIN,
    TERMINAR_REQUEST,
    LOG_OUT
} from '../Util/scripts/TipoAcciones';

const initialState = {
    data: {
        "code": 0,
        "message": "OK",
        "response": {
            "token": window.localStorage.getItem("token")
        }
    },
    loading:true
}

export default function(state = initialState, action) {
    
    switch (action.type) {
        case GET_LOGIN:
            return {...state,data:action.payload,loading:false};
        case LOG_OUT:
            return {...state,data:action.payload,loading:false}
        default:
            return state ;
    }
}