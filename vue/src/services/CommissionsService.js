import axios from 'axios';

const http = axios.create({
    baseURL: "http://52.226.246.135:9000"
});

export default {

    getCommissionReport(quarter, year, employeeId){
        return http.get(`/commissions/${quarter}/${year}/${employeeId}`);
    },

    getAllCommissionReports(quarter, year){
        return http.get(`/commissions/${quarter}/${year}`);
    },
}