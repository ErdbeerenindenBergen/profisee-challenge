<template>
    <div id="commissions-page">

        <div class="tab-buttons">
            <button type="button" id="see-all-commissions" class="button tab-button"
                :class="{ 'active-button': activeTab === 'allCommissions' }" @click="showSeeAllCommissions()">
                See All Commissions
            </button>
            <button type="button" id="filter-commissions-by-employee" class="button"
                @click="showFilterCommissionsByEmployee()">
                Filter Commissions by Employee
            </button>
        </div>

        <!-----------------------------------List Commissions By Quarter and Year----------------------------------->

        <form id="all-commissions-report-form" name="all-commissions-form" @submit.prevent="getAllCommissionReports()" 
        v-show="activeTab === 'allCommissions'">

            <div class="quarter-year-inputs">
                <div class="date-info-input">
                    <div>
                        <label class="input" for="quarter-input">Choose a quarter:</label>
                        <select class="quarter-input input-spaces" inputmode="numeric" id="quarter-input-full-report"
                            name="quarter-input-full-report" v-model="quarterFullReport">
                            <option value="1">1st Quarter</option>
                            <option value="2">2nd Quarter</option>
                            <option value="3">3rd Quarter</option>
                            <option value="4">4th Quarter</option>
                        </select>
                    </div>

                    <div class="year-input-container">
                        <label class="input" for="year-input">Year:</label>
                        <input id="year-input" class="input-spaces" type="number" min="1800" max="2099" step="1"
                            value="2023" v-model="yearFullReport" @keydown.enter.exact.prevent="getAllCommissionReports()"/>
                    </div>
                </div>

                <button type="button" id="get-all-commission-reports-button" class="submit-button button"
                    v-on:click="getAllCommissionReports()">
                    Search
                </button>

                <commissions-display class="card" v-for="commissionReport in commissionReports" :key="commissionReport.employeeId" v-bind:commissionReport="commissionReport">
                </commissions-display>

            </div>
        </form>

        <!-----------------------------------Filter Commissions By Employee----------------------------------->

        <form id="commission-report-form" name="commission-form" @submit.prevent="getCommissionReport()"  
        v-show="activeTab === 'getReportByEmployee'">

            <div class="quarter-year-inputs">
                <div class="date-info-input">
                    <div>
                        <label class="input" for="quarter-input">Choose a quarter:</label>
                        <select class="quarter-input input-spaces" inputmode="numeric" id="quarter-input"
                            name="quarter-input" v-model="quarter">
                            <option value="1">1st Quarter</option>
                            <option value="2">2nd Quarter</option>
                            <option value="3">3rd Quarter</option>
                            <option value="4">4th Quarter</option>
                        </select>
                    </div>

                    <div class="year-input-container">
                        <label class="input" for="year-input">Year:</label>
                        <input id="year-input" class="input-spaces" type="number" min="1800" max="2099" step="1"
                            value="2023" v-model="year" />
                    </div>
                </div>

                <div class="year-input">
                    <label class="input" for="employee-id-input">Employee ID:</label>
                    <input type="number" class="input-spaces" min="7001" step="1" value="7001" v-model="employeeId"
                        @keydown.enter.exact.prevent="getCommissionReport()" />
                </div>

                <button type="button" id="get-commission-report-button" class="submit-button button"
                    v-on:click="getCommissionReport()">
                    Search
                </button>

                <commissions-display class="card" v-bind:commissionReport="commissionReport">
                </commissions-display>

            </div>
        </form>

    </div>
</template>

<script>
import CommissionsService from "../services/CommissionsService.js";
import CommissionsDisplay from '../components/CommissionsDisplay.vue';

export default {
    name: 'commissions-details',
    components: {
        CommissionsDisplay,
    },
    data() {
        return {
            commissionReport: null,
            activeTab: 'allCommissions',
            commissionReports: [],
            quarter: 0,
            employeeId: 0,
            year: 0,
            quarterFullReport: 0,
            yearFullReport: 0
        }
    },
    methods: {
        getCommissionReport() {
            CommissionsService.getCommissionReport(this.quarter, this.year, this.employeeId).then((response) => {
                this.commissionReport = response.data;
            })
        },
        getAllCommissionReports(){
            CommissionsService.getAllCommissionReports(this.quarterFullReport, this.yearFullReport).then((response) => {
                this.commissionReports = response.data;
            })
        },
        showSeeAllCommissions() {
            this.activeTab = 'allCommissions';
        },
        showFilterCommissionsByEmployee() {
            this.activeTab = 'getReportByEmployee';
        },
    }
}

</script>

<style scoped>

.tab-buttons {
    display: flex;
    flex-direction: row;
    justify-content: space-evenly;
}

.date-info-input {
    margin-top: 45px;
    display: block;
}

#quarter-input {
    display: block;
}

h1 {
    font-family: Montserrat;
    color: #666666;
    font-weight: normal;
    text-align: center;
    padding-top: 15px;
}

.date-inputs {
    display: flex;
    justify-content: space-around;
    padding: 5px 100px;
}

a.router-link-active {
    font-weight: bold;
}

input {
    width: 350px;
    padding: 10px 15px;
    border: 3px solid lightgray;
    text-align: center;
    border-radius: 10px;
    font-size: 16px;
    margin-top: 15px;
    color: #5b5b5b;
}

label {
    text-align: center;
    margin: auto;
    font-family: Montserrat;
    font-weight: normal;
}

.button {
    background-color: #f0efef;
    color: #666666;
    border: none;
    text-decoration: none;
    font-size: 22px;
    font-weight: normal;
    font-family: Montserrat;
    border-radius: 10px;
    width: 200px;
    padding: 12px 12px;
    margin-top: 40px;
    display: flex;
}

.button:active {
    background-color: #b1b1b1;
    color: white;
}

.button:focus {
    background-color: #b1b1b1;
    color: white;
}

.input-spaces {
    display: block;
    padding: 10px 15px;
    border: 3px solid lightgray;
    border-radius: 10px;
    font-size: 16px;
    justify-content: center;
    margin: auto;
    margin-bottom: 15px;
    margin-top: 5px;
}

label {
    font-family: Montserrat;
    font-size: 23px;
}

select {
    display: none;
    border: none;
    font-family: Montserrat;
    color: #5b5b5b;
    font-size: 20px;
    padding: 0 15px 0 0;
}

option {
    padding: 5px;
}

.submit-button {
    margin: auto;
    margin-top: 30px;
    background-color: #124f5cff;
    color: white;
}

.submit-button:hover {
    background-color: rgb(40, 129, 149);
    cursor: pointer;
}

.submit-button:focus {
    background-color: #666666;
}
</style>