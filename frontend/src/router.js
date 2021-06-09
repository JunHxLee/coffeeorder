
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderManager from "./components/OrderManager"

import CoffeeManager from "./components/CoffeeManager"

import ServingManager from "./components/ServingManager"


import ServingScreen from "./components/ServingScreen"
export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/Order',
                name: 'OrderManager',
                component: OrderManager
            },

            {
                path: '/Coffee',
                name: 'CoffeeManager',
                component: CoffeeManager
            },

            {
                path: '/Serving',
                name: 'ServingManager',
                component: ServingManager
            },


            {
                path: '/ServingScreen',
                name: 'ServingScreen',
                component: ServingScreen
            },


    ]
})
