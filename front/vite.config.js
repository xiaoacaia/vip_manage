import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  // 配置 proxy 代理接口 解决跨域问题
  server: {
    proxy: {
      '/api': {
        // 请求路径映射到 target 属性
        target: 'http://localhost:28000',
        changeOrigin: true,
        rewrite: path => path.replace(/^\/api/, '')
      }
    }
  }
})
