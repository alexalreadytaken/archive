import React from 'react';

function InventoryItem(props) {
  return (
    <>
    <input className="inventory-item" defaultValue={props.number}/>
    <input className="inventory-item" defaultValue={props.name}/>
    </>
  )
}

export default InventoryItem;