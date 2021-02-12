import React from 'react';
import clsx from 'clsx';
import { makeStyles } from '@material-ui/core/styles';
import CssBaseline from '@material-ui/core/CssBaseline';
import Drawer from '@material-ui/core/Drawer';
import Box from '@material-ui/core/Box';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import List from '@material-ui/core/List';
import Typography from '@material-ui/core/Typography';
import Divider from '@material-ui/core/Divider';
import IconButton from '@material-ui/core/IconButton';
import Badge from '@material-ui/core/Badge';
import Container from '@material-ui/core/Container';
import Grid from '@material-ui/core/Grid';
import Paper from '@material-ui/core/Paper';
import Link from '@material-ui/core/Link';
import MenuIcon from '@material-ui/icons/Menu';
import ChevronLeftIcon from '@material-ui/icons/ChevronLeft';
import NotificationsIcon from '@material-ui/icons/Notifications';
import { mainListItems, secondaryListItems } from './listItems';
import { withRouter } from 'react-router-dom';

import ListItem from '@material-ui/core/ListItem';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';
import DashboardIcon from '@material-ui/icons/Dashboard';
import PeopleIcon from '@material-ui/icons/People';
import BarChartIcon from '@material-ui/icons/BarChart';
import LayersIcon from '@material-ui/icons/Layers';
import ListSubheader from '@material-ui/core/ListSubheader';
import AssignmentIcon from '@material-ui/icons/Assignment';
import ExitToAppIcon from '@material-ui/icons/ExitToApp';
import { connect } from 'react-redux';
import { removeToken } from "../../Actions/LogoutAction";

function Copyright() {
  return (
    <Typography variant="body2" color="textSecondary" align="center">
      {'Copyright © '}
      <Link color="inherit" href="https://material-ui.com/">
        PROSA
      </Link>{' '}
      {new Date().getFullYear()}
      {'.'}
    </Typography>
  );
}

const drawerWidth = 240;

const useStyles = makeStyles((theme) => ({
  root: {
    display: 'flex',
  },
  toolbar: {
    paddingRight: 24, // keep right padding when drawer closed
    backgroundColor: "#8e0000"
  },
  toolbarIcon: {
    display: 'flex',
    alignItems: 'center',
    justifyContent: 'flex-end',
    padding: '0 8px',
    ...theme.mixins.toolbar,
  },
  appBar: {
    zIndex: theme.zIndex.drawer + 1,
    transition: theme.transitions.create(['width', 'margin'], {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.leavingScreen,
    }),
  },
  appBarShift: {
    marginLeft: drawerWidth,
    width: `calc(100% - ${drawerWidth}px)`,
    transition: theme.transitions.create(['width', 'margin'], {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.enteringScreen,
    }),
  },
  backgroundGeneral: {
    backgroundColor: "#c62828",
  },
  menuButton: {
    marginRight: 36,
  },
  menuButtonHidden: {
    display: 'none',
  },
  title: {
    flexGrow: 1,
    color: "#fff",
  },
  drawerPaper: {
    position: 'relative',
    whiteSpace: 'nowrap',
    width: drawerWidth,
    transition: theme.transitions.create('width', {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.enteringScreen,
    }),
  },
  drawerPaperClose: {
    overflowX: 'hidden',
    transition: theme.transitions.create('width', {
      easing: theme.transitions.easing.sharp,
      duration: theme.transitions.duration.leavingScreen,
    }),
    width: theme.spacing(7),
    [theme.breakpoints.up('sm')]: {
      width: theme.spacing(9),
    },
  },
  appBarSpacer: theme.mixins.toolbar,
  content: {
    flexGrow: 1,
    height: '100vh',
    overflow: 'auto',
  },
  container: {
    paddingTop: theme.spacing(4),
    paddingBottom: theme.spacing(4),
  },
  paper: {
    padding: theme.spacing(2),
    display: 'flex',
    overflow: 'auto',
    flexDirection: 'column',
  },
  fixedHeight: {
    height: 240,
  },
}));

function Dashboard(props) {
  const classes = useStyles();
  const { history } = props;
  const [open, setOpen] = React.useState(false);
  const handleDrawerOpen = () => {
    setOpen(true);
  };
  const handleDrawerClose = () => {
    setOpen(false);
  };
  const fixedHeightPaper = clsx(classes.paper, classes.fixedHeight);

  function logOut(){
    window.localStorage.removeItem("token");
    window.localStorage.removeItem("login");
    props.removeToken();
    history.push('/login');
  }

  return (
    <div className={classes.root}>
      <CssBaseline />
      <AppBar position="absolute" className={clsx(classes.appBar, open && classes.appBarShift)}>
        <Toolbar className={classes.toolbar}>
          <IconButton
            edge="start"
            color="inherit"
            aria-label="open drawer"
            onClick={handleDrawerOpen}
            className={clsx(classes.menuButton, open && classes.menuButtonHidden)}
          >
            <MenuIcon />
          </IconButton>
          <Typography component="h1" variant="h6" noWrap className={classes.title}>
            {props.title}
          </Typography>
          <IconButton color="inherit">
            <Badge badgeContent={props.records} color="secondary">
              <NotificationsIcon color=""/>
            </Badge>
          </IconButton>
        </Toolbar>
      </AppBar>
      <Drawer
        variant="permanent"
        classes={{
            paper: clsx(classes.drawerPaper, !open && classes.drawerPaperClose, classes.backgroundGeneral)
        }}
        open={open}
      >
        <div className={classes.toolbarIcon}>
          <IconButton className={classes.backgroundGeneral} onClick={handleDrawerClose}>
            <ChevronLeftIcon style={{color:"#FFF"}}/>
          </IconButton>
        </div>
        <Divider/>
        <List>
          <div>
            <ListItem button onClick={()=> history.push('/console')}>
              <ListItemIcon>
                <DashboardIcon onClick={()=> history.push('/console')} color="primary"/>
              </ListItemIcon>
              <ListItemText onClick={()=> history.push('/console')} primary={<Typography style={{color: "#FFF"}}>Consola</Typography>}/>
            </ListItem>
            <ListItem button onClick={()=> history.push('/history')}>
              <ListItemIcon>
                <LayersIcon onClick={()=> history.push('/history')} color="primary"/>
              </ListItemIcon>
              <ListItemText onClick={()=> history.push('/history')} primary={<Typography style={{color: "#FFF"}}>Historial</Typography>}/>
            </ListItem>
            {/* <ListItem button>
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
            </ListItem> */}
          </div>
        </List>
        <Divider />
        <List>
          <div>
            {/* <ListSubheader inset style={{color: "#FFF", opacity: "10px"}}>Reportes</ListSubheader>
            <ListItem button>
              <ListItemIcon>
                <AssignmentIcon color="primary"/>
              </ListItemIcon>
              <ListItemText primary={<Typography style={{color: "#FFF"}}>Reporte 17/Nov/20</Typography>}/>
            </ListItem> */}
            <ListItem button onClick={logOut}>
              <ListItemIcon>
                <ExitToAppIcon color="primary"/>
              </ListItemIcon> 
              <ListItemText onClick={logOut} primary={<Typography style={{color: "#FFF"}}>LogOut</Typography>}/>
            </ListItem>
          </div>
        </List>
      </Drawer>
      <main className={classes.content}>
        <div className={classes.appBarSpacer} />
        <Container maxWidth="lg" className={classes.container}>
          <Grid container spacing={3}>
            {props.children}
          </Grid>
          <Box pt={4}>
            <Copyright />
          </Box>
        </Container>
      </main>
    </div>
  );
}

function mapStateToProps (state) {
  console.log("token",state);
  return{
    ...state,
    token: state.login.data,
    records: state.console.data.response.changes.records,
  };
}

export default connect (mapStateToProps, { removeToken })(withRouter(Dashboard));