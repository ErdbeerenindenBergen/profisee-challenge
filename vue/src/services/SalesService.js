import axios from 'axios';

const http = axios.create({
    baseURL: "http://52.226.246.135:9000"
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