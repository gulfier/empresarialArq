import React from 'react';
import ListItem from '@material-ui/core/ListItem';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';
import ListSubheader from '@material-ui/core/ListSubheader';
import DashboardIcon from '@material-ui/icons/Dashboard';
import PeopleIcon from '@material-ui/icons/People';
import BarChartIcon from '@material-ui/icons/BarChart';
import LayersIcon from '@material-ui/icons/Layers';
import AssignmentIcon from '@material-ui/icons/Assignment';
import Typography from '@material-ui/core/Typography';
import ExitToAppIcon from '@material-ui/icons/ExitToApp';

export function logOut(){
  //window.localStorage.removeItem("login");
}

export const mainListItems = (
  <div>
    <ListItem button>
      <ListItemIcon>
        <DashboardIcon color="primary"/>
      </ListItemIcon>
      <ListItemText primary={<Typography style={{color: "#FFF"}}>Dashboard</Typography>}/>
    </ListItem>
    <ListItem button>
      <ListItemIcon>
        <LayersIcon color="primary"/>
      </ListItemIcon>
      <ListItemText primary={<Typography style={{color: "#FFF"}}>Historial</Typography>}/>
    </ListItem>
    <ListItem button>
      <ListItemIcon>
        <PeopleIcon color="primary"/>
      </ListItemIcon>
      <ListItemText primary={<Typography style={{color: "#FFF"}}>Administración</Typography>}/>
    </ListItem>
    <ListItem button>
      <ListItemIcon>
        <BarChartIcon color="primary"/>
      </ListItemIcon>
      <ListItemText primary={<Typography style={{color: "#FFF"}}>Reportes</Typography>}/>
    </ListItem>
  </div>
);

export const secondaryListItems = (
  <div>
    <ListSubheader inset style={{color: "#FFF", opacity: "10px"}}>Reportes</ListSubheader>
    <ListItem button>
      <ListItemIcon>
        <AssignmentIcon color="primary"/>
      </ListItemIcon>
      <ListItemText primary={<Typography style={{color: "#FFF"}}>Reporte 17/Nov/20</Typography>}/>
    </ListItem>
    <ListItem button onClick={logOut}>
      <ListItemIcon>
        <ExitToAppIcon color="primary"/>
      </ListItemIcon> 
      <ListItemText primary={<Typography style={{color: "#FFF"}}>LogOut</Typography>}/>
    </ListItem>
  </div>
);