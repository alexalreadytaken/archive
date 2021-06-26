import React from 'react';
import { makeStyles, Button, Box} from '@material-ui/core';

function ButtonsAffair(params) {

  const useStyles = makeStyles((theme) => ({
  root: {
  },
  btnColor: {
    '&': {
      fontSize: 10,
      backgroundColor: 'white',
    }
  }
}));

  const classes = useStyles();

  return (
    <div className="block-buttons-affair">
      <Button variant="contained" className={classes.btnColor} style={{boxShadow: 'none'}}>Вставить</Button>
      <Button variant="contained" className={classes.btnColor} style={{boxShadow: 'none'}}>Удалить</Button>
      <Button variant="contained" className={classes.btnColor} style={{boxShadow: 'none'}}>Сохранить</Button>
      <Button variant="contained" className={classes.btnColor} style={{boxShadow: 'none'}}>Отмена</Button>
      <Button variant="contained" className={classes.btnColor} style={{boxShadow: 'none'}}>Копировать в буфер</Button>
      <Button variant="contained" className={classes.btnColor} style={{boxShadow: 'none'}}>Вставить из буфера</Button>
      <Button variant="contained" className={classes.btnColor} style={{boxShadow: 'none'}}>Перенумеровка</Button>
    </div>
  )
}

export default ButtonsAffair;