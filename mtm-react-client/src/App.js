import React, { Component } from "react";
import "./App.css";
import Dashboard from "./Components/Dashboard";
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter as Router, Route } from "react-router-dom";
import Header from "./Components/Layout/Header";
import AddTask from "./Components/Task/AddTask";

class App extends Component {
  render() {
    return (
      <Router>
        <div className="App">
          <Header />
          <Route exact path="/Dashboard" component={Dashboard} />
          <Route exact path="/addTask" component={AddTask} />
        </div>
      </Router>
    );
  }
}

export default App;
