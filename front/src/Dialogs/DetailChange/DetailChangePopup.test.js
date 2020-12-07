import { render, screen } from '@testing-library/react';
import App from '../../Components/App/AppComponent';
import ReactTestUtils from 'react-dom/test-utils'; 
import { BrowserRouter } from 'react-router-dom';
import ReactDOM from 'react-dom';
import TestRenderer from 'react-test-renderer';


describe('ProductHeader Component', () => {


    it('renders HistoryComponent component', () => {
        const testRenderer = TestRenderer.create(<App/>);
        const testInstance = testRenderer.root;
        
      });
  });


// test('check table component', () => {
//   const testRenderer = TestRenderer.create(<HistoryComponent></HistoryComponent>);
//   const testInstance = testRenderer.root;
  
// });
