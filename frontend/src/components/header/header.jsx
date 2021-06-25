import React from "react";
import "./header.css"


// Названия функций с большой буквы так как это компонент
  function Header () {
    return (
    <header className="header">
    <ul className="header-list">
      <li className="header-item">Файл</li>
      <li className="header-item">Справочники</li>
      <li className="header-item">Печать отчетов</li>
      <li className="header-item">Поиск дел</li>
      <li className="header-item">Сервис</li>
      <li className="header-item">Помощь</li>
    </ul>
    <a className="login">Войти</a>
    </header>
    )
  }

  export default Header;