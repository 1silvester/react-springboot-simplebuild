import './App.css';
import React from 'react';
import Navbar from './components/Navbar';
// import {BrowserRouter as Router,Routes, Route} from "react-router-dom";
// import Home from './components/Pages/Home';

class App extends React.Component{

  state = {};

  componentDidMount(){
    this.quotes();
  }

  quotes = () => {
    fetch('/api/quotes')
    .then(response => response.text())
    .then(message => {
      this.setState({message : message});
    });
  };

  render() {
    return (
      <div className="App">
        <Navbar/>
        <body className="App_grid">
        <section className="App-section">
        {/* <section className="App-header"> */}
          <header className="App-header">
            <div className="App-bckgrd media">
              <img src={require('./assests/scenic.jpeg').default} alt="backgrdimg" />
            </div>
            </header>
            <div className="App__banner__box">
              <h3 className="App-title">{this.state.message}</h3>
            </div>
            
        </section>  
        </body>
      </div>
    )
  }
}

// function App() {
//   return (
//       <Router>
//         <Navbar/>
//         <Routes>
//           <Route path='/' exact element={<Home />}/>
//         </Routes>
//       </Router>
//   );
// }

export default App;
