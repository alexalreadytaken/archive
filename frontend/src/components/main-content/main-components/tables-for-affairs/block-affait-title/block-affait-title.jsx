import React from 'react'

function AffairTitle(props) {

  return(
  <div className="block-affair-title">
     <h2 className="affair-title">{props.title}</h2>
     <input type="text" className="input-affair-title" />
  </div>
  )

}

export default AffairTitle;