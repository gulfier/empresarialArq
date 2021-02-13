import './HistoryComponent.css';
import React, {useEffect,useState} from 'react';
import Form from 'react-bootstrap/Form';
import DataTable from 'react-data-table-component';
import { createStyles, makeStyles, Theme } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import SearchIcon from '@material-ui/icons/Search';
import DialogPopup from '../../Dialogs/Dialog/DialogPopup';
import FrameComponent from '../Frame/FrameComponent';
import { withRouter } from 'react-router-dom';
import { getHistory } from "../../Actions/HistoryAction";
import { connect } from 'react-redux';
import moment from 'moment';

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

function HistoryComponent(props) {
  const classes = useStyles();
  const [open, setOpen] = React.useState(false);
  const [filters, setFilters] = useState({
    type: '',
    fromDate: '',
    toDate: ''
  });

  useEffect(() => {
    var d = new Date();
    console.log("Date: ",d.getTime());
    props.getHistory(props.token.response.token,"",0,
                      0,1,10);
    console.log("props",props);
  },[]);

  const handleRowClicked = (event) =>{
    console.log("Entro handle",event);
    setOpen(true);
  }

  const handleClose = () => {
    setOpen(false);
  };

  const handleApi = (data) =>{
    var dataTable = [];
    if(data !== undefined){
      for(var key in data.response.data){
        dataTable.push({ id: key, date:data.response.data[key].fecha.split("T")[0],
          object: data.response.data[key].dsTipo,
          code: data.response.data[key].dsCodigo,
        type: data.response.data[key].dsTipo,
        autor: data.response.data[key].dsAutor,
        actions: 'Aceptar  Declinar',
        dsCambioActual: data.response.data[key].dsCambioActual,
        dsCambioAnterior: data.response.data[key].dsCambioAnterior},);
      }
    }
    return dataTable;
  }

  const handleInputChange = (event) => {
    // console.log(event.target.name)
    // console.log(event.target.value)
    setFilters({
        ...filters,
        [event.target.name] : event.target.value
    })
  }

  const handleFind = () => {
    console.log("Entro: ",filters,moment(filters.fromDate,"YYYY-MM-DD").utc().valueOf());
    var toDate = 0;
    var fromDate = 0;
    if(filters.fromDate!==""){
      fromDate = moment(filters.fromDate,"YYYY-MM-DD").utc().valueOf();
    }
    if(filters.toDate!==""){
      toDate = moment(filters.toDate,"YYYY-MM-DD").utc().valueOf();
    }
    props.getHistory(props.token.response.token,filters.type,fromDate,toDate,1,10);
  }

  return (
    <FrameComponent title="Historial cambios">
      <div className="Console">
        <div className="row pt-3" style={{backgroundColor:"#FFF"}}>
          <div className="col ml-5">
            <Form.Control name="type"
                          aria-describedby="emailHelp"
                          type="text"
                          placeholder="Tipo"
                          onChange={handleInputChange} />
          </div>
          <div className="col">
            <form className={classes.container} noValidate>
                <TextField
                    id="date"
                    label="De"
                    type="date"
                    name="fromDate"
                    onChange={handleInputChange}
                    defaultValue=""
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
                    name="toDate"
                    defaultValue=""
                    className={classes.textField}
                    InputLabelProps={{
                    shrink: true,
                    }}
                    onChange={handleInputChange}
                />
            </form>
          </div>
          <div className="col-auto mr-5">
              <SearchIcon onClick={handleFind}/>
          </div>
          <DataTable
              columns={columns}
              data={handleApi(props.infoHistory)}
              theme="Table"
              pagination
              selectableRows
              fixedHeader
              fixedHeaderScrollHeight="50vh"
              onRowClicked={handleRowClicked}
          />
        </div>
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

const mapStateToProps = (state) => ({
  infoHistory: state.history.data,
  token: state.login.data
});

export default connect (mapStateToProps, { getHistory })( withRouter(HistoryComponent));
