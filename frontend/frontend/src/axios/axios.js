import axios from "axios";
const baseURL = import.meta.env.MODE === 'development'
    ? 'http://localhost:8181'
    : '/api';
const axiosInstance = axios.create({
    //baseURL: 'http://localhost:8181, //with docker-compose
    //baseURL: "/api", //with kubernetes
    baseURL: "https://accommodation-backend.onrender.com", //with deployment
    headers: {
        "Content-Type": "application/json",
    },
});

export default axiosInstance;