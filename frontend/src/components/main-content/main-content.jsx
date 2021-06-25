import React from "react";
import "./main-content.css"


function MainContent (props) {
  return <div className="main-content">
    {props.children}
  </div>
}

export default MainContent;