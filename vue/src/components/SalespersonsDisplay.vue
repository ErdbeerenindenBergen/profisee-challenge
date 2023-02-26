<template>
    <div class="sales-card">

        <div class="salesperson-display-information" v-show="activeTab === 'info'">
            <div class="left-side-salespersons">
                <h2 id="salesperson-name">Salesperson: {{ salesperson.firstName }} {{ salesperson.lastName }}</h2>
                <h4 id="employee-id">Employee Id: {{ salesperson.employeeId }}</h4>
                <h4 id="salesperson-address">Address {{ salesperson.streetAddress }} {{ salesperson.town }},
                    {{ salesperson.state }} {{ salesperson.zipCode }}</h4>
                <h4 id="salesperson-phone">Phone Number: {{ salesperson.phone }}</h4>
                <h4 id="salesperson-email-address">Email Address: {{ salesperson.emailAddress }}</h4>
                <h4 id="salesperson-start-date">Start Date: {{ salesperson.startDate }}</h4>
                <h4 id="salesperson-termination-date">Termination Date: {{ salesperson.terminationDate }}</h4>
                <h4 id="salesperson-name">Manager: {{ salesperson.managerFirstName }} {{ salesperson.managerLastName }}</h4>
            </div>
        </div>


        <div class="salesperson-edit" v-show="activeTab === 'edits'">
            <div class="left-side-salespersons">

                <div class="form-line">
                    <label class="form-input-label" for="firstName">First Name:</label>
                    <input type="text" id="firstName" v-model="employee.firstName">
                </div>
                <div class="form-line">
                    <label for="lastName">Last Name:</label>
                    <input type="text" id="lastName" v-model="employee.lastName">
                </div>
                <div class="form-line">
                    <label for="employeeId">Employee ID:</label>
                    <input type="text" id="employeeId" v-model="employee.employeeId">
                </div>
                <div class="form-line">
                    <label for="streetAddress">Address:</label>
                    <input type="text" id="streetAddress" v-model="employee.streetAddress">
                </div>
                <div class="form-line">
                    <label for="town">Town:</label>
                    <input type="text" id="town" v-model="employee.town">
                </div>
                <div class="form-line">
                    <label for="employeeState">State:</label>
                    <input type="text" id="employeeState" v-model="employee.state">
                </div>
                <div class="form-line">
                    <label for="zipCode">Zip Code:</label>
                    <input type="text" id="zipCode" v-model="employee.zipCode">
                </div>
                <div class="form-line">
                    <label for="phone">Phone Number:</label>
                    <input type="text" id="phone" v-model="employee.phone">
                </div>
                <div class="form-line">
                    <label for="emailAddress">Email Address:</label>
                    <input type="text" id="emailAddress" v-model="employee.emailAddress">
                </div>
                <div class="form-line">
                    <label for="startDate">Start Date:</label>
                    <input type="date" id="startDate" v-model="employee.startDate">
                </div>
                <div class="form-line">
                    <label for="terminationDate">Termination Date:</label>
                    <input type="date" id="terminationDate" v-model="employee.terminationDate">
                </div>
                <!-- <div class="form-line">
                    <label for="managerFirstName">Manager First Name:</label>
                    <input type="text" id="managerFirstName" v-model="employee.managerFirstName">
                </div>
                <div class="form-line">
                    <label for="managerLastName">Manager Last Name:</label>
                    <input type="text" id="managerLastName" v-model="employee.managerLastName">
                </div> -->
                <div class="form-line">
                    <label for="idOfManager">ID of Manager:</label>
                    <input type="text" id="idOfManager" v-model="employee.idOfManager">
                </div>

            </div>
        </div>

        <div class="buttons">
            <div class="right-side-salespersons" >
                <button class="edit-button button" id="see-edit-inputs" 
                :class="{ 'active-button': activeTab === 'edits' }" @click="toggleEditInputs()">
                Edit</button>
            </div>
            <div class="right-side-salespersons">
                <button class="save-button button" v-show="activeTab === 'edits'" v-on:click="updateSalesperson()">Save</button>
            </div>
        </div>

    </div>
</template>

<script>

import SalespersonService from "../services/SalespersonService.js";

export default {
    name: "salespersons-display",
    props: {
        salesperson: Object,
    },
    components: {},
    data() {
        return {
            activeTab: 'info',
            employee: {
                firstName: String,
                lastName: String,
                employeeId: Number,
                streetAddress: String,
                town: String,
                state: String,
                zipCode: Number,
                phone: Number,
                emailAddress: String,
                startDate: Date,
                terminationDate: '',
                managerFirstName: String,
                managerLastName: String,
                idOfManager: Number
            }
        }
    },
    created() {
        this.userId = this.$store.state.user.id;
        this.employee = this.salesperson;
    },
    methods: {
        updateSalesperson() {
            SalespersonService.updateSalesperson(this.employee).then((response) => {
                this.employee = response.data;
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
.sales-card {
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