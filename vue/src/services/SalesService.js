import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {

    getAllSales(){
        return http.get('/sales');
    },

    getSalesByDate(startDate, endDate){
        return http.get(`/sales/${startDate}/${endDate}`);
    },

    createSale(newSale){
        return http.post(`/sales/create`, newSale)
    }

}