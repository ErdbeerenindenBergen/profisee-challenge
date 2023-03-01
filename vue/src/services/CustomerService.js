import axios from 'axios';

const http = axios.create({
    baseURL: "http://52.226.246.135:9000"
});

export default {

    getAllCustomers(){
        return http.get('/customers');
    },

    updateCustomer(updatedCustomer) {
        return http.put('/customers/update', updatedCustomer);
    },
}