import axios from "axios";

const axiosInstance = axios.create({
    baseURL: "http://localhost:8181", //with docker-compose
    //baseURL: "/api", //with kubernetes
    headers: {
        "Content-Type": "application/json",
    },
});

export default axiosInstance;