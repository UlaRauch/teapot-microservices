import { render, screen } from '@testing-library/react';
import App from './App';

test('renders teapot', () => {
  render(<App />);
  const teapotImage = screen.getByAltText(/logo/i);
  expect(teapotImage).toBeInTheDocument();
});

test('says welcome', () => {
  render(<App />);
  const welcomeText = screen.getByText(/Welcome to the Teapot!/i);
  expect(welcomeText).toBeInTheDocument();
})

test('renders teapot image source', () => {
  render(<App />);
  const teapotSource = screen.getByTitle(/go to teapot image source/i);
  expect(teapotSource).toBeInTheDocument();
})
