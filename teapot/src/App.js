import teapot from './teapot-flyclipart.jpg';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={teapot} className="App-logo" alt="logo" />
        <div>
          <p>
            Welcome to the Teapot!
          </p>
          </div>
        <div className="clipart-source">
          <p>
          Teapot image source: &nbsp;
          <a href="https://flyclipart.com/teapot-kettle-computer-icons-can-stock-photo-pouring-tea-clipart-188772"  title="go to teapot image source">Teapot Kettle Computer Icons Can Stock Photo - Pouring Tea Clipart</a>
        </p>
        </div>
      </header>
    </div>
  );
}

export default App;
