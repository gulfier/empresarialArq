import {http} from '../Util/scripts/http.service';

export function getDataConsola(){
    return http.get('/',{
        headers: {
            'X-FORWARDED-FOR': '192.168.1.180',
            Authorization: 'Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJndWlsbGVybW8uc2VndXJhQGF4aXR5LmNvbSIsImF1ZCI6IkludGVyZmF6Ok1lZ2EvUmVtZWR5Iiwic2NwIjoiYXBpL3BlcnNpc3RlbmNlIiwiaXNzIjoiaHR0cHM6Ly93d3cucHJvc2FtZXhpY28ubXgvIiwiZXhwIjo2MTYwNzkzNjI2MSwiaWF0IjoxNjA3OTM2MzIxfQ.J_gAk5pwbXjpm6aLF-mBIes66vKvpLIBWMZsoFxo6v4'
        }
       });
}
