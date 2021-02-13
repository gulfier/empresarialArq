import './ConsoleComponent.css';
import React, {useEffect} from 'react';
import clsx from 'clsx';
import Form from 'react-bootstrap/Form';
import DataTable from 'react-data-table-component';
import { createStyles, makeStyles, Theme } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import SearchIcon from '@material-ui/icons/Search';
import CheckCircleOutlineIcon from '@material-ui/icons/CheckCircleOutline';
import HighlightOffIcon from '@material-ui/icons/HighlightOff';
import DetailChangePopup from '../../Dialogs/DetailChange/DetailChangePopup';
import FrameComponent from '../Frame/FrameComponent';
import { connect } from 'react-redux';
import { getDataConsole } from "../../Actions/ConsoleAction";
import { withRouter } from 'react-router-dom';
import Box from '@material-ui/core/Box';
import Badge from '@material-ui/core/Badge';
import Container from '@material-ui/core/Container';
import Grid from '@material-ui/core/Grid';
import Paper from '@material-ui/core/Paper';
import Chart from './Chart';
import Deposits from './Deposits';

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

const columns = [
  {
    name: 'Fecha',
    selector: 'date',
    sortable: true,
    center: true,
    compact: true,
  },
  {
    name: 'Tipo',
    selector: 'type',
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
    name: 'Descripción',
    selector: 'description',
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

function ConsoleComponent(props) {
  const classes = useStyles();
  const { history } = props;
  const [open, setOpen] = React.useState(false);
  const [jsonDetail, setJsonDetail] = React.useState({});
  const [pagination, setPagination] = React.useState(1);

  const fixedHeightPaper = clsx(classes.paper, classes.fixedHeight);
  useEffect(() => {
    console.log("props.token",props.token.response.token);
    if(props.token.response.token==null){
      history.push('/login')
    }
    props.getDataConsole(props.token.response.token,pagination,10);
    console.log("props",props);
  },[]);

  const handleRowClicked = (event) =>{
    // console.log("Entro handle",event);
    setJsonDetail(JSON.parse(event.dsCambioAnterior));
    setOpen(true);
  }

  const handleClose = () => {
    setOpen(false);
  };

  const handleApi = (data) =>{
    var dataTable = [];
    if(data !== undefined){
      for(var key in data.response.changes.data){
        dataTable.push({ id: key, date:data.response.changes.data[key].fecha.split("T")[0],
          type: data.response.changes.data[key].dsTipo,
          code: data.response.changes.data[key].dsCodigo,
        description: data.response.changes.data[key].dsDescripcion,
        autor: data.response.changes.data[key].dsAutor,
        actions: 'Aceptar  Declinar',
        dsCambioActual: data.response.changes.data[key].dsCambioActual,
        dsCambioAnterior: data.response.changes.data[key].dsCambioAnterior},);
      }
    }
    return dataTable;
  }

  const handlerPagination = (event) =>{
    setPagination(pagination+1);
    props.getDataConsole(props.token.response.token,pagination,10);
  }

  return (
    <FrameComponent title="Cambios CMDB Oracle">
          <Grid item xs={12}>
              <div className="card">
                  {/* <div className="row">
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
                </div> */}
                <DataTable
                    columns={columns}
                    data={handleApi(props.infoConsole)}
                    theme="Table"
                    pagination={true}
                    paginationTotalRows={props.infoConsole.response.changes.records}
                    selectableRows
                    fixedHeader
                    fixedHeaderScrollHeight="50vh"
                    onRowClicked={handleRowClicked}
                    onChangePage={handlerPagination}
                />
                <DetailChangePopup onClose={handleClose} open={open} id="ID 72129398" response={jsonDetail}/>
              </div>
          </Grid>
          <div className="col-8">
            <div className="card p-3" style={{height: "100%"}}>
              <Chart graph={props.infoConsole.response.graph} />
            </div>
          </div>
          {/* Recent Deposits */}
          <div className="col-4">
            <div className="card p-5" style={{height: "100%"}}>
              <Deposits records={props.infoConsole.response.changes.records} />
            </div>
          </div>
    </FrameComponent>
  );
}

const mapStateToProps = (state) => ({
    infoConsole: state.console.data,
    token: state.login.data
});

export default connect (mapStateToProps, { getDataConsole })( withRouter(ConsoleComponent));
