import axios from 'axios'


let config = {
  development: {
    baseUrl: '/api' // 开发代理地址
  },
}

// axios在发出请求时会自动加上baseURL 便于之后进行跨域
axios.defaults.baseURL = config[import.meta.env.MODE].baseUrl
// 携带 cookie
axios.defaults.withCredentials = true
// 请求头，headers 信息
axios.defaults.headers['X-Requested-With'] = 'XMLHttpRequest'

// 默认 post 请求，使用 application/json 形式
axios.defaults.headers.post['Content-Type'] = 'application/json'

// 请求拦截器，内部根据返回值，重新组装，统一管理。
// axios.interceptors.response.use(res => {
//   if (res.data == false) {
//     ElMessage.error("账号或密码输入错误,请重新输入")
//     return Promise.reject(res)
//   }
//   return res
// })

export default axios