import React from 'react';

function PointerItem(props) {
  return (
    <div className="pointer">
      <input type="text" className="pointer-item type-item" defaultValue={props.type} />
      <input type="text" className="pointer-item value-item" defaultValue={props.value} />
      <input type="text" className="pointer-item note-item" defaultValue={props.note} />  
    </div>
  )
}

export default PointerItem;