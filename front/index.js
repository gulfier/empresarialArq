import React from 'react';
import express from 'express';
import { createStore } from 'redux';
import { Provider } from 'react-redux';
import rootReducer from './src/Reducers/RootReducer';
import ReactDOMServer from 'react-dom/server';
import LoginComponent from './src/Components/Login/LoginComponent';
import HistoryComponent from './src/Components/History/HistoryComponent';
import ConsoleComponent from './src/Components/Console/ConsoleComponent';

const PORT = process.env.PORT || 3000;
const app = express();

app.set('port',PORT);
//Serve static files
//app.use('/static', Express.static('static'))
app.use(express.static('./build'));

// This is fired every time the server side receives a request
//app.use(handleRender)

// Create a new Redux store instance
const store = createStore(rootReducer);

app.get('/', function (req, res) {
  res.redirect('/login')
});

app.get('/login', function (req, res) {
  // Render the component to a string
  const html = ReactDOMServer.renderToString(
    <Provider store={store}>
      <LoginComponent />
    </Provider>
  );
  handleRender(req,res,html);
});

app.get('/console', function (req, res) {
  // Render the component to a string
  const html = ReactDOMServer.renderToString(
    <Provider store={store}>
      <ConsoleComponent />
    </Provider>
  );
  handleRender(req,res,html);
});

app.get('/history', function (req, res) {
  // Render the component to a string
  const html = ReactDOMServer.renderToString(
    <Provider store={store}>
      <HistoryComponent />
    </Provider>
  );
  handleRender(req,res,html);
});

// We are going to fill these out in the sections to follow
function handleRender(req, res,html) {
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
        <meta charset="utf-8" />
        <link rel="icon" href="%PUBLIC_URL%/favicon.ico" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta name="theme-color" content="#000000" />
        <meta
          name="description"
          content="Web site created using create-react-app"
        />
        <link
          rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
          crossorigin="anonymous"
        />
        <script src="https://unpkg.com/react@17/umd/react.production.min.js"></script>
        <script src="https://unpkg.com/react-dom@17/umd/react-dom.production.min.js"></script>
        <link rel="apple-touch-icon" href="%PUBLIC_URL%/logo192.png" />
        <!--
          manifest.json provides metadata used when your web app is installed on a
          user's mobile device or desktop. See https://developers.google.com/web/fundamentals/web-app-manifest/
        -->
        <link rel="manifest" href="%PUBLIC_URL%/manifest.json" />
        <title>React App</title>
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