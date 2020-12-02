module.exports = {
  publicPath: '/ui01',
  devServer: {
    open: true,
    port: '8189',
    proxy: {
      '/rest01': {
        target: 'http://localhost:8188/rest01/',
        changeOrigin: true,
        ws: true,
        pathRewrite: {
          '^/rest01': ''
        }
      }
   }
  }
}