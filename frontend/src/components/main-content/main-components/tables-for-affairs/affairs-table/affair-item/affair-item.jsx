import React from 'react';

function AffairItem(props) {
  return (
    <div className="affair">
      <input type="text" className="affair-item affair-number" defaultValue={props.number} />
      <input type="text" className="affair-item affair-litera" defaultValue={props.litera} />
      <input type="text" className="affair-item affair-old-number" defaultValue={props.oldNumber} />
      <input type="text" className="affair-item affair-start-date-day" defaultValue={props.startDay} />
      <input type="text" className="affair-item affair-start-date-month" defaultValue={props.startMounth} />
      <input type="text" className="affair-item affair-start-date-year" defaultValue={props.startYear} />
      <input type="text" className="affair-item affair-end-date-day" defaultValue={props.endDay} />
      <input type="text" className="affair-item affair-end-date-month" defaultValue={props.endMounth} />
      <input type="text" className="affair-item affair-end-date-year" defaultValue={props.endYear} />
      <input type="text" className="affair-item affair-sheets" defaultValue={props.lists} />
      <input type="text" className="affair-item affair-category" defaultValue={props.category} />
      <input type="text" className="affair-item affair-title" defaultValue={props.title} />
      <input type="text" className="affair-item affair-annotation" defaultValue={props.annotation} />
      <input type="text" className="affair-item affair-type-documentation" defaultValue={props.type} />
      <div className="affair-item affair-retired"><input type="checkbox" /></div>
      <input type="text" className="affair-item affair-defects" defaultValue= {props.defects}/>
      <input type="text" className="affair-item affair-note" defaultValue={props.note} />
    </div>
  )  
}

export default AffairItem;