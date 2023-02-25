import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
});

export default {

    getAllProducts(){
        return http.get('/products');
    },

    updateProduct(updatedProduct) {
        return http.put('/products/update', updatedProduct);
    },
}