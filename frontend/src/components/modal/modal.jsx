import React from 'react';
import './modal.css'

function Modal(props) {

  return (
    <div className={props.active ? "modal active" : "modal"}>
      <div className="modal-content" onClick={e => e.stopPropagation()}>
        {props.children}
      </div>
    </div>
  )
}

export default Modal;