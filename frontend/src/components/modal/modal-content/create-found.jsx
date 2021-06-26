import React, {useState} from 'react';
import './create-fund.css'
import { makeStyles, TextField, Button, IconButton,} from '@material-ui/core';
import OldNameElement from './modal-oldName-elem';
import createFound from '../functions/createFound.js';
import clearCreateFundModal from '../functions/clearCreateFundModal';


function CreateFound(props) {

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
  },oldNamesInput: {  
    position: 'absolute',
    width: '370px',
    zIndex: 1,
    backgroundColor: '#ffffff',
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


  const [modalPages, setModalPages] = useState(1);  
  const [modalTitle, setModalTitle] = useState('Создание фонда');
  const [degArrow, setDegArrow] = useState(0);
  const [oldNameComponents, setoldNameComponents] = useState([]);


  // Добавление старого имени

  let oldNamesTable = document.querySelector('.oldNames-table');

  const addOldNameComponent = event => {
    setoldNameComponents(oldNameComponents.concat(<OldNameElement></OldNameElement>));

    // Ну потому что он не скролит как мне надо...
    setTimeout(() => {
        let a = oldNamesTable.scrollHeight;
        oldNamesTable.scrollTop = a;
      },1);
    
  };

  return (
    <>
      <div className="modal-title-arrow">
        <h2 className="modalTitle">{modalTitle}</h2>
        {/* Кнопка переключения страниц модалки */}
        {/* <div className="modal-button-pages">
          <span className="modal-arrow-right" style={{transform: `rotate(${degArrow}deg)`}} onClick={()=>{
            if(modalPages === 1){
              setModalPages(2);
              setModalTitle('Старое название');
              setDegArrow(180);
            }else{
              setModalPages(1);
              setModalTitle('Создание фонда');
              setDegArrow(0);
            }
          }}></span>
          <span className="modal-pages">{modalPages}/2</span>
        </div> */}
      </div>

      {/* странички модалки */}
{/* {
  (modalPages === 1)?(
    <>
    <TextField className="input-number" id="fundNumberCreate" label="Номер" variant="outlined"/>
        <TextField className="input-letter" id="fundLetterCreate" label="Литера" variant="outlined"/>
        <TextField className="input-name" id="fundNameCreate" label="Название" variant="outlined"/>
        <TextField
          id="date"
          label="Дата создания"
          type="date"
          className={classes.textField}
          InputLabelProps={{
          shrink: true,
          }}
        />
      </>
  ):(
    <>
      <div className="oldNames-table">
        {oldNameComponents}
      </div>

        <div className="oldNames-buttons">
          <Button variant="contained" onClick={addOldNameComponent} className={classes.oldnamesButton} style={{boxShadow: 'none'}} color='rg(161, 234, 251)'>Добавить</Button>
        </div>
      </>
  )
} */}


      <>
    <TextField className="input-number" id="fundNumberCreate" label="Номер" variant="outlined"/>
        <TextField className="input-letter" id="fundLetterCreate" label="Литера" variant="outlined"/>
        <TextField className="input-name" id="fundNameCreate" label="Название" variant="outlined"/>
        <TextField
          id="date"
          label="Дата создания"
          type="date"
          className={classes.textField}
          InputLabelProps={{
          shrink: true,
          }}
        />
      </>

    <>
      <div className="oldNames-table">
        {oldNameComponents}
      </div>

        <div className="oldNames-buttons">
          <Button variant="contained" onClick={addOldNameComponent} className={classes.oldnamesButton} style={{boxShadow: 'none'}} color='rg(161, 234, 251)'>Добавить старое имя фонда</Button>
        </div>
      </>
        
      
      
      

      <div className="create-found-buttons">
        <Button variant="contained" className={classes.btnCreate} style={{boxShadow: 'none'}} color='rg(161, 234, 251)' onClick={function(event){ createFound(); clearCreateFundModal(); setoldNameComponents([])}}>Создать</Button>
        <Button variant="contained" className={classes.btnCancel} style={{boxShadow: 'none'}} color='rg(161, 234, 251)' onClick={function(event){clearCreateFundModal(); setoldNameComponents([]); props.setActive(false)}}>Отмена</Button>
      </div>
    </>
  )
}

export default CreateFound;