import React from 'react';

function BtnOtherTables(props) {
  return (
    <div className="buttons-other-tables">
      <button className="button-condition">Панель состояния дела</button>
      <button className="button-pointer" onClick={()=>props.visibleCh()}>Панель Указателей</button>
    </div>
  )
}

export default BtnOtherTables;