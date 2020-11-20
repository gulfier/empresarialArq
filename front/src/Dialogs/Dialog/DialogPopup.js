import React, { useState, useEffect } from 'react';
import { withStyles } from '@material-ui/core/styles';
import Button from '@material-ui/core/Button';
import Dialog from '@material-ui/core/Dialog';
import MuiDialogTitle from '@material-ui/core/DialogTitle';
import MuiDialogContent from '@material-ui/core/DialogContent';
import MuiDialogActions from '@material-ui/core/DialogActions';
import IconButton from '@material-ui/core/IconButton';
import CloseIcon from '@material-ui/icons/Close';
import Typography from '@material-ui/core/Typography';
import "./DialogPopup.css";

const styles = (theme) => ({
  root: {
    margin: 0,
    padding: theme.spacing(2),
  },
  closeButton: {
    position: 'absolute',
    right: theme.spacing(1),
    top: theme.spacing(1),
    color: theme.palette.grey[500],
  },
});

const DialogTitle = withStyles(styles)((props) => {
  const { children, classes, onClose, ...other } = props;
  return (
    <MuiDialogTitle disableTypography className={classes.root} {...other}>
      <Typography variant="h6">{children}</Typography>
      {onClose ? (
        <IconButton aria-label="close" className={classes.closeButton} onClick={onClose}>
          <CloseIcon />
        </IconButton>
      ) : null}
    </MuiDialogTitle>
  );
});

const DialogContent = withStyles((theme) => ({
  root: {
    padding: theme.spacing(2),
  },
}))(MuiDialogContent);

const DialogActions = withStyles((theme) => ({
  root: {
    margin: 0,
    padding: theme.spacing(1),
  },
}))(MuiDialogActions);

export default function DialogPopup(props) {
  const [open, setOpen] = React.useState(false);

  useEffect(() => {
    console.log("props",props);
    setOpen(props.open);
  });

  const handleClose = () => {
    props.onClose();
  };

  return (
    <div>
      <Dialog onClose={handleClose} fullWidth={true} aria-labelledby="customized-dialog-title" open={open}>
        {props.dialogTitle && <DialogTitle id="customized-dialog-title" onClose={handleClose}>
          {props.dialogTitle}
        </DialogTitle>}
        {!props.dialogTitle &&  <div className="ml-auto p-2">
                                    <IconButton aria-label="close" onClick={handleClose}>
                                        <CloseIcon />
                                    </IconButton>
                                </div>}
        <DialogContent dividers>
          {props.children}
        </DialogContent>
        <DialogActions>
          <Button autoFocus onClick={handleClose} color="primary">
            Aceptar
          </Button>
          <Button autoFocus onClick={handleClose} color="primary">
            Rechazar
          </Button>
          <Button autoFocus onClick={handleClose} color="primary">
            Cerrar
          </Button>
        </DialogActions>
      </Dialog>
    </div>
  );
}