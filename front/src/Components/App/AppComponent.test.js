import { render, screen } from '@testing-library/react';
import App from './AppComponent';
import ReactTestUtils from 'react-dom/test-utils'; 
import { BrowserRouter } from 'react-router-dom';
import ReactDOM from 'react-dom';
import TestRenderer from 'react-test-renderer';

test('renders App component', () => {
  const testRenderer = TestRenderer.create(<App></App>);
  const testInstance = testRenderer.root;
  
  expect(testInstance.findByProps({className: "App"}).children);
});


test('check Switch component', () => {
  const testRenderer = TestRenderer.create(<App></App>);
  const testInstance = testRenderer.root;
  
  expect(testInstance.findByProps({className: "App"}).children);
});

test('check Console component', () => {
  const testRenderer = TestRenderer.create(<App></App>);
  const testInstance = testRenderer.root;
  
  expect(testInstance.findByProps({className: "App"}).children);
});

test('check Login component', () => {
  const testRenderer = TestRenderer.create(<App></App>);
  const testInstance = testRenderer.root;
  
  expect(testInstance.findByProps({className: "App"}).children);
});
