<template>
    <div id="salesperson-page">
        <div id="see-all-sales-tab">
            <salespersons-display class="card" v-for="salesperson in salespersons" :key="salesperson.employeeId" v-bind:salesperson="salesperson">
            </salespersons-display>
        </div>
    </div>
</template>

<script>
import SalespersonService from "../services/SalespersonService.js";
import SalespersonsDisplay from '../components/SalespersonsDisplay.vue';

export default {
    name: "salesperson-details",
    components: {
        SalespersonsDisplay,
    },
    data() {
        return {
            salespersons: [],
            employee: {
                firstName: String,
                lastName: String,
                employeeId: Number,
                streetAddress: String,
                town: String,
                employeeState: String,
                zipCode: Number,
                phone: Number,
                emailAddress: String,
                startDate: Date,
                terminationDate: Date,
                managerFirstName: String,
                managerLastName: String
            }
        }
    },
    created() {
        SalespersonService.getAllSalespersons().then((response) => {
            this.salespersons = response.data;
        })
    }
}

</script>

<style>
</style>