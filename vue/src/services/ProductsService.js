import axios from 'axios';

const http = axios.create({
    baseURL: "http://52.226.246.135:9000"
});

export default {

    getAllProducts(){
        return http.get('/products');
    },

    updateProduct(updatedProduct) {
        return http.put('/products/update', updatedProduct);
    },
}