import './App.css';
import React from 'react';
import Navbar from './components/Navbar';
import { Button } from './components/Button';
// import {BrowserRouter as Router,Routes, Route} from "react-router-dom";
// import Home from './components/Pages/Home';

class App extends React.Component{

  
  // constructor(props)
  // {
  //   super(props);
  //   this.setState = { data: "How long would you like to read for?" }
  //   // this.componentDidMount = this.componentDidMount.bind(this);
  //   this.quotes = this.quotes.bind(this);
  //   console.log(this.state)
  // }
  


  // state = {data : "How long would you like to read for?"};

  // componentDidMount = async () => {
  //   const textData = await this.quotes();
  //   console.log("GOT DATA...." + textData)
  //   this.setState(currentState => {return {data : textData}})
  //   // return textData;
  // }

  state = {}

  // async componentDidMount() {
  //   const textData = await this.quotes();
  //   console.log("GOT DATA...." + textData);
  //   this.setState(
  //     currentState => 
  //   {return {data : currentState.data  + textData}}).bind(this)
  //   return textData;
  //   // this.setState({data : textData})
  // }

  componentDidMount(){
    this.quotes()
  }

 
  quotes = () => {
    fetch('/api/book/marcus')
    .then(response => response.text())
    .then(message => {
      this.setState({message : message});
    });
  };


  // quotes = async () => 
  // {
  //   const response = await fetch('/api/book/marcus');
  //   const text = await response.text();
  //   console.log(text);
  //   // this.setState(currentState => {return {data : text}})
  //   return text;
  // };

  render() {
    return (
      <div className="App">
        <div className="App_navbar">
        <Navbar/>
        </div>
        <div className="App_grid">
        <div className="App-section">
        {/* <section className="App-header"> */}
          <header className="App-header">  
            </header> 
              <div className="App-bckgrd media">
                <img src={require('./assests/scenic.jpeg').default} alt="backgrdimg" />
                
              </div> 
              <div className="App__textarea">
                  <p className="App-title">{this.state.message}</p>
                  {/* <p className="App-title">{this.setState.data}</p> */}
                  <div className="App__comments__box">
                  <textarea className="comments"></textarea>
                </div> 
                <div>
                  <div className="App__button">
                  <Button onClick={() => {this.quotes()}} type={"button"} buttonStyle="btn--primary--solid" buttonSize="btn--large" key = {"Short Read"}></Button>
                
                  <Button onClick={() => {console.log("10 mins")}} type={"button"} buttonStyle="btn--primary--solid" buttonSize="btn--large" text={"Short Read"}> Short</Button>

                  <Button onClick={() => {console.log("20 mins")}}type={"button"} buttonStyle="btn--primary--solid" buttonSize="btn--large"text={"Short Read"}>Hello</Button>
                  </div>
              </div>
            </div>
        </div>  
        </div>
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
