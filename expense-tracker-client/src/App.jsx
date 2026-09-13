import { useEffect, useState } from "react";
import ExpenseForm from "./Component/ExpenseForm";
import ExpenseList from "./Component/ExpenseList";
import Footer from "./Component/Footer";
import Header from "./Component/Header";
import Summary from "./Component/Summary";
import axios from "axios";
import expenseService from "./Service/expenseService";

export default function App() {
  const [expense, setExpense] = useState([]);
  const [editingExpense, setEditingExpense] = useState(null);

  const getExpenses = async () => {
    try {
      const response = await expenseService.getExpenses();
      // console.log("response is:", response);
      // console.log("data is", response.data);
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
          <ExpenseForm
            getExpenses={getExpenses}
            editingExpense={editingExpense}
            setEditingExpense={setEditingExpense}
          />

          <Summary expense={expense} />
          <ExpenseList
            expense={expense}
            getExpenses={getExpenses}
            setEditingExpense={setEditingExpense}
          />
        </main>

        <Footer />
      </div>
    </>
  );
}
