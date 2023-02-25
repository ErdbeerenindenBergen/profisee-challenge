<template>
    <div id="products-page">
        <div id="see-all-products-tab">
            <products-display class="card" v-for="product in products" :key="product.productId" v-bind:product="product">
            </products-display>
        </div>
    </div>
</template>

<script>
import ProductsService from "../services/ProductsService.js";
import ProductsDisplay from '../components/ProductsDisplay.vue';

export default {
    name: "products-details",
    components: {
        ProductsDisplay,
    },
    data() {
        return {
            products: [],
        }
    },
    created() {
        ProductsService.getAllProducts().then((response) => {
            this.products = response.data;
        })
    }
}
</script>

<style>
</style>