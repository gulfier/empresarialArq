import { combineReducers } from "redux";

import consoleReducer from "./ConsoleReducer";

const rootReducer = combineReducers({
    console: consoleReducer,
});

export default rootReducer;