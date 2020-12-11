import './DetailChangePopup.css';
import React, {useEffect} from 'react';
import DialogPopup from '../../Dialogs/Dialog/DialogPopup';
import AppsIcon from '@material-ui/icons/Apps';
import StorageIcon from '@material-ui/icons/Storage';

function DetailChangePopup(props) {
    const [open, setOpen] = React.useState(false);
  
    useEffect(() => {
        // console.log("props",props);
        setOpen(props.open);
    });
  
    const handleClose = () => {
        props.onClose();
    };

    function createFields(data){
        var fields = [];
        for(var clave in data){
            // console.log(data[clave]);
            if(clave+"" !== "id"){
                fields.push( <div className="row Object-table ml-1 mr-1">
                                <div className="col-5 pr-0">
                                    <div className="d-flex justify-content-center">
                                        {clave}
                                    </div>
                                </div>
                                <div className="col pr-0">
                                    <div className="d-flex justify-content-center Detail-Before">
                                        {data[clave]}
                                    </div>
                                </div>
                                <div className="col pl-0">
                                    <div className="d-flex justify-content-center Detail-After">
                                        {data[clave]}
                                    </div>
                                </div>
                            </div>);
            }
        }
        return fields;
    }

    function createObject(data){
        var objects = [];
        for(var clave in data){
            if(typeof data[clave] === "object"){
                for(var object in data[clave]){
                    objects.push(   <div className="Detail-object card p-0 col mr-3">
                                        <div className="Title-Detail d-flex justify-content-center">
                                            <StorageIcon/>
                                            {clave+": "+data[clave][object].id}
                                        </div>
                                        {createFields(data[clave][object])}
                                    </div>);
                }
            }
        }
        return objects;
    }

    function createDetail(){
        for(var clave in props.response){
            // console.log("esta wueno",props.response[clave]);
            return  <div className="Detail p-0 row">
                        <div className="Title-Detail d-flex justify-content-center">
                            <AppsIcon/>
                            {clave+ ":"+props.response[clave].id_app}
                        </div>
                        <div className="row m-2">
                            {createObject(props.response[clave])}
                        </div>
                    </div>;
        }
    }
  
    return (
        <DialogPopup onClose={handleClose} open={open} dialogTitle={props.id}>
        <div className="Detail-Component row">
            <div className="row">
                <div className="col">
                    Antes:
                </div>
                <div className="col">
                    <div className="blue-square"></div>
                </div>
                <div className="col">
                    Despues:
                </div>
                <div className="col">
                    <div className="green-square"></div>
                </div>
            </div>
            <div className="col-11 m-2">
                {createDetail()}
            </div>
        </div>
      </DialogPopup>
    );
  }
  
export default DetailChangePopup;