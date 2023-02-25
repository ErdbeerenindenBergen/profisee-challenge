<template>
    <div class="sales-card">
        <h2 id="product-name">Product: {{ sale.productName }}</h2>
        <h4 id="customer-name">Customer: {{ sale.customerFirstName }} {{ sale.customerLastName }}</h4>
        <h4 id="date-of-sale">Date of Sale: {{ sale.saleDate }}</h4>
        <h4 id="sale-price">Sale price: {{ sale.salePrice }}</h4>
        <h4 id="salesperson-name">Salesperson: {{ sale.salespersonFirstName }} {{ sale.salespersonLastName }}</h4>
        <h4 id="commission-percent">Commission Percent: {{ sale.salepersonFirstName }}</h4>
        <h4 id="salesperson-commission">Commission: {{ sale.salespersonCommission }}</h4>
    </div>
</template>

<script>

export default {
    name: "sales-display",
    props: {
        sale: Object,
    },
    components: {},
    created() {
        this.userId = this.$store.state.user.id;
    },
    methods: {
        userIsLoggedIn() {
            let $loggedIn = false;
            if (this.userId != 0) {
                $loggedIn = true;
            } return $loggedIn;
        }
    }
}

</script>

<style scoped>
.sales-card{
 padding-left: 30px;
}

</style>