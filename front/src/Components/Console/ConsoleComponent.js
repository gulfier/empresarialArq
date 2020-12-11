import './ConsoleComponent.css';
import React from 'react';
import Form from 'react-bootstrap/Form';
import DataTable from 'react-data-table-component';
import { createStyles, makeStyles, Theme } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import SearchIcon from '@material-ui/icons/Search';
import CheckCircleOutlineIcon from '@material-ui/icons/CheckCircleOutline';
import HighlightOffIcon from '@material-ui/icons/HighlightOff';
import DetailChangePopup from '../../Dialogs/DetailChange/DetailChangePopup';
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
    name: 'Autor',
    selector: 'autor',
    sortable: true,
    right: true,
    center: true,
    compact: true,
  },
  {
    name: 'Acciones',
    selector: 'actions',
    sortable: true,
    right: true,
    center: true,
    cell: row => <div><CheckCircleOutlineIcon style={{color: "#0F0"}}/><HighlightOffIcon style={{color: "#F00"}}/></div>,
    compact: true,
  }
];

function ConsoleComponent() {
  const classes = useStyles();
  const [open, setOpen] = React.useState(false);

  const handleRowClicked = (event) =>{
    console.log("Entro handle",event);
    setOpen(true);
  }

  const handleClose = () => {
    setOpen(false);
  };

  let response = {
    applications: {
      id_app: 178283,
      ds_code: "HY648",
      ds_name: "Applicativo D",
      data_base: [
        {
          id: 378239,
          ds_code: "asdjdh8",
          ds_name: "Base 1",
          ds_algoritmo: "First",
          ds_algoritmo_change: "Second",
        },
        {
          id: 378239,
          ds_code: "asdjdh8",
          ds_name: "Base 1",
          ds_algoritmo: "First",
          ds_algoritmo_change: "Second",
        }
      ],
      servers: [
        {
          id: 38923,
          DS_CODE: "FKF78",
          DS_NAME: "APl 2",
          DT_CREATION: "27/09/19",
          DT_MODIFIED: "10/12/20",
          DS_USER_CREATION: "Jorge",
          DS_USER_MODIFICATION: "Jorge",
          DS_AMBIENTE: "Productivo",
          DS_HOST_NAME: "local",
          DS_DESCRIPCION: "LDDFNFf FIONIOFH",
          DS_PROPOSITO: "373",
          DS_MARCA_MODELO: "Microsoft",
          DS_VIRTUALIZACION: "4",
          DS_TIPO: "4",
          DS_PCI: "JDFI",
          FK_ID_RESPONSABLE: "32",
          FK_ID_UBICACION: "2",
        }
      ]
    }
  };

  return (
    <FrameComponent title="Cambios HOPEX">
      <div className="Console">
          <div className="row">
              <div className="col ml-4 pr-0">
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
              pagination
              selectableRows
              fixedHeader
              fixedHeaderScrollHeight="50vh"
              onRowClicked={handleRowClicked}
          />
          <DetailChangePopup onClose={handleClose} open={open} id="ID 72129398" response={response}/>
      </div>
    </FrameComponent>
  );
}

export default ConsoleComponent;
