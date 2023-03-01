<template>
  <div class="home">

    <div class="icons">
      <div id="search">
        <a>
          <font-awesome-icon class="search-icon" icon="fa-solid fa-person-biking" @click="pushToCustomers()" />
        </a>
        <p>Customers</p>
      </div>

      <div id="plan">
        <a>
          <font-awesome-icon class="search-icon" icon="fa-solid fa-users" @click="pushToSalespersons()" />
        </a>
        <p>Salespersons</p>
      </div>

      <div id="search">
        <a>
          <font-awesome-icon class="search-icon" icon="fa-solid fa-bicycle" @click="pushToProducts()" />
        </a>
        <p>Products</p>
      </div>

    </div>

    <div class="icons">
      <div id="search">
        <a>
          <font-awesome-icon class="search-icon" icon="fa-solid fa-dollar-sign" @click="pushToSales()" />
        </a>
        <p>Sales</p>
      </div>

      <div id="plan">
        <a>
          <font-awesome-icon class="search-icon" icon="fa-solid fa-chart-line" @click="pushToQuarterlyReports()" />
        </a>
        <p>Quarterly Commissions Reports</p>
      </div>

    </div>

  </div>
</template>

<script>
import fontawesome from "@fortawesome/fontawesome";
import brands from "@fortawesome/fontawesome-free-brands";
import solid from "@fortawesome/fontawesome-free-solid";

fontawesome.library.add(brands, solid);

export default {
  name: "home",
  methods: {
    pushToCustomers(){
      this.$router.push({name: "customers"})
    },
    pushToSalespersons(){
      this.$router.push({name: "salespersons"})
    },
    pushToProducts(){
      this.$router.push({name: "products"})
    },
    pushToSales(){
      this.$router.push({name: "sales"})
    },
    pushToQuarterlyReports(){
      this.$router.push({name: "quarterly-commissions-reports"})
    }
  }
};
</script>

<style scoped>
h1 {
  font-family: "Playfair Display";
  font-weight: normal;
  text-align: center;
  padding-top: 40px;
}

.icons {
  display: flex;
  justify-content: space-evenly;
  padding-top: 30px;
  padding-top: 150px;
}

#search {
  display: flex;
  flex-direction: column;
}

.search-icon {
  color: rgb(200, 199, 200);
  height: 200px;
  width: auto;
}

p {
  font-size: 25px;
  text-align: center;
  line-height: 5px;
  font-family: "Playfair Display";
  font-weight: normal;
  padding-right: 20px;
}

a.router-link-active {
  font-weight: bold;
}

@media screen and (max-width: 800px) and (min-width: 200px) {
  p {
    font-size: 20px;
    text-align: center;
    line-height: 5px;
    font-family: "Playfair Display";
    font-weight: normal;
    padding-right: 20px;
  }

  .search-icon {
  height: 100px;
  width: auto;
}

  .icons{
    display: block;
    padding-top: 28px;
  }
}
</style>