import React from 'react';
import PointerItem from './pointer-item/pointer-item.jsx';
import createKey from '../../../../../createKey.js';

function PointerTable(props) {

  let arr = [
    {
      type: 'Тип',
      value: 'Значение какое-то',
      note: 'Примечание для примечания'
    }
  ]

  return (
    <div className="main-pointer-table" id={props.id} style={{display: props.visible, height: props.height}}>
      <div className="grid-header-pointer-table">
        <div className="pointer-item-header pointers-header">Указатели</div>
        <div className="pointer-item-header type-header">Тип</div>
        <div className="pointer-item-header value-header">Значение</div>
        <div className="pointer-item-header note-header">Примечание</div>
      </div>

        <div className="pointers">
          <div className="grid-pointers-table">
            {arr.map(el=><PointerItem type={el.type} value={el.value} note={el.note} key={createKey()}/>)}
        </div>
      </div>
    </div>
  )
}

export default PointerTable;