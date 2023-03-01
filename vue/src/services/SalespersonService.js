import axios from 'axios';

const http = axios.create({
    baseURL: "http://52.226.246.135:9000"
});

export default {

    getAllSalespersons(){
        return http.get('/salespersons');
    },

    updateSalesperson(employee) {
         return http.put('/salespersons/update', employee);
     },
}