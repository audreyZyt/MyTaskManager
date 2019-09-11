import React, { Component } from "react";
import TaskItem from "./Task/TaskItem";
import Header from "./Layout/Header";
import CreateTaskButton from "./Task/CreateTaskButton";

class Dashboard extends Component {
  render() {
    return (
      <div className="tasks">
        <div className="container">
          <div className="row">
            <div className="col-md-12">
              <h1 className="display-4 text-center">Tasks</h1>
              <br />
              <CreateTaskButton />
              <br />
              <hr />
              <TaskItem />
            </div>
          </div>
        </div>
      </div>
    );
  }
}

export default Dashboard;
