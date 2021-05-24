import React from "react";
import "./search.css"

function Search () {

  // const n = (e) => console.log(e.target.value)

  return (
    <section className="search-block">
      <fieldset className="search-group">
        <legend style={{alignItems: "center"}}>Фонд</legend>

        <label htmlFor="number" className="search-lable">Номер</label>
        <input type="text" id="number" className="search-number" />

        <label htmlFor="name" className="search-lable">Название</label>
        <input type="text" id="name" className="search-name"/>

        <button className="search-button">Вывести</button>
      </fieldset>

      <div className="buffer-block">
      <label htmlFor="buffer">Дел в буфере</label>
      <input type="text" id="buffer" className="output-buffer" disabled="disabled"/>
      </div>
    </section>
  )
}

export default Search;