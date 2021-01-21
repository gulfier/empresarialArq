const express = require('express');
const redux = require('redux');
import { Provider } from 'react-redux';
const reactRedux = require('react-redux');
import rootReducer from './Reducers/RootReducer';
const ReactDOMServer = require('react-dom/server');
import App from '../src/Components/App/AppComponent';
const React = require('react');

const PORT = process.env.PORT || 8080;
const app = express();

app.set('port',PORT);
//Serve static files
//app.use('/static', Express.static('static'))
app.use(express.static('./build'));

// This is fired every time the server side receives a request
app.use(handleRender)

// We are going to fill these out in the sections to follow
function handleRender(req, res) {
  // Create a new Redux store instance
  const store = redux.createStore(rootReducer)

  // Render the component to a string
  const html = ReactDOMServer.renderToString(
    <reactRedux.Provider store={store}>
      <App />
    </reactRedux.Provider>
  )

  // Grab the initial state from our Redux store
  const preloadedState = store.getState()

  // Send the rendered page back to the client
  res.send(renderFullPage(html, preloadedState))
}
function renderFullPage(html, preloadedState) {
  return `
    <!doctype html>
    <html>
      <head>
        <title>Redux Universal Example</title>
      </head>
      <body>
        <div id="root">${html}</div>
        <script>
          // WARNING: See the following for security issues around embedding JSON in HTML:
          // https://redux.js.org/recipes/server-rendering/#security-considerations
          window.__PRELOADED_STATE__ = ${JSON.stringify(preloadedState).replace(
            /</g,
            '\\u003c'
          )}
        </script>
        <script src="/static/bundle.js"></script>
      </body>
    </html>
    `
}

app.listen(PORT, () => {
  console.log(`Server is listening on port ${PORT}`);
});

// var server = app.listen(app.get('port'), function() {
//   debug('Express server listening on port ' + server.address().port);
// });
// module.exports = app;