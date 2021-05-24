import React from 'react';
import './main-inventory-table.css';

function InventoryTable () {
  return(
  <div className="main-inventory-table">
        <div className="grid-header-inventory-table">
          <div className="inventory-item-header header-inventory-tabel">№ описи</div>
          <div className="inventory-item-header header-inventory-tabel">Введение</div>
        </div>

        <div className="inventorys">
          <div className="grid-inventory-table">
            <div className="inventory-item">1</div>
            <div className="inventory-item">Что то там происходило как быть не знаем совсем</div>
            <div className="inventory-item">1</div>
            <div className="inventory-item">Что то там происходило как быть не знаем совсем</div>
            <div className="inventory-item">1</div>
            <div className="inventory-item">Что то там происходило как быть не знаем совсем</div>
            <div className="inventory-item">1</div>
            <div className="inventory-item">Что то там происходило как быть не знаем совсем</div>
          </div>
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