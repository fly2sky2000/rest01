import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

Vue.use(VueRouter)

const routes = [
  
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  },
  {
    path: '/test',
    name: 'Test',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/test.vue')
  }
]

const router = new VueRouter({
  routes
})

export default router

// export const constantRouterMap = [
//   //配置默认的路径，默认显示登录页
//   { path: '/', component: () => import('@/views/login')},

//   //配置登录成功页面，使用时需要使用 path 路径来实现跳转
//   { path: '/home', component: () => import('@/views/home')},
//    //配置用户注册页面
//   { path: '/adduser', component: () => import('@/views/user/adduser')},

//   //配置登录失败页面，使用时需要使用 path 路径来实现跳转
//   { path: '/error', component: () => import('@/views/error'), hidden: true }
// ]

// export default new VueRouter({
//   // mode: 'history', //后端支持可开
//   scrollBehavior: () => ({ y: 0 }),
//   routes: constantRouterMap //指定路由列表
// })
