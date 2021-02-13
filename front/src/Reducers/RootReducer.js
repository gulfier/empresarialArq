import { combineReducers } from "redux";

import consoleReducer from "./ConsoleReducer";
import loginReducer from "./LoginReducer";
import historyReducer from "./HistoryReducer";

const rootReducer = combineReducers({
    console: consoleReducer,
    login: loginReducer,
    history: historyReducer
});

export default rootReducer;