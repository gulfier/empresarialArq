import { combineReducers } from "redux";

import consoleReducer from "./ConsoleReducer";
import loginReducer from "./LoginReducer";

const rootReducer = combineReducers({
    console: consoleReducer,
    login: loginReducer,
});

export default rootReducer;