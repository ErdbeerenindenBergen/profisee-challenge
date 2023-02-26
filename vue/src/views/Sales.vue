<template>
    <div id="sales-page">

        <div class="tab-buttons">
            <button type="button" id="see-all-sales" class="button" :class="{ 'active-button': activeTab === 'allSales' }"
                @click="showSeeAllSales()">
                See All Sales
            </button>
            <button type="button" id="filter-sales-by-date" class="button" @click="showFilterSalesByDate()">
                Filter Sales by Date
            </button>
            <button type="button" id="add-new-sale" class="button" @click="showAddNewSale()">
                Add New Sale
            </button>
        </div>

        <div id="see-all-sales-tab" v-show="activeTab === 'allSales'">
            <sales-display class="card" v-for="sale in sales" :key="sale.saleId" v-bind:sale="sale">
            </sales-display>
        </div>

        <!-----------------------------------List Sales Within Date Range----------------------------------->
        <form id="event-form" name="form" @submit.prevent="filterSalesByDate()" v-show="activeTab === 'filterSalesByDate'">

            <div id="filter-sales-by-date-tab">
                <div class="date-inputs">
                    <div class="left-side-date">
                        <h2>Start Date:</h2>
                        <input type="date" class="date-input" name="start-date" v-model="startDate"
                            placeholder="mm/dd/yyyy" />
                    </div>

                    <div class="right-side-date">
                        <h2>End Date:</h2>
                        <input type="date" class="date-input" name="end-date" v-model="endDate" placeholder="mm/dd/yyyy"
                            @keydown.enter.exact.prevent="filterSalesByDate()" />
                    </div>
                </div>

                <button type="button" id="show-sales-by-date-button" class="submit-button button"
                    v-on:click="filterSalesByDate()">
                    Submit
                </button>

                <sales-display class="card" v-for="sale in salesByDate" :key="sale.saleId" v-bind:sale="sale">
                </sales-display>
            </div>
        </form>

        <!-----------------------------------------Add A New Sale----------------------------------------->

        <form class="add-new-sale" v-show="activeTab === 'addNewSale'">
            <div class="center-input">
                <label for="productId">Product ID:</label>
                <input class="input-spaces" type="text" id="sale-product-id" v-model="newSale.productId">
            </div>
            <div class="center-input">
                <label for="salespersonId">Salesperson ID:</label>
                <input class="input-spaces" type="text" id="sale-salesperson-id" v-model="newSale.salespersonId">
            </div>
            <div class="center-input">
                <label for="customerId">Customer ID:</label>
                <input class="input-spaces" type="text" id="sale-customer-id" v-model="newSale.customerId">
            </div>
            <div class="center-input">
                <label for="saleDate">Sale Date:</label>
                <input class="input-spaces" type="date" id="new-sale-sale-date" v-model="newSale.saleDate">
            </div>

            <button type="button" id="create-sale-button" class="submit-button button" v-on:click="createSale()">
                Submit
            </button>
        </form>

    </div>
</template>

<script>

import SalesService from '../services/SalesService.js';
import SalesDisplay from '../components/SalesDisplay.vue';

export default {
    name: 'sales-details',
    components: {
        SalesDisplay,
    },
    data() {
        return {
            sales: [],
            activeTab: 'allSales',
            salesByDate: [],
            startDate: new Date(),
            endDate: new Date(),
            isSubmitted: false,
            newSale: {
                productId: '',
                salespersonId: '',
                customerId: '',
                saleDate: '',
            }
        }
    },
    created() {
        SalesService.getAllSales().then((response) => {
            this.sales = response.data;
        });
    },
    methods: {
        filterSalesByDate() {
            let startDate = document.forms["form"]["start-date"].value;
            let endDate = document.forms["form"]["end-date"].value;
            if (startDate == null || startDate == "" ||
                endDate == null || endDate == ""
            ) {
                alert("Please be sure to enter a start date and end date.");
                return false;
            }
            this.formattedStartDate = this.moment(this.startDate).format("YYYY-MM-DD");
            this.formattedEndDate = this.moment(this.endDate).format("YYYY-MM-DD");
            SalesService.getSalesByDate(this.formattedStartDate, this.formattedEndDate).then((response) => {
                this.salesByDate = response.data;
                console.dir(this.salesByDate);
            });
        },
        createSale() {
            SalesService.createSale(this.newSale);
            this.$router.push({ name: 'sales-confirmation-page' });
        },
        showSeeAllSales() {
            this.activeTab = 'allSales';
        },
        showFilterSalesByDate() {
            this.activeTab = 'filterSalesByDate';
        },
        showAddNewSale() {
            this.activeTab = 'addNewSale';
        },
    }
}
</script>

<style scoped>
#event-form,
#invite-form {
    padding-top: 45px;
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
}

h2 {
    text-align: center;
    font-family: Montserrat;
    font-weight: normal;
}

#see-all-sales-tab {
    padding-top: 50px;
}

.tab-buttons {
    display: flex;
    flex-direction: row;
    justify-content: space-evenly;
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
    width: 15%;
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

#create-sale-button {
    background-color: #124f5cff;
    color: white;
}

#invite-button,
#restaurant-button {
    background-color: rgb(40, 129, 149);
    color: white;
    border: none;
    text-decoration: none;
    font-size: 15px;
    font-weight: bold;
    border-radius: 10px;
    width: 15%;
    height: 45px;
    padding: 12px 12px;
}

.center-input {
    margin: auto;
    text-align: center;
    align-items: center;
    margin-bottom: 20px;
}

.add-new-sale {
    margin-top: 40px;
}

placeholder {
    font-family: Montserrat;
    color: #909090;
}

input.date {
    justify-content: center;
    display: flex;
    align-content: center;
    margin: auto;
    margin-top: 60px;
}

body {
    padding-top: 15px;
    display: flex;
    order: bottom;
    z-index: -1;
}

p {
    font-size: 25px;
    display: flex;
    line-height: 5px;
    font-family: Montserrat;
    font-weight: normal;
}

input.input-spaces {
    display: block;
    padding: 10px 15px;
    border: 3px solid lightgray;
    border-radius: 10px;
    font-size: 16px;
    justify-content: center;
    margin: auto;
}


label {
    font-family: Montserrat;
    font-size: 23px;
}

select {
    display: none;
    border: none;
    font-family: Montserrat;
    color: #666666;
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


@media screen and (max-width: 1200px) {
    .container {
        padding-top: 15px;
        display: flex;
        flex-direction: column;
    }

    .left-panel {
        width: 30%;
        top: 175px;
        margin-top: 50px;
    }

    .right-panel {
        width: 100%;
        justify-content: center;
        text-align: center;
    }
}

@media screen and (max-width: 800px) and (min-width: 200px) {
    .container {
        display: flex;
    }

    .left-panel {
        width: 100%;
        padding-bottom: 20px;
    }

    .tab-buttons {
        flex-direction: row;
        margin-top: 25px;
    }

    .button {
        flex-grow: 1;
        width: 100%;
        margin: 5px;
    }

    .right-panel {
        width: 100%;
        justify-content: center;
        text-align: center;
    }
}
</style>