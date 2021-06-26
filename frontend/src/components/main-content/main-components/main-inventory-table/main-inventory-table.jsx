import React from 'react';
import { makeStyles, Button } from '@material-ui/core';
import InventoryItem from './inventory-item/inventory-item.jsx'
import createKey from '../../../../createKey.js'
import './main-inventory-table.css';

function InventoryTable () {

  let arr = [
    {
      number: '1',
      name:'Название описи'
    }
  ]

  const useStyles = makeStyles((theme) => ({
  root: {
    
  }, 
  btnColor: {
    '&': {
      backgroundColor: 'white',
      fontSize: 10,
      
    }
  }
}));

  const classes = useStyles();

  return(
  <div className="main-inventory-table">
        <div className="grid-header-inventory-table">
          <div className="inventory-item-header header-inventory-tabel">№ описи</div>
          <div className="inventory-item-header header-inventory-tabel">Введение</div>
        </div>

        <div className="inventorys">
          <div className="grid-inventory-table">
            {arr.map(el=><InventoryItem number={el.number} name={el.name} key={createKey()}/>)}
          </div>
        </div>

        <div className="block-inventory-buttons">
          <Button variant="contained" style={{boxShadow: 'none'}} className={classes.btnColor}>Вставить</Button>
          <Button variant="contained" style={{boxShadow: 'none'}} className={classes.btnColor}>Сохранить</Button>
          <Button variant="contained" style={{boxShadow: 'none'}} className={classes.btnColor}>Удалить</  Button>
          <Button variant="contained" style={{boxShadow: 'none'}} className={classes.btnColor}>Отмена</Button>
        </div>
      </div>
  )
}

export default InventoryTable;