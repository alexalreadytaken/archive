import React, {useState} from 'react';
import DeleteIcon from '@material-ui/icons/Delete';
import { makeStyles, TextField, Button, IconButton,} from '@material-ui/core';


function OldNameElement (props) {

  const useStyles = makeStyles((theme) => ({
  root: {
    '& > *': {
      margin: theme.spacing(1),
      width: '25ch',
    },
  },
  btnCreate: {
    '&': {
      backgroundColor: 'rgba(161, 234, 251)',
      color: '#212121',
      width: '30vw',
      marginRight: '30px',
    },
  },oldNameComponent: {
      margin: '10px',
      display: 'flex',
      alignItems: 'center'
  },
  textFieldOldName: {
    width: '340px',
    marginRight: '15px'
  },
  oldnamesButton: {
    '&': {
      backgroundColor: '#ffffff',
      color: '#212121',
    }
  },
    '& .MuiButton-contained:hover': {
      backgroundColor: 'rgba(161, 234, 251)',
    },
    
}
  ));

  const classes = useStyles();

  const [oldName, setOldName] = useState();
  const [oldDate, setOldDate] = useState();

    const handleChange = (event) => { 
    setOldName(event.target.value.title);
    setOldDate(event.target.value.date);
  };

  return (
    <div className={classes.oldNameComponent}>
    <TextField
          id="oldName-input"
          label="Старое имя фонда"
          multiline
          rowsMax={4}
          onChange={handleChange}
          variant="outlined"
          className={classes.textFieldOldName}
        />
        <TextField
          id="oldName-date"
          label="Дата создания"
          type="date"
          className={classes.textFieldDate}
          InputLabelProps={{
          shrink: true,
          }}
        />
        <IconButton aria-label="delete">
          <DeleteIcon />
        </IconButton>
    </div>
  )
}

export default OldNameElement;