import axios from "axios";
const baseURL = import.meta.env.MODE === 'development'
    ? 'http://localhost:8181'
    : '/api';
const axiosInstance = axios.create({
    baseURL: baseURL, //with docker-compose
    //baseURL: "/api", //with kubernetes
    headers: {
        "Content-Type": "application/json",
    },
});

export default axiosInstance;