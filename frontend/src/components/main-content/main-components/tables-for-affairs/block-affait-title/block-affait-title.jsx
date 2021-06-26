import React from 'react';
import { makeStyles, TextField } from '@material-ui/core';

function AffairTitle(props) {

  const useStyles = makeStyles((theme) => ({
  root: { 
    '& label': {
      fontSize: 100,
    },
  },
}));

  const classes = useStyles();

  return(
    <div className="block-affair-title">
      <TextField id="outlined-basic" label={props.title} variant="outlined" 
          size="small" className={classes.root} className="input-affair-title"/>
    </div>
  )

}

export default AffairTitle;