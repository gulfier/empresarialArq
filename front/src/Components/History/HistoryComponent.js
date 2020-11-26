import './HistoryComponent.css';
import React from 'react';
import Form from 'react-bootstrap/Form';
import DataTable from 'react-data-table-component';
import { createStyles, makeStyles, Theme } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import SearchIcon from '@material-ui/icons/Search';
import DialogPopup from '../../Dialogs/Dialog/DialogPopup';
import FrameComponent from '../Frame/FrameComponent';

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

const data = [  { id: 1,date:"17-08-20", object: 'Base de Datos QWER', code: 'DBOQ0290',
                type: 'Database', autor: 'Juan Pérez', actions: 'Aceptar  Declinar'},
                { id: 2,date:"17-08-20", object: 'Base de Datos QWER', code: 'DBOQ0280',
                type: 'Database', autor: 'Juan Pérez', actions: 'Aceptar  Declinar'},
                { id: 3,date:"18-08-20", object: 'Servidor AST', code: 'S00004',
                type: 'Server', autor: 'Juan Pérez', actions: 'Aceptar  Declinar'},
                { id: 4,date:"17-08-20", object: 'IT Service QAW', code: 'ITS0003',
                type: 'IT Service', autor: 'Juan Pérez', actions: 'Aceptar  Declinar'},
                { id: 5,date:"17-08-20", object: 'Progreso de negocio - compras', code: 'BP0002',
                type: 'IBusiness process', autor: 'Juan Pérez', actions: 'Aceptar  Declinar'},
                { id: 6,date:"17-08-20", object: 'APR 01', code: 'APR001',
                type: 'Aplicacion', autor: 'Juan Pérez', actions: 'Aceptar  Declinar'},];

const columns = [
  {
    name: 'Fecha',
    selector: 'date',
    sortable: true,
    center: true,
    compact: true,
  },
  {
    name: 'Objeto',
    selector: 'object',
    sortable: true,
    center: true,
    compact: true,
  },
  {
    name: 'Código',
    selector: 'code',
    sortable: true,
    right: true,
    center: true,
    compact: true,
  },
  {
    name: 'Tipo',
    selector: 'type',
    sortable: true,
    right: true,
    center: true,
    compact: true,
  },
  {
    name: 'Autorizó',
    selector: 'autor',
    sortable: true,
    right: true,
    center: true,
    compact: true,
  }
];

function HistoryComponent() {
  const classes = useStyles();
  const [open, setOpen] = React.useState(false);

  const handleRowClicked = (event) =>{
    console.log("Entro handle",event);
    setOpen(true);
  }

  const handleClose = () => {
    setOpen(false);
  };

  return (
    <FrameComponent title="Historial cambios">
      <div className="Console">
        <div className="row">
            <div className="col">
                <Form.Control placeholder="Persona aurotizó" />
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
                        label="De"
                        type="date"
                        defaultValue="2017-05-24"
                        className={classes.textField}
                        InputLabelProps={{
                        shrink: true,
                        }}
                    />
                </form>
            </div>
            <div className="col">
                <form className={classes.container} noValidate>
                    <TextField
                        id="date"
                        label="Hasta"
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
            pagination
            selectableRows
            fixedHeader
            fixedHeaderScrollHeight="50vh"
            onRowClicked={handleRowClicked}
        />
        <DialogPopup onClose={handleClose} open={open} dialogTitle="ID 72129398">
          <div className="Detail-Component row">
            <div className="col-11 m-2">
              <div className="Detail p-0">
                  <div className="Title-Detail d-flex justify-content-center">
                    Detalle
                  </div>
                  <div className="">
                    Este es un cambio para el servidor X para promocionarlo a producción
                  </div>
              </div>
            </div>
            <div className="col-5 m-2">
              <div className="Detail card p-0">
                  <div className="Title-Detail d-flex justify-content-center">
                    Base de datos
                  </div>
                  <div className="row">
                      <div className="col pr-0">
                            <div className="row d-flex justify-content-center">
                              Antes
                            </div>
                            <div className="d-flex justify-content-center p-3 Detail-Before">
                              SQL lite
                            </div>
                      </div>
                      <div className="col pl-0">
                            <div className="row d-flex justify-content-center">
                              Despues
                            </div>
                            <div className="d-flex justify-content-center p-3 Detail-After">
                              Oracle
                            </div>
                      </div>
                  </div>
              </div>
            </div>
          </div>
        </DialogPopup>
      </div>
    </FrameComponent>
  );
}

export default HistoryComponent;
