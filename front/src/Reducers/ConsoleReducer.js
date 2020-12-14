import {
    GET_DATA_CONSOLE,
    TERMINAR_REQUEST
} from '../Util/scripts/TipoAcciones';

const initialState = {
    data: {
        "code": 200,
        "message": "OK",
        "response": {
            "data": []
        }
    },
    loading:true
}

export default function(state = initialState, action) {
    
    switch (action.type) {
        case GET_DATA_CONSOLE:
            // return Object.assign({}, state, {data: action.payload})
            return {...state,data:action.payload,loading:false};
        default:
            return state ;
    }
}