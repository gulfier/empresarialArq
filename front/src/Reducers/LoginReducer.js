import {
    GET_LOGIN,
    TERMINAR_REQUEST
} from '../Util/scripts/TipoAcciones';

const initialState = {
    data: {
        "code": 0,
        "message": "OK",
        "response": {
            "token": ""
        }
    },
    loading:true
}

export default function(state = initialState, action) {
    
    switch (action.type) {
        case GET_LOGIN:
            return {...state,data:action.payload,loading:false};
        default:
            return state ;
    }
}