import { render, screen } from '@testing-library/react';
import LoginComponent from './LoginComponent';
import ReactTestUtils from 'react-dom/test-utils'; 
import { BrowserRouter } from 'react-router-dom';
import ReactDOM from 'react-dom';
import TestRenderer from 'react-test-renderer';

test('renders HistoryComponent component', () => {
  const testRenderer = TestRenderer.create(<LoginComponent/>);
  const testInstance = testRenderer.root;
  
});


test('check table component', () => {
    const testRenderer = TestRenderer.create(<LoginComponent/>);
    const testInstance = testRenderer.root;
  
});
