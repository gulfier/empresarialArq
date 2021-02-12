import React from 'react';
import Link from '@material-ui/core/Link';
import { makeStyles } from '@material-ui/core/styles';
import Typography from '@material-ui/core/Typography';
import Title from './Title';

function preventDefault(event) {
  event.preventDefault();
}

const useStyles = makeStyles({
  depositContext: {
    flex: 1,
  },
});

export default function Deposits(props) {
  const classes = useStyles();
  const today = new Date();
  var meses = new Array ("Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre");
  const stringDate = today.getDate() + " / " + (meses[today.getMonth()]) + " / " + today.getFullYear()
  return (
    <React.Fragment>
      <Title>Cambios identificados</Title>
      <Typography component="p" variant="h4">
        {props.records}
      </Typography>
      <div className="mt-5">
        <Typography color="textSecondary" className={classes.depositContext}>
          { stringDate }
        </Typography>
      </div>
    </React.Fragment>
  );
}