const port = process.env.port || process.env.npm_config_port || 8189 // 端口

module.exports = {
  publicPath: process.env.NODE_ENV === "production" ? "/ui01" : "/ui01",
  devServer: {
    open: true,
    port: port,
    proxy: {
      [process.env.VUE_APP_BASE_API]: {
        target: `http://localhost:8188`+ process.env.VUE_APP_BASE_API,
        changeOrigin: true,
        ws: true,
        pathRewrite: {
          ['^' + process.env.VUE_APP_BASE_API]: ''
        }
      }
   }
  }
}