import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {

    getAllSales(){
        return http.get('/sales');
    },

    // getSalesByDate(){
    //     return http.get(`/sales/${startDate}/${endDate}`);
    // },

    // createSale(sale){
    //     return http.post(`/sales/create`, newSale)
    // }

}