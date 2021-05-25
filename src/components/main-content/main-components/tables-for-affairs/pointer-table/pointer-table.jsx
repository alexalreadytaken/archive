import React from 'react';

function PointerTable(props) {
  return (
    <div className="main-pointer-table" style={{display: props.visible}}>
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
  )
}

export default PointerTable;