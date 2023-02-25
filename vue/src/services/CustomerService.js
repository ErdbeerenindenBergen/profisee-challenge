import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {

    getAllCustomers(){
        return http.get('/customers');
    },

    updateCustomer(updatedCustomer) {
        return http.put('/customers/update', updatedCustomer);
    },
}