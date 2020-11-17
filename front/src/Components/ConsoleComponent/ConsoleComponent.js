import './ConsoleComponent.css';
import React from 'react';
import Form from 'react-bootstrap/Form';
import DataTable from 'react-data-table-component';
import { createStyles, makeStyles, Theme } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import SearchIcon from '@material-ui/icons/Search';
import CheckCircleOutlineIcon from '@material-ui/icons/CheckCircleOutline';
import HighlightOffIcon from '@material-ui/icons/HighlightOff';

const useStyles = makeStyles((theme) =>
  createStyles({
    container: {
      display: 'flex',
      flexWrap: 'wrap',
    },
    textField: {
      marginLeft: theme.spacing(1),
      marginRight: theme.spacing(1),
      width: 200,
    },
  }),
);

const data = [{ id: 1,date:"17-08-20", object: 'Base de Datos QWER', code: 'DBOQ0290',
                type: 'Database', autor: 'Juan Pérez', actions: 'Aceptar  Declinar'},];
const columns = [
  {
    name: 'Fecha',
    selector: 'date',
    sortable: true,
    center: true,
  },
  {
    name: 'Objeto',
    selector: 'object',
    sortable: true,
    center: true,
  },
  {
    name: 'Código',
    selector: 'code',
    sortable: true,
    right: true,
    center: true,
  },
  {
    name: 'Tipo',
    selector: 'type',
    sortable: true,
    right: true,
    center: true,
  },
  {
    name: 'Autor',
    selector: 'autor',
    sortable: true,
    right: true,
    center: true,
  },
  {
    name: 'Acciones',
    selector: 'actions',
    sortable: true,
    right: true,
    center: true,
    cell: row => <div><CheckCircleOutlineIcon style={{color: "#0F0"}}/><HighlightOffIcon style={{color: "#F00"}}/></div>
  }
];

function ConsoleComponent() {
    const classes = useStyles();
  return (
    <div className="Console">
        <div className="row">
            <div className="col">
                <Form.Control placeholder="Aplicativo" />
            </div>
            <div className="col">
                <Form.Control placeholder="Base de datos" />
            </div>
            <div className="col">
                <Form.Label className="mr-sm-2" htmlFor="inlineFormCustomSelect" srOnly>
                    Preference
                </Form.Label>
                <Form.Control
                    as="select"
                    className="mr-sm-2"
                    id="inlineFormCustomSelect"
                    custom
                >
                    <option value="0">Site</option>
                    <option value="1">One</option>
                    <option value="2">Two</option>
                    <option value="3">Three</option>
                </Form.Control>
            </div>
            <div className="col">
                <form className={classes.container} noValidate>
                    <TextField
                        id="date"
                        label=""
                        type="date"
                        defaultValue="2017-05-24"
                        className={classes.textField}
                        InputLabelProps={{
                        shrink: true,
                        }}
                    />
                </form>
            </div>
            <div className="col-auto">
                <SearchIcon/>
            </div>
        </div>
        <DataTable
            columns={columns}
            data={data}
            theme="Table"
        />
    </div>
  );
}

export default ConsoleComponent;
