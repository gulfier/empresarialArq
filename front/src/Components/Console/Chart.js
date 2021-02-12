import React, {useEffect} from 'react';
import { useTheme } from '@material-ui/core/styles';
import { LineChart, Line, XAxis, YAxis, Label, ResponsiveContainer } from 'recharts';
import Title from './Title';

// Generate Sales Data
function createData(time, amount) {
  return { time, amount };
}

// const data = [
//   createData('01/NOV/20', 0),
//   createData('15/NOV/20', 300),
//   createData('01/DIC/20', 600),
//   createData('15/DIC/20', 800),
//   createData('01/ENE/21', 1500),
//   createData('15/ENE/21', 2000),
//   createData('01/FEB/21', 2400),
//   createData('15/FEB/21', 2400),
//   createData('01/MAR/21', undefined),
// ];

var data = [];

export default function Chart(props) {
  const theme = useTheme();

  var dat={
    "puntos": [
      {date: "01/NOV/20", changes: 0},
      {date: "15/NOV/20", changes: 300},
      {date: "01/DIC/20", changes: 600},
      {date: "15/DIC/20", changes: 800},
      {date: "01/ENE/21", changes: 1500},
      {date: "15/ENE/21", changes: 2000},
      {date: "01/FEB/21", changes: 2400},
      {date: "15/FEB/21", changes: 2400},
      {date: "01/MAR/21", changes: undefined}
    ]
  };

  useEffect(() => {
    console.log("*******************Entro dat: ",props.graph, "type: ",typeof props.graph)
    if(props.graph!==undefined && props.graph!==null && props.graph!==""){
      var json = JSON.parse(props.graph);
      const copy = json;
      data = [];
      console.log("json",json);
      for(var key in json.puntos){
        console.log("mira: ",json.puntos[key].changes);
        data.push(createData(json.puntos[key].date+"", json.puntos[key].changes));
      }
    }
      // data.push(createData(punto.date, punto.changes));
  });

  console.log(JSON.stringify(dat));

  return (
    <React.Fragment>
      <Title>Hoy</Title>
      <ResponsiveContainer>
        <LineChart
          data={data}
          margin={{
            top: 16,
            right: 16,
            bottom: 0,
            left: 24,
          }}
        >
          <XAxis dataKey="time" stroke={theme.palette.text.secondary} />
          <YAxis stroke={theme.palette.text.secondary}>
            <Label
              angle={270}
              position="left"
              style={{ textAnchor: 'middle', fill: theme.palette.text.primary }}
            >
              Aplicaciones (cnt)
            </Label>
          </YAxis>
          <Line type="monotone" dataKey="amount" stroke={theme.palette.primary.main} dot={false} />
        </LineChart>
      </ResponsiveContainer>
    </React.Fragment>
  );
}