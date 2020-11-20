import './HistoryComponent.css';
import React, {useState} from 'react';
import ConsoleComponent from '../Console/ConsoleComponent';

function HistoryComponent() {

  return (
    <div>
        <div className="row">
            Historial de cambios
        </div>
        <ConsoleComponent/>
    </div>
  );
}

export default HistoryComponent;
