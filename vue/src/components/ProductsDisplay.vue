<template>
    <div class="products-card">

        <div class="products-display-information" v-show="activeTab === 'info'">
            <div class="left-side-products">
                <h2 id="product-name">Product Name: {{ product.name }}</h2>
                <h4 id="product-id">Product Id: {{ product.productId }}</h4>
                <h4 id="manufacturer">Manufacturer {{ product.manufacturer }}</h4>
                <h4 id="product-style">Style: {{ product.style }}</h4>
                <h4 id="product-purchase-price">Purchase Price: {{ product.purchasePrice }}</h4>
                <h4 id="product-sale-price">Sale Price: {{ product.salePrice }}</h4>
                <h4 id="quantity-on-hand">Number in Stock: {{ product.qtyOnHand }}</h4>
                <h4 id="commission-percent">Commission Percent: {{ product.commissionPercent }}</h4>
                <h4 id="upc-code">UPC Code: {{ product.upcCode }}</h4>
            </div>
        </div>


        <div class="products-edit" v-show="activeTab === 'edits'">
            <div class="edit-products">
                <div class="form-line">
                    <label class="form-input-label" for="name">Product Name:</label>
                    <input type="text" id="name" v-model="updatedProduct.name">
                </div>
                <div class="form-line">
                    <label for="productId">Product Id:</label>
                    <input type="text" id="productId" v-model="updatedProduct.productId">
                </div>
                <div class="form-line">
                    <label for="manufacturer">Manufacturer:</label>
                    <input type="text" id="manufacturer" v-model="updatedProduct.manufacturer">
                </div>
                <div class="form-line">
                    <label for="style">Style:</label>
                    <input type="text" id="style" v-model="updatedProduct.style">
                </div>
                <div class="form-line">
                    <label for="purchasePrice">Purchase Price:</label>
                    <input type="text" id="purchasePrice" v-model="updatedProduct.purchasePrice">
                </div>
                <div class="form-line">
                    <label for="salePrice">Sale Price:</label>
                    <input type="text" id="salePrice" v-model="updatedProduct.salePrice">
                </div>
                <div class="form-line">
                    <label for="qtyOnHand">Number in Stock:</label>
                    <input type="text" id="qtyOnHand" v-model="updatedProduct.qtyOnHand">
                </div>
                <div class="form-line">
                    <label for="commissionPercent">Commission Percent:</label>
                    <input type="text" id="commissionPercent" v-model="updatedProduct.commissionPercent">
                </div>
                <div class="form-line">
                    <label for="upcCode">UPC Code:</label>
                    <input type="text" id="upcCode" v-model="updatedProduct.upcCode">
                </div>
            </div>
        </div>

        <div class="buttons">
            <div class="right-side-products" >
                <button class="edit-button button" id="see-edit-inputs" 
                :class="{ 'active-button': activeTab === 'edits' }" @click="toggleEditInputs()">
                Edit</button>
            </div>
            <div class="right-side-products">
                <button class="save-button button"  v-show="activeTab === 'edits'" v-on:click="updateProduct()">Save</button>
            </div>
        </div>

    </div>
</template>

<script>

import ProductsService from "../services/ProductsService.js";

export default {
    name: "products-display",
    props: {
        product: Object,
    },
    components: {},
    data() {
        return {
            activeTab: 'info',
            updatedProduct: {
                productId: Number,
                name: String,
                manufacturer: String,
                style: String,
                purchasePrice: Number,
                salePrice: Number,
                qtyOnHand: Number,
                commissionPercent: Number,
                upcCode: Number
            }
        }
    },
    created() {
        this.userId = this.$store.state.user.id;
        this.updatedProduct = this.product;
    },
    methods: {
        updateProduct() {
            ProductsService.updateProduct(this.updatedProduct).then((response) => {
                this.updatedProduct = response.data;
            })
            this.$router.go();
        },
        userIsLoggedIn() {
            let $loggedIn = false;
            if (this.userId != 0) {
                $loggedIn = true;
            } return $loggedIn;
        },
        toggleEditInputs() {
            if(this.activeTab == 'edits') {
                this.activeTab = 'info';
            } else {
                this.activeTab = 'edits';
            }
        },
    }
}

</script>

<style scoped>
.products-card {
    padding-left: 30px;
    padding-top: 30px;
}

input {
    width: 350px;
    align-self: center;
    padding: 10px 15px;
    border: 3px solid lightgray;
    text-align: center;
    justify-content: center;
    border-radius: 10px;
    font-size: 16px;
    display: flex;
    flex-grow: 0;
    margin-left: 10px;
}

.form-line {
    display: inline-block;
    margin: 10px 0;
}

.form-input-label {
    text-align: center;
}

.buttons {
    display: flex;
}

.button {
    border: none;
    text-decoration: none;
    font-size: 22px;
    font-weight: normal;
    font-family: Montserrat;
    border-radius: 10px;
    width: 130px;
    padding: 12px 12px;
    margin: 0px 10px 0;
    background-color: #124f5cff;
    color: white;
}

.button:hover {
    background-color: rgb(40, 129, 149);
    cursor: pointer;
}

.button:focus {
    background-color: #666666;
}

.save-button {
    background-color: rgb(21, 134, 91);
}

.save-button:hover {
    background-color: rgb(31, 170, 117);
}
</style>