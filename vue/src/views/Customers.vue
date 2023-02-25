<template>
    <div id="customer-page">
        <div id="see-all-customers-tab">
            <customer-display class="card" v-for="customer in customers" :key="customer.customerId" v-bind:customer="customer">
            </customer-display>
        </div>
    </div>
</template>

<script>
import CustomerService from "../services/CustomerService.js";
import CustomerDisplay from '../components/CustomerDisplay.vue';

export default {
    name: "customer-details",
    components: {
        CustomerDisplay,
    },
    data() {
        return {
            customers: [],
            updatedCustomer: {
                firstName: String,
                lastName: String,
                customerId: Number,
                streetAddress: String,
                town: String,
                employeeState: String,
                zipCode: Number,
                phone: Number,
                emailAddress: String,
                startDate: Date
            }
        }
    },
    created() {
        CustomerService.getAllCustomers().then((response) => {
            this.customers = response.data;
        })
    }
}

</script>

<style>
</style>