import React from "react";
import {Button, Menu , MenuItem, makeStyles} from '@material-ui/core'
import "./header.css"


// Названия функций с большой буквы так как это компонент
  function Header () {

    const [anchorEl, setAnchorEl] = React.useState(null);

  const handleClick = (event) => {
    setAnchorEl(event.currentTarget);
  };

  const handleClose = () => {
    setAnchorEl(null);
  };

    return (
      <div className="header">
        <div className="main-menu">
          <Button aria-controls="simple-menu" aria-haspopup="true" onClick={handleClick}>
            Файл
          </Button>
          <Menu
            id="simple-menu"
            anchorEl={anchorEl}
            keepMounted
            open={Boolean(anchorEl)}
            onClose={handleClose}
          >
            <MenuItem onClick={handleClose}>Первый элемент</MenuItem>
            <MenuItem onClick={handleClose}>Второй элемент</MenuItem>
            <MenuItem onClick={handleClose}>Третий элемент</MenuItem>
          </Menu>

          <Button aria-controls="simple-menu" aria-haspopup="true" onClick={handleClick}>
            Справочники
          </Button>
          <Menu
            id="simple-menu"
            anchorEl={anchorEl}
            keepMounted
            open={Boolean(anchorEl)}
            onClose={handleClose}
          >
            <MenuItem onClick={handleClose}>Первый элемент</MenuItem>
            <MenuItem onClick={handleClose}>Второй элемент</MenuItem>
            <MenuItem onClick={handleClose}>Третий элемент</MenuItem>
          </Menu>

          <Button aria-controls="simple-menu" aria-haspopup="true" onClick={handleClick}>
            Печать отчетов
          </Button>
          <Menu
            id="simple-menu"
            anchorEl={anchorEl}
            keepMounted
            open={Boolean(anchorEl)}
            onClose={handleClose}
          >
            <MenuItem onClick={handleClose}>Первый элемент</MenuItem>
            <MenuItem onClick={handleClose}>Второй элемент</MenuItem>
            <MenuItem onClick={handleClose}>Третий элемент</MenuItem>
          </Menu>

          <Button aria-controls="simple-menu" aria-haspopup="true" onClick={handleClick}>
            Поиск дел
          </Button>
          <Menu
            id="simple-menu"
            anchorEl={anchorEl}
            keepMounted
            open={Boolean(anchorEl)}
            onClose={handleClose}
          >
            <MenuItem onClick={handleClose}>Первый элемент</MenuItem>
            <MenuItem onClick={handleClose}>Второй элемент</MenuItem>
            <MenuItem onClick={handleClose}>Третий элемент</MenuItem>
          </Menu>

          <Button aria-controls="simple-menu" aria-haspopup="true" onClick={handleClick}>
            Сервис
          </Button>
          <Menu
            id="simple-menu"
            anchorEl={anchorEl}
            keepMounted
            open={Boolean(anchorEl)}
            onClose={handleClose}
          >
            <MenuItem onClick={handleClose}>Первый элемент</MenuItem>
            <MenuItem onClick={handleClose}>Второй элемент</MenuItem>
            <MenuItem onClick={handleClose}>Третий элемент</MenuItem>
          </Menu>

          <Button aria-controls="simple-menu" aria-haspopup="true" onClick={handleClick}>
            Помощь
          </Button>
          <Menu
            id="simple-menu"
            anchorEl={anchorEl}
            keepMounted
            open={Boolean(anchorEl)}
            onClose={handleClose}
          >
            <MenuItem onClick={handleClose}>Первый элемент</MenuItem>
            <MenuItem onClick={handleClose}>Второй элемент</MenuItem>
            <MenuItem onClick={handleClose}>Третий элемент</MenuItem>
          </Menu>
      </div> 
      
      <Button>Войти</Button>
    </div>
    )
  }

  export default Header;