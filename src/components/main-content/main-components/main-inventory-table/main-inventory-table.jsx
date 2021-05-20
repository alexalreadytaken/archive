import React from 'react';
import './main-inventory-table.css';

function InventoryTable () {
  return(
  <div className="main-inventory-table">
        <div className="grid-inventory-table">
          <div className="inventory-item">№ описи</div>
          <div className="inventory-item">Номер фонда</div>
          <div className="inventory-item">Введение</div>
          <div className="inventory-item">1</div>
          <div className="inventory-item">2444</div>
          <div className="inventory-item">Что то там происходило как быть не знаем совсем</div>
          <div className="inventory-item">1</div>
          <div className="inventory-item">2444</div>
          <div className="inventory-item">Что то там происходило как быть не знаем совсем</div>
          <div className="inventory-item">1</div>
          <div className="inventory-item">2444</div>
          <div className="inventory-item">Что то там происходило как быть не знаем совсем</div>
          <div className="inventory-item">1</div>
          <div className="inventory-item">2444</div>
          <div className="inventory-item">Что то там происходило как быть не знаем совсем</div>
        </div>

        <div className="inventory-buttons">
          <button>Вставить</button>
          <button>Сохранить</button>
          <button>Удалить</button>
          <button>Отмена</button>
        </div>
      </div>
  )
}

export default InventoryTable;