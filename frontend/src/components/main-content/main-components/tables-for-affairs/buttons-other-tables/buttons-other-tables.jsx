import React from 'react';
import { makeStyles, Button, Box} from '@material-ui/core';  

function BtnOtherTables(props) {

  const useStyles = makeStyles((theme) => ({
  root: {
  },
  btnColor: {
    '&': {
      fontSize: 10,
      backgroundColor: 'rgba(218, 220, 224, 0)',
      boxShadow: 'none',
    },
  }
}));

  
  const classes = useStyles();

  return (
    <div className="buttons-other-tables">
      <Button variant="contained" style={{boxShadow: 'none'}} className="button-condition" className={classes.btnColor}>Панель состояния дела</Button>
      <Button variant="contained" style={{boxShadow: 'none'}} className="button-pointer" className={classes.btnColor} onClick={()=>props.visibleCh()}>Панель Указателей</Button>
    </div>
  )
}

export default BtnOtherTables;