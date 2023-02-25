import Vue from 'vue';
import Router from 'vue-router';
import Home from '../views/Home.vue';
import Login from '../views/Login.vue';
import Logout from '../views/Logout.vue';
import Register from '../views/Register.vue';
import store from '../store/index';
import Customers from '../views/Customers.vue';
import Salespersons from '../views/Salespersons.vue';
import Products from '../views/Products.vue';
import QuarterlyCommissionsReports from '../views/QuarterlyCommissionsReports.vue';
import Sales from '../views/Sales.vue';

Vue.use(Router);

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/log-in",
      name: "log-in",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/log-out",
      name: "log-out",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/customers",
      name: "customers",
      component: Customers,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/salespersons",
      name: "salespersons",
      component: Salespersons,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/products",
      name: "products",
      component: Products,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/quarterly-commissions-reports",
      name: "quarterly-commissions-reports",
      component: QuarterlyCommissionsReports,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/sales",
      name: "sales",
      component: Sales,
      meta: {
        requiresAuth: false
      }
    },
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/log-in");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
