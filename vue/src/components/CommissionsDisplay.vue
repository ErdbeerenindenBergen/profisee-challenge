<template>
    <div class="commission-report-card">

        <div class="commissions-display-information">
            <h2 id="commission-salespersonName">Name: {{ commissionReport.salespersonName }}</h2>
            <h4 id="commission-employeeId">Employee Id: {{ commissionReport.employeeId }}</h4>
            <h4 id="commission-quarter">Quarter {{ commissionReport.quarter }} of {{ commissionReport.year }}</h4>
            <h4 id="commission-earned">Total Earned Commission: ${{ commissionReport.commission }} </h4>
        </div>

    </div>
</template>

<script>
export default {
    name: "commissions-display",
    props: {
        commissionReport: Object,
    },
    created() {
        this.userId = this.$store.state.user.id;
    },
    methods: {
        userIsLoggedIn() {
            let $loggedIn = false;
            if (this.userId != 0) {
                $loggedIn = true;
            } return $loggedIn;
        },
    }
}
</script>

<style scoped>
.commission-report-card {
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
</style>