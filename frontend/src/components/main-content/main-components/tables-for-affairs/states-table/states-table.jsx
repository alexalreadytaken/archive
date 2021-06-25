import React from 'react';
import './states-table.css'

function StatesTable(props) {
  return (
    <div className="main-states-table">
      <div className="grid-header-states-table">
        <div className="header-states-table-item">Физическое состояние</div>
        <div className="header-states-table-item">Художеств.</div>
        <div className="header-states-table-item">Деффекты текста</div>
      </div>

      <div className="grid-states-table">
        <div className="states-table-item ">ss</div>
        <div className="states-table-item">Художеств.</div>
        <div className="states-table-item">Деффекты текста</div>
      </div>
    </div>
  )
}

export default StatesTable;