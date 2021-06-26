import React,{useState} from 'react';
import AffairItem from './affair-item/affair-item.jsx'
import createKey from '../../../../../createKey.js'
import './main-affairs-table.css'

function AffairsTable (props) {

  
  

  let arr = [
    {
      id: 1,
      number: '1',
      litera: 'a',
      oldNumbers: '771',
      startDay: '01',
      startMounth: 'сентябрь',
      startYear: '1891',
      endDay: '21',
      endMounth: 'декабрь',
      endYear: '1892',
      lists: '43',
      category: 'ОСОБЫЙ',
      title: 'Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст ',
      annotation: 'аннотация',
      type: 'редкий',
      defects: 'xxx',
      note: 'Примечание какое то не понятное да да да'
    }
  ]
  
// let pointerTable = document.querySelector('.main-pointer-table');
// let pointerButton = document.querySelector('.button-pointer');

// pointerButton.addEventListener("click", function () {
//   console.log('nazhal');
// })


  return(
    <div>
      <div className="main-affairs-table" id={props.id} style={{height: props.height}}>
        <div className="grid-header-affairs-table">
          <div className="affairs-item-header case-number">Номер дела</div>
          <div className="affairs-item-header number">№</div>
          <div className="affairs-item-header litera">Литера</div>
          <div className="affairs-item-header old-number">Старый номер</div>
          <div className="affairs-item-header start-date">Начальная дата</div>
          <div className="affairs-item-header start-date-day">день</div>
          <div className="affairs-item-header start-date-month">месяц</div>
          <div className="affairs-item-header start-date-year">год</div>
          <div className="affairs-item-header end-date">Конечная дата</div>
          <div className="affairs-item-header end-date-day">день</div>
          <div className="affairs-item-header end-date-month">месяц</div>
          <div className="affairs-item-header end-date-year">год</div>
          <div className="affairs-item-header sheets">Кол-во листов</div>
          <div className="affairs-item-header category">Категория</div>
          <div className="affairs-item-header title">Заголовок текста</div>
          <div className="affairs-item-header annotation">Аннотация</div>
          <div className="affairs-item-header type-documentation">Тип документации</div>
          <div className="affairs-item-header retired">Выбывшие</div>
          <div className="affairs-item-header defects">Дефекты основы</div>
          <div className="affairs-item-header note">Примечание</div>
        </div>

        

        <div className="affairs">
          {/* Создание айтема в таблице */}
          {arr.map(el=><AffairItem
            number={el.number}
            litera={el.litera}
            oldNumber={el.oldNumber}
            startDay={el.startDay}
            startMounth={el.startMounth}
            startYear={el.startYear}
            endDay={el.endDay}
            endMounth={el.endMounth}
            endYear={el.endYear}
            lists={el.lists}
            category={el.category}
            title={el.title}
            annotation={el.annotation}
            type={el.type}
            defects={el.defects}
            note={el.note}
          key={createKey()}/>)}
        </div>
      
      
      <div className="grid-start-end-dates">
          <div className="start-end-dates-item start-dates-day">02</div>
          <div className="start-end-dates-item start-dates-month">Сентября</div>
          <div className="start-end-dates-item start-dates-year">1897</div>
          <div className="start-end-dates-item end-dates-day">24</div>
          <div className="start-end-dates-item end-dates-month">Октября</div>
          <div className="start-end-dates-item end-dates-year">1980</div>
        </div>
      </div>
    </div>

  )

  
}

export default AffairsTable;