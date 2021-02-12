import {
    GET_DATA_CONSOLE,
    TERMINAR_REQUEST
} from '../Util/scripts/TipoAcciones';

const initialState = {
    data: {
        "code": 200,
        "message": "OK",
        "response": {
            "changes":{
                "data": [],
                "records": 0,
                "pages": 1,
                "page": 0,
                "size": 10
            },
            "graph": "{\"puntos\":[{\"date\":\"01/NOV/20\",\"changes\":0},{\"date\":\"15/NOV/20\",\"changes\":300},{\"date\":\"01/DIC/20\",\"changes\":600},{\"date\":\"15/DIC/20\",\"changes\":800},{\"date\":\"01/ENE/21\",\"changes\":1500},{\"date\":\"15/ENE/21\",\"changes\":2000},{\"date\":\"01/FEB/21\",\"changes\":2400},{\"date\":\"15/FEB/21\",\"changes\":2400},{\"date\":\"01/MAR/21\"}]}"
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