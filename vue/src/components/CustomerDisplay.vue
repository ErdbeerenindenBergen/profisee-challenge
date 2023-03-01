<template>
    <div class="customer-card">

        <div class="customer-display-information" v-show="activeTab === 'info'">
            <div class="left-side-customers">
                <h2 id="customer-name">Name: {{ customer.firstName }} {{ customer.lastName }}</h2>
                <h4 id="customer-id">Customer Id: {{ customer.customerId }}</h4>
                <h4 id="customer-address">Address: {{ customer.streetAddress }} {{ customer.town }},
                    {{ customer.state }} {{ customer.zipCode }}</h4>
                <h4 id="customer-phone">Phone Number: {{ customer.phone }}</h4>
                <h4 id="customer-email-address">Email Address: {{ customer.emailAddress }}</h4>
                <h4 id="customer-start-date">Start Date: {{ customer.startDate }}</h4>
            </div>
        </div>

        <div class="customer-edit" v-show="activeTab === 'edits'">
            <div class="left-side-customers">

                <div class="form-line">
                    <label class="form-input-label" for="firstName">First Name:</label>
                    <input type="text" id="firstName" v-model="updatedCustomer.firstName">
                </div>
                <div class="form-line">
                    <label for="lastName">Last Name:</label>
                    <input type="text" id="lastName" v-model="updatedCustomer.lastName">
                </div>
                <div class="form-line">
                    <label for="customerId">Employee ID:</label>
                    <input type="text" id="customerId" v-model="updatedCustomer.customerId">
                </div>
                <div class="form-line">
                    <label for="streetAddress">Address:</label>
                    <input type="text" id="streetAddress" v-model="updatedCustomer.streetAddress">
                </div>
                <div class="form-line">
                    <label for="town">Town:</label>
                    <input type="text" id="town" v-model="updatedCustomer.town">
                </div>
                <div class="form-line">
                    <label for="employeeState">State:</label>
                    <input type="text" id="employeeState" v-model="updatedCustomer.state">
                </div>
                <div class="form-line">
                    <label for="zipCode">Zip Code:</label>
                    <input type="text" id="zipCode" v-model="updatedCustomer.zipCode">
                </div>
                <div class="form-line">
                    <label for="phone">Phone Number:</label>
                    <input type="text" id="phone" v-model="updatedCustomer.phone">
                </div>
                <div class="form-line">
                    <label for="emailAddress">Email Address:</label>
                    <input type="text" id="emailAddress" v-model="updatedCustomer.emailAddress">
                </div>
                <div class="form-line">
                    <label for="startDate">Start Date:</label>
                    <input type="date" id="startDate" v-model="updatedCustomer.startDate">
                </div>
            </div>
        </div>

        <div class="buttons">
            <div class="right-side-customers">
                <button class="edit-button button" id="see-edit-inputs" :class="{ 'active-button': activeTab === 'edits' }"
                    @click="toggleEditInputs()">
                    Edit</button>
            </div>
            <div class="right-side-customers">
                <button class="save-button button" v-show="activeTab === 'edits'"
                    v-on:click="updateCustomer()">Save</button>
            </div>
        </div>

    </div>
</template>

<script>

import CustomerService from "../services/CustomerService.js";

export default {
    name: "customers-display",
    props: {
        customer: Object,
    },
    components: {},
    data() {
        return {
            activeTab: 'info',
            updatedCustomer: {
                firstName: String,
                lastName: String,
                customerId: Number,
                streetAddress: String,
                town: String,
                state: String,
                zipCode: Number,
                phone: Number,
                emailAddress: String,
                startDate: Date,
            }
        }
    },
    created() {
        this.userId = this.$store.state.user.id;
        this.updatedCustomer = this.customer;
    },
    methods: {
        updateCustomer() {
            CustomerService.updateCustomer(this.customer).then((response) => {
                this.updatedCustomer = response.data;
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
            if (this.activeTab == 'edits') {
                this.activeTab = 'info';
            } else {
                this.activeTab = 'edits';
            }
        },
    }
}

</script>

<style scoped>
.customer-card {
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

@media screen and (max-width: 800px) and (min-width: 200px) {
    input {
        width: 150px;
    }
}
</style>