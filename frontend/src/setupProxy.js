const { createProxyMiddleware } = require('http-proxy-middleware');

module.exports = function(app) {
    app.use(
        "/api",
        createProxyMiddleware({
           // target: "http://capstone-project-capstone-project.allstatejenkins8.conygre.com",
            target: "http://localhost:8080",
            changeOrigin: true,
        })
    );
};