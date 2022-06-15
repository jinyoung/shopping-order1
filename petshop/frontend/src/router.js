
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import PetManager from "./components/listers/PetCards"

import ItemManager from "./components/listers/ItemCards"
import OrderItemManager from "./components/listers/OrderItemCards"
import CustomerManager from "./components/listers/CustomerCards"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/pets',
                name: 'PetManager',
                component: PetManager
            },

            {
                path: '/items',
                name: 'ItemManager',
                component: ItemManager
            },
            {
                path: '/orderItems',
                name: 'OrderItemManager',
                component: OrderItemManager
            },
            {
                path: '/customers',
                name: 'CustomerManager',
                component: CustomerManager
            },



    ]
})
