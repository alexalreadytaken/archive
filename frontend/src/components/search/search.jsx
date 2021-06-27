import React , { useState } from "react";
import {makeStyles, TextField, Button, Box} from '@material-ui/core/';
import "./search.css"
import search from './searchFund.js'

function Search (props) {

  const [inputOne, setInputOne] = useState('');

  const useStyles = makeStyles((theme) => ({
  root: {
    '& > form': {
      margin: theme.spacing(1),
      width: '25ch',
    },
    '& label': {
      fontSize: 14,
    },
    '& label.Mui-focused': {
      // color: 'green',
    },
    '& .MuiOutlinedInput-inputMarginDense': {
      padding: 10,
      textAligin: 'center',
      alignItems: 'center',
      
    },
    '& .MuiButton-contained': {
      boxShadow: 0,
    },

    
  }, 
  btnColor: {
    '&': {
      backgroundColor: 'white',
    }
  }
}));

  const classes = useStyles();

  return (
    <div className="search-block">
      {/* Поиск фонда */}
      <form className={classes.root} className="search-form" noValidate autoComplete="off" >
        <Box ml={2} mr={2}>
          <TextField
              className={classes.root}
              classes={{root: 'search-number'}}
              label="Номер фонда"
              id="fundNumber"
              defaultValue=""
              variant="outlined"
              size="small"
            />
        </Box>

        <Box mr={2}>
          {/* <TextField
            className={classes.root}
            classes={{root: 'search-name'}}
            label="Название фонда"
            id="fundName"
            defaultValue=""
            variant="outlined"
            size="small"
            list="fundNames"
          /> */}

          <input type="text" list="fundNames" id="fundName" onChange={()=>search(this)}/>

          <datalist id="fundNames">
            <option value="Тест"></option>
          </datalist>
        </Box>

        <Button variant="contained" onClick={()=>search(this)}  style={{boxShadow: "none"}} 
            className={classes.btnColor}>Вывести</Button>
      </form>
      
      {/* Кнопки создания и редактирования фонда */}
      <div className="create-edit-foundation">
        <Box mr={1}>
          {/* чтобы открыть модалку редактировани фонда нужно добавить onClick={() => props.setActive2(true)}*/} 
          <Button variant="contained" classes={{root:'create-edit-buttons'}} className={classes.btnColor} style={{boxShadow: "none"}}>Редактировать</Button>
        </Box>
        
        <Box>
        <Button variant="contained" onClick={() => props.setActive(true)} classes={{root:'create-edit-buttons'}} className={classes.btnColor} style={{boxShadow: "none"}}>Добавить новый</Button>
        </Box>
      </div>

      {/* Кол-во дел в буфере */}
      <Box mr={2}>
        <TextField
          classes={{root:'output-buffer'}}
          disabled
          id="outlined-disabled"
          label="Дел в буфере"
          defaultValue="0"
          variant="outlined"
        />
      </Box>
    </div>
    


    // <section className="search-block">
    //   <fieldset className="search-group">
    //     <legend style={{alignItems: "center"}}>Фонд</legend>

    //     <label htmlFor="number" className="search-lable">Номер</label>
    //     <input type="text" id="number" className="search-number" />

    //     <label htmlFor="name" className="search-lable">Название</label>
    //     <input type="text" id="name" className="search-name"/>

    //     <button className="search-button">Вывести</button>
    //   </fieldset>

    //   <div className="create-edit-foundation">
    //     <button className="create-foundation" onClick={() => props.setActive(true)}>Добавить новый</button>
    //     <button className="edit-foundation">Редактировать</button>
    //   </div>

    //   <div className="buffer-block">
    //   <label htmlFor="buffer">Дел в буфере</label>
    //   <input type="text" id="buffer" className="output-buffer" disabled="disabled"/>
    //   </div>
    // </section>
  )
}

export default Search;