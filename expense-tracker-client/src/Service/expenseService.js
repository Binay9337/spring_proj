import axios from "axios"

const BASE_URL = "http://localhost:8080/expenses"


const expenseService = {
    getExpenses: () => {
        return axios.get(BASE_URL)
    }
    , deleteExpenses: (id) => {
        return axios.delete(BASE_URL + `/${id}`)
    }
    , createExpenses: (expense) => {
        return axios.post(BASE_URL, expense)
    }
    , updateExpenses: (expense) => {
        return axios.put(BASE_URL, expense)
    }
}

export default expenseService;