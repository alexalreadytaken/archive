
import React,{useState} from 'react';
import './main-affairs-table.css'

function AffairsTable () {

  
// let pointerTable = document.querySelector('.main-pointer-table');
// let pointerButton = document.querySelector('.button-pointer');

// pointerButton.addEventListener("click", function () {
//   console.log('nazhal');
// })

  

  return(
    <div>
    <div className="main-affairs-table">
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
        <div className="affair">
          <div className="affair-item affair-number">1</div>
          <div className="affair-item affair-litera">а</div>
          <div className="affair-item affair-old-number">33</div>
          <div className="affair-item affair-start-date-day">03</div>
          <div className="affair-item affair-start-date-month">Декабрь</div>
          <div className="affair-item affair-start-date-year">1694</div>
          <div className="affair-item affair-end-date-day">13</div>
          <div className="affair-item affair-end-date-month">Ноябрь</div>
          <div className="affair-item affair-end-date-year">1695</div>
          <div className="affair-item affair-sheets">666</div>
          <div className="affair-item affair-category">ОСОБЫЙ</div>
          <div className="affair-item affair-title">Кто то там с кем то переписывался о чем то том то </div>
          <div className="affair-item affair-annotation">Аннотация</div>
          <div className="affair-item affair-type-documentation">редкий наверное</div>
          <div className="affair-item affair-retired"><input type="checkbox" /></div>
          <div className="affair-item affair-defects">чтьо</div>
          <div className="affair-item affair-note">РАньше был номер 33 но мы решили сделать 1</div>
        </div>
        <div className="affair">
          <div className="affair-item affair-number">1</div>
          <div className="affair-item affair-litera">а</div>
          <div className="affair-item affair-old-number">33</div>
          <div className="affair-item affair-start-date-day">03</div>
          <div className="affair-item affair-start-date-month">Декабрь</div>
          <div className="affair-item affair-start-date-year">1694</div>
          <div className="affair-item affair-end-date-day">13</div>
          <div className="affair-item affair-end-date-month">Ноябрь</div>
          <div className="affair-item affair-end-date-year">1695</div>
          <div className="affair-item affair-sheets">666</div>
          <div className="affair-item affair-category">ОСОБЫЙ</div>
          <div className="affair-item affair-title">Кто то там с кем то переписывался о чем то том то </div>
          <div className="affair-item affair-annotation">Аннотация</div>
          <div className="affair-item affair-type-documentation">редкий наверное</div>
          <div className="affair-item affair-retired"><input type="checkbox" /></div>
          <div className="affair-item affair-defects">чтьо</div>
          <div className="affair-item affair-note">РАньше был номер 33 но мы решили сделать 1</div>
        </div>
        <div className="affair">
          <div className="affair-item affair-number">1</div>
          <div className="affair-item affair-litera">а</div>
          <div className="affair-item affair-old-number">33</div>
          <div className="affair-item affair-start-date-day">03</div>
          <div className="affair-item affair-start-date-month">Декабрь</div>
          <div className="affair-item affair-start-date-year">1694</div>
          <div className="affair-item affair-end-date-day">13</div>
          <div className="affair-item affair-end-date-month">Ноябрь</div>
          <div className="affair-item affair-end-date-year">1695</div>
          <div className="affair-item affair-sheets">666</div>
          <div className="affair-item affair-category">ОСОБЫЙ</div>
          <div className="affair-item affair-title">Кто то там с кем то переписывался о чем то том то </div>
          <div className="affair-item affair-annotation">Аннотация</div>
          <div className="affair-item affair-type-documentation">редкий наверное</div>
          <div className="affair-item affair-retired"><input type="checkbox" /></div>
          <div className="affair-item affair-defects">чтьо</div>
          <div className="affair-item affair-note">РАньше был номер 33 но мы решили сделать 1</div>
        </div>
        <div className="affair">
          <div className="affair-item affair-number">1</div>
          <div className="affair-item affair-litera">а</div>
          <div className="affair-item affair-old-number">33</div>
          <div className="affair-item affair-start-date-day">03</div>
          <div className="affair-item affair-start-date-month">Декабрь</div>
          <div className="affair-item affair-start-date-year">1694</div>
          <div className="affair-item affair-end-date-day">13</div>
          <div className="affair-item affair-end-date-month">Ноябрь</div>
          <div className="affair-item affair-end-date-year">1695</div>
          <div className="affair-item affair-sheets">666</div>
          <div className="affair-item affair-category">ОСОБЫЙ</div>
          <div className="affair-item affair-title">Кто то там с кем то переписывался о чем то том то </div>
          <div className="affair-item affair-annotation">Аннотация</div>
          <div className="affair-item affair-type-documentation">редкий наверное</div>
          <div className="affair-item affair-retired"><input type="checkbox" /></div>
          <div className="affair-item affair-defects">чтьо</div>
          <div className="affair-item affair-note">РАньше был номер 33 но мы решили сделать 1</div>
        </div>
        <div className="affair">
          <div className="affair-item affair-number">1</div>
          <div className="affair-item affair-litera">а</div>
          <div className="affair-item affair-old-number">33</div>
          <div className="affair-item affair-start-date-day">03</div>
          <div className="affair-item affair-start-date-month">Декабрь</div>
          <div className="affair-item affair-start-date-year">1694</div>
          <div className="affair-item affair-end-date-day">13</div>
          <div className="affair-item affair-end-date-month">Ноябрь</div>
          <div className="affair-item affair-end-date-year">1695</div>
          <div className="affair-item affair-sheets">666</div>
          <div className="affair-item affair-category">ОСОБЫЙ</div>
          <div className="affair-item affair-title">Кто то там с кем то переписывался о чем то том то </div>
          <div className="affair-item affair-annotation">Аннотация</div>
          <div className="affair-item affair-type-documentation">редкий наверное</div>
          <div className="affair-item affair-retired"><input type="checkbox" /></div>
          <div className="affair-item affair-defects">чтьо</div>
          <div className="affair-item affair-note">РАньше был номер 33 но мы решили сделать 1</div>
        </div>
        <div className="affair">
          <div className="affair-item affair-number">1</div>
          <div className="affair-item affair-litera">а</div>
          <div className="affair-item affair-old-number">33</div>
          <div className="affair-item affair-start-date-day">03</div>
          <div className="affair-item affair-start-date-month">Декабрь</div>
          <div className="affair-item affair-start-date-year">1694</div>
          <div className="affair-item affair-end-date-day">13</div>
          <div className="affair-item affair-end-date-month">Ноябрь</div>
          <div className="affair-item affair-end-date-year">1695</div>
          <div className="affair-item affair-sheets">666</div>
          <div className="affair-item affair-category">ОСОБЫЙ</div>
          <div className="affair-item affair-title">Кто то там с кем то переписывался о чем то том то </div>
          <div className="affair-item affair-annotation">Аннотация</div>
          <div className="affair-item affair-type-documentation">редкий наверное</div>
          <div className="affair-item affair-retired"><input type="checkbox" /></div>
          <div className="affair-item affair-defects">чтьо</div>
          <div className="affair-item affair-note">РАньше был номер 33 но мы решили сделать 1</div>
        </div>
        <div className="affair">
          <div className="affair-item affair-number">1</div>
          <div className="affair-item affair-litera">а</div>
          <div className="affair-item affair-old-number">33</div>
          <div className="affair-item affair-start-date-day">03</div>
          <div className="affair-item affair-start-date-month">Декабрь</div>
          <div className="affair-item affair-start-date-year">1694</div>
          <div className="affair-item affair-end-date-day">13</div>
          <div className="affair-item affair-end-date-month">Ноябрь</div>
          <div className="affair-item affair-end-date-year">1695</div>
          <div className="affair-item affair-sheets">666</div>
          <div className="affair-item affair-category">ОСОБЫЙ</div>
          <div className="affair-item affair-title">Кто то там с кем то переписывался о чем то том то </div>
          <div className="affair-item affair-annotation">Аннотация</div>
          <div className="affair-item affair-type-documentation">редкий наверное</div>
          <div className="affair-item affair-retired"><input type="checkbox" /></div>
          <div className="affair-item affair-defects">чтьо</div>
          <div className="affair-item affair-note">РАньше был номер 33 но мы решили сделать 1</div>
        </div>
        <div className="affair">
          <div className="affair-item affair-number">1</div>
          <div className="affair-item affair-litera">а</div>
          <div className="affair-item affair-old-number">33</div>
          <div className="affair-item affair-start-date-day">03</div>
          <div className="affair-item affair-start-date-month">Декабрь</div>
          <div className="affair-item affair-start-date-year">1694</div>
          <div className="affair-item affair-end-date-day">13</div>
          <div className="affair-item affair-end-date-month">Ноябрь</div>
          <div className="affair-item affair-end-date-year">1695</div>
          <div className="affair-item affair-sheets">666</div>
          <div className="affair-item affair-category">ОСОБЫЙ</div>
          <div className="affair-item affair-title">Кто то там с кем то переписывался о чем то том то </div>
          <div className="affair-item affair-annotation">Аннотация</div>
          <div className="affair-item affair-type-documentation">редкий наверное</div>
          <div className="affair-item affair-retired"><input type="checkbox" /></div>
          <div className="affair-item affair-defects">чтьо</div>
          <div className="affair-item affair-note">РАньше был номер 33 но мы решили сделать 1</div>
        </div>
        <div className="affair">
          <div className="affair-item affair-number">1</div>
          <div className="affair-item affair-litera">а</div>
          <div className="affair-item affair-old-number">33</div>
          <div className="affair-item affair-start-date-day">03</div>
          <div className="affair-item affair-start-date-month">Декабрь</div>
          <div className="affair-item affair-start-date-year">1694</div>
          <div className="affair-item affair-end-date-day">13</div>
          <div className="affair-item affair-end-date-month">Ноябрь</div>
          <div className="affair-item affair-end-date-year">1695</div>
          <div className="affair-item affair-sheets">666</div>
          <div className="affair-item affair-category">ОСОБЫЙ</div>
          <div className="affair-item affair-title">Кто то там с кем то переписывался о чем то том то </div>
          <div className="affair-item affair-annotation">Аннотация</div>
          <div className="affair-item affair-type-documentation">редкий наверное</div>
          <div className="affair-item affair-retired"><input type="checkbox" /></div>
          <div className="affair-item affair-defects">чтьо</div>
          <div className="affair-item affair-note">РАньше был номер 33 но мы решили сделать 1</div>
        </div>
        <div className="affair">
          <div className="affair-item affair-number">1</div>
          <div className="affair-item affair-litera">а</div>
          <div className="affair-item affair-old-number">33</div>
          <div className="affair-item affair-start-date-day">03</div>
          <div className="affair-item affair-start-date-month">Декабрь</div>
          <div className="affair-item affair-start-date-year">1694</div>
          <div className="affair-item affair-end-date-day">13</div>
          <div className="affair-item affair-end-date-month">Ноябрь</div>
          <div className="affair-item affair-end-date-year">1695</div>
          <div className="affair-item affair-sheets">666</div>
          <div className="affair-item affair-category">ОСОБЫЙ</div>
          <div className="affair-item affair-title">Кто то там с кем то переписывался о чем то том то </div>
          <div className="affair-item affair-annotation">Аннотация</div>
          <div className="affair-item affair-type-documentation">редкий наверное</div>
          <div className="affair-item affair-retired"><input type="checkbox" /></div>
          <div className="affair-item affair-defects">чтьо</div>
          <div className="affair-item affair-note">РАньше был номер 33 но мы решили сделать 1</div>
        </div>
        <div className="affair">
          <div className="affair-item affair-number">1</div>
          <div className="affair-item affair-litera">а</div>
          <div className="affair-item affair-old-number">33</div>
          <div className="affair-item affair-start-date-day">03</div>
          <div className="affair-item affair-start-date-month">Декабрь</div>
          <div className="affair-item affair-start-date-year">1694</div>
          <div className="affair-item affair-end-date-day">13</div>
          <div className="affair-item affair-end-date-month">Ноябрь</div>
          <div className="affair-item affair-end-date-year">1695</div>
          <div className="affair-item affair-sheets">666</div>
          <div className="affair-item affair-category">ОСОБЫЙ</div>
          <div className="affair-item affair-title">Кто то там с кем то переписывался о чем то том то </div>
          <div className="affair-item affair-annotation">Аннотация</div>
          <div className="affair-item affair-type-documentation">редкий наверное</div>
          <div className="affair-item affair-retired"><input type="checkbox" /></div>
          <div className="affair-item affair-defects">чтьо</div>
          <div className="affair-item affair-note">РАньше был номер 33 но мы решили сделать 1</div>
        </div><div className="affair">
          <div className="affair-item affair-number">1</div>
          <div className="affair-item affair-litera">а</div>
          <div className="affair-item affair-old-number">33</div>
          <div className="affair-item affair-start-date-day">03</div>
          <div className="affair-item affair-start-date-month">Декабрь</div>
          <div className="affair-item affair-start-date-year">1694</div>
          <div className="affair-item affair-end-date-day">13</div>
          <div className="affair-item affair-end-date-month">Ноябрь</div>
          <div className="affair-item affair-end-date-year">1695</div>
          <div className="affair-item affair-sheets">666</div>
          <div className="affair-item affair-category">ОСОБЫЙ</div>
          <div className="affair-item affair-title">Кто то там с кем то переписывался о чем то том то </div>
          <div className="affair-item affair-annotation">Аннотация</div>
          <div className="affair-item affair-type-documentation">редкий наверное</div>
          <div className="affair-item affair-retired"><input type="checkbox" /></div>
          <div className="affair-item affair-defects">чтьо</div>
          <div className="affair-item affair-note">РАньше был номер 33 но мы решили сделать 1</div>
        </div>
        <div className="affair">
          <div className="affair-item affair-number">1</div>
          <div className="affair-item affair-litera">а</div>
          <div className="affair-item affair-old-number">33</div>
          <div className="affair-item affair-start-date-day">03</div>
          <div className="affair-item affair-start-date-month">Декабрь</div>
          <div className="affair-item affair-start-date-year">1694</div>
          <div className="affair-item affair-end-date-day">13</div>
          <div className="affair-item affair-end-date-month">Ноябрь</div>
          <div className="affair-item affair-end-date-year">1695</div>
          <div className="affair-item affair-sheets">666</div>
          <div className="affair-item affair-category">ОСОБЫЙ</div>
          <div className="affair-item affair-title">Кто то там с кем то переписывался о чем то том то </div>
          <div className="affair-item affair-annotation">Аннотация</div>
          <div className="affair-item affair-type-documentation">редкий наверное</div>
          <div className="affair-item affair-retired"><input type="checkbox" /></div>
          <div className="affair-item affair-defects">чтьо</div>
          <div className="affair-item affair-note">РАньше был номер 33 но мы решили сделать 1</div>
        </div>
        <div className="affair">
          <div className="affair-item affair-number">1</div>
          <div className="affair-item affair-litera">а</div>
          <div className="affair-item affair-old-number">33</div>
          <div className="affair-item affair-start-date-day">03</div>
          <div className="affair-item affair-start-date-month">Декабрь</div>
          <div className="affair-item affair-start-date-year">1694</div>
          <div className="affair-item affair-end-date-day">13</div>
          <div className="affair-item affair-end-date-month">Ноябрь</div>
          <div className="affair-item affair-end-date-year">1695</div>
          <div className="affair-item affair-sheets">666</div>
          <div className="affair-item affair-category">ОСОБЫЙ</div>
          <div className="affair-item affair-title">Кто то там с кем то переписывался о чем то том то </div>
          <div className="affair-item affair-annotation">Аннотация</div>
          <div className="affair-item affair-type-documentation">редкий наверное</div>
          <div className="affair-item affair-retired"><input type="checkbox" /></div>
          <div className="affair-item affair-defects">чтьо</div>
          <div className="affair-item affair-note">РАньше был номер 33 но мы решили сделать 1</div>
        </div>
      </div>
    </div>


    <div className="block-affair-title">
     <h2 className="affair-title">Заголовок</h2>
     <input type="text" className="input-affair-title" />
    </div>

    <div className="block-buttons-affair">
      <button className="button-for-affair">Вставить</button>
      <button className="button-for-affair">Удалить</button>
      <button className="button-for-affair">Сохранить</button>
      <button className="button-for-affair">Отмена</button>
      <button className="button-for-affair">Копировать в буфер</button>
      <button className="button-for-affair">Вставить из буфера</button>
      <button className="button-for-affair">Перенумеровка</button>
    </div>

    <div className="main-pointer-table hide">
      <div className="grid-header-pointer-table">
        <div className="pointer-item-header pointers-header">Указатели</div>
        <div className="pointer-item-header type-header">Тип</div>
        <div className="pointer-item-header value-header">Значение</div>
        <div className="pointer-item-header note-header">Примечание</div>
      </div>

       <div className="pointers">
        <div className="grid-pointers-table">
          <div className="pointer">
            <div className="pointer-item type-item">Типо тип</div>
            <div className="pointer-item value-item">Кто-то пернул в кружку</div>
            <div className="pointer-item note-item">кружка была чужой</div>            
          </div>
          <div className="pointer">
            <div className="pointer-item type-item">Типо тип</div>
            <div className="pointer-item value-item">Кто-то пернул в кружку</div>
            <div className="pointer-item note-item">кружка была чужой</div>            
          </div>
          <div className="pointer">
            <div className="pointer-item type-item">Типо тип</div>
            <div className="pointer-item value-item">Кто-то пернул в кружку</div>
            <div className="pointer-item note-item">кружка была чужой</div>            
          </div>
          <div className="pointer">
            <div className="pointer-item type-item">Типо тип</div>
            <div className="pointer-item value-item">Кто-то пернул в кружку</div>
            <div className="pointer-item note-item">кружка была чужой</div>            
          </div>
          <div className="pointer">
            <div className="pointer-item type-item">Типо тип</div>
            <div className="pointer-item value-item">Кто-то пернул в кружку</div>
            <div className="pointer-item note-item">кружка была чужой</div>            
          </div>
          <div className="pointer">
            <div className="pointer-item type-item">Типо тип</div>
            <div className="pointer-item value-item">Кто-то пернул в кружку</div>
            <div className="pointer-item note-item">кружка была чужой</div>            
          </div>
          <div className="pointer">
            <div className="pointer-item type-item">Типо тип</div>
            <div className="pointer-item value-item">Кто-то пернул в кружку</div>
            <div className="pointer-item note-item">кружка была чужой</div>            
          </div>
          <div className="pointer">
            <div className="pointer-item type-item">Типо тип</div>
            <div className="pointer-item value-item">Кто-то пернул в кружку</div>
            <div className="pointer-item note-item">кружка была чужой</div>            
          </div>
          <div className="pointer">
            <div className="pointer-item type-item">Типо тип</div>
            <div className="pointer-item value-item">Кто-то пернул в кружку</div>
            <div className="pointer-item note-item">кружка была чужой</div>            
          </div>
          <div className="pointer">
            <div className="pointer-item type-item">Типо тип</div>
            <div className="pointer-item value-item">Кто-то пернул в кружку</div>
            <div className="pointer-item note-item">кружка была чужой</div>            
          </div>
          
        </div>
      </div>
    </div>

    <div className="buttons-other-tables">
      <button className="button-condition">Панель состояния дела</button>
      <button className="button-pointer">Панель Указателей</button>
    </div>

    </div>

  )

  
}

export default AffairsTable;