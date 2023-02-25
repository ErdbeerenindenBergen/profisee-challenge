<template>
    <div id="sales-page">
        <div class="tab-buttons">
            <button type="button" id="see-all-sales" class="button" v-on:click="showSeeAllSales()">
                See All Sales
            </button>

            <button type="button" id="filter-sales-by-date" class="button" v-on:click="showFilterSalesByDate()">
                Filter Sales by Date
            </button>

            <button type="button" id="add-new-sale" class="button" v-on:click="showAddNewSale()">
                Add New Sale
            </button>


        </div>

        <div id="see-all-sales-tab">
            <sales-display class="card" v-for="sale in sales" :key="sale.saleId" v-bind:sale="sale">
            </sales-display>
        </div>

        <!-----------------------------------------Enter Dates----------------------------------------->
        <form id="event-form" name="form" @submit=filterSalesByDate()>

            <div id="filter-sales-by-date-tab">
                <div class="date-inputs">
                    <div class="left-side-date">
                        <h2>Start Date:</h2>
                        <input type="date" class="date-input" name="start-date" v-model="startDate"
                            placeholder="mm/dd/yyyy" />
                    </div>

                    <div class="right-side-date">
                        <h2>End Date:</h2>
                        <input type="date" class="date-input" name="end-date" v-model="endDate" placeholder="mm/dd/yyyy" />
                    </div>
                </div>

                <button type="button" id="show-sales-by-date-button" class=" submit-button button"
                    v-on:click="filterSalesByDate()">
                    Submit
                </button>

                <sales-display class="card" v-for="sale in salesByDate" :key="sale.saleId" v-bind:sale="sale">
                </sales-display>
            </div>
        </form>

        <div id="add-new-sale-tab">
        </div>


    </div>
</template>

<script>

import SalesService from "../services/SalesService.js";
import SalesDisplay from '../components/SalesDisplay.vue';

export default {
    name: "sales-details",
    components: {
        SalesDisplay,
    },
    data() {
        return {
            sales: [],
            salesByDate: [],
            startDate: Date,
            endDate: Date,
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
            this.startDate = this.moment(this.startDate).format("YYYY-MM-DD");
            this.endDate = this.moment(this.endDate).format("YYYY-MM-DD");
            SalesService.getSalesByDate(this.startDate, this.endDate).then((response) => {
                this.salesByDate = response.data;
                console.dir(this.salesByDate);
            });
        },
        showSeeAllSales() {
            const salesDisplayTab = document.getElementById("see-all-sales-tab");
            const salesDisplayByDate = document.getElementById("filter-sales-by-date-tab");
            const newSaleForm = document.getElementById("add-new-sale-tab");
            const buttonOne = document.getElementById("see-all-sales");
            const buttonTwo = document.getElementById("filter-sales-by-date");
            const buttonThree = document.getElementById("add-new-sale");
            salesDisplayTab.style.display = "block";
            salesDisplayByDate.style.display = "none";
            newSaleForm.style.display = "none";
            buttonOne.style.backgroundColor = "#b1b1b1";
            buttonTwo.style.backgroundColor = "#f0efef";
            buttonThree.style.backgroundColor = "#f0efef";
            buttonOne.style.color = "white";
            buttonTwo.style.color = "#666666";
            buttonThree.style.color = "#666666";
        },
        showFilterSalesByDate() {
            const salesDisplayTab = document.getElementById("see-all-sales-tab");
            const salesDisplayByDate = document.getElementById("filter-sales-by-date-tab");
            const newSaleForm = document.getElementById("add-new-sale-tab");
            const buttonOne = document.getElementById("see-all-sales");
            const buttonTwo = document.getElementById("filter-sales-by-date");
            const buttonThree = document.getElementById("add-new-sale");
            salesDisplayTab.style.display = "none";
            salesDisplayByDate.style.display = "block";
            newSaleForm.style.display = "none";
            buttonOne.style.backgroundColor = "#f0efef";
            buttonTwo.style.backgroundColor = "#b1b1b1";
            buttonThree.style.backgroundColor = "#f0efef";
            buttonOne.style.color = "#666666";
            buttonTwo.style.color = "white";
            buttonThree.style.color = "#666666";
        },
        showAddNewSale() {
            const salesDisplayTab = document.getElementById("event-form-tab");
            const salesDisplayByDate = document.getElementById("filter-sales-by-date-tab");
            const newSaleForm = document.getElementById("add-new-sale-tab");
            const buttonOne = document.getElementById("see-all-sales");
            const buttonTwo = document.getElementById("filter-sales-by-date");
            const buttonThree = document.getElementById("add-new-sale");
            salesDisplayTab.style.display = "none";
            salesDisplayByDate.style.display = "none";
            newSaleForm.style.display = "block";
            buttonOne.style.backgroundColor = "#f0efef";
            buttonTwo.style.backgroundColor = "#f0efef";
            buttonThree.style.backgroundColor = "#b1b1b1";
            buttonOne.style.color = "#666666";
            buttonTwo.style.color = "#666666";
            buttonThree.style.color = "white";
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

#see-all-sales {
    background-color: #b1b1b1;
    color: white;
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
    align-self: center;
    padding: 10px 15px;
    border: 3px solid lightgray;
    text-align: center;
    justify-content: center;
    border-radius: 10px;
    font-size: 16px;
    display: flex;
    flex-grow: 0;
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

#create-sale-button {
    background-color: #a64d79ff;
    color: white;
}

#invite-button,
#restaurant-button {
    background-color: #a64d79ff;
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

#search-directions {
    padding-top: 40px;
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

#invite-button {
    justify-content: center;
    display: flex;
    align-content: center;
    margin: auto;
    margin-top: 20px;
    margin-bottom: 40px;
    width: 15%;
}

.event-input {
    display: flex;
    justify-content: center;
    margin: auto;
    font-family: Arial;
    color: #909090;
}

#event-info-button {
    width: 30%;
    margin: 10px;
}

#event-info-button:focus,
#invite-button:focus,
#restaurant-button:focus {
    background: #e06666;
}

#event-info-button:hover,
#invite-button:hover,
#restaurant-button:hover {
    background: #741b47ff;
}

body {
    padding-top: 15px;
    display: flex;
    order: bottom;
    z-index: -1;
}

.left-panel {
    width: 30%;
    display: flex;
    margin: auto;
    justify-content: center;
    margin-top: 20px;
}

form.find-form {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
}

.right-panel {
    width: 100%;
    justify-content: center;
    text-align: center;
}

p {
    font-size: 25px;
    display: flex;
    line-height: 5px;
    font-family: Montserrat;
    font-weight: normal;
}

input.location {
    width: 175px;
    padding: 10px 15px;
    border: 3px solid lightgray;
    text-align: center;
    border-radius: 10px;
    font-size: 16px;
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

.submit-button:focus{
    background-color:#666666;
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