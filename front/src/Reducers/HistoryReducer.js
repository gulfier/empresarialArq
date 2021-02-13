import {
    GET_DATA_HISTORY,
    TERMINAR_REQUEST
} from '../Util/scripts/TipoAcciones';

const initialState = {
    data: {
        "code": 200,
        "message": "OK",
        "response": {
            "data":[],
            "records": 0,
            "pages": 1,
            "page": 0,
            "size": 10
        }
    },
    loading:true
}

export default function(state = initialState, action) {
    
    switch (action.type) {
        case GET_DATA_HISTORY:
            // return Object.assign({}, state, {data: action.payload})
            return {...state,data:action.payload,loading:false};
        default:
            return state ;
    }
}