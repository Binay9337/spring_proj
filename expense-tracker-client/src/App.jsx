import { useEffect, useState } from "react";
import ExpenseForm from "./Component/ExpenseForm";
import ExpenseList from "./Component/ExpenseList";
import Footer from "./Component/Footer";
import Header from "./Component/Header";
import Summary from "./Component/Summary";
import axios from "axios";

export default function App() {
  const [expense, setExpense] = useState([]);
  const getExpenses = async () => {
    try {
      const response = await axios.get("http://localhost:8080/expenses");
      console.log("response is:", response);
      console.log("data is", response.data);
      setExpense(response.data);
    } catch (error) {
      console.log("error is : ", error);
    }
  };
  useEffect(() => {
    getExpenses();
  }, []);
  return (
    <>
      <div className="min-h-screen bg-gray-100">
        <Header />

        <main className="max-w-4xl mx-auto py-4 mt-4">
          <ExpenseForm />

          <Summary expense={expense} />
          <ExpenseList expense={expense} />
        </main>

        <Footer />
      </div>
    </>
  );
}
