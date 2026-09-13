import axios from "axios";
// import React, { useEffect, useState } from "react";

const ExpenseList = ({ expense, setEditingExpense, getExpenses }) => {
  // const [expense, setExpense] = useState([]);
  // const getExpenses = async () => {
  //   try {
  //     const response = await axios.get("http://localhost:8080/expenses");
  //     console.log("response is:", response);
  //     console.log("data is", response.data);
  //     setExpense(response.data);
  //   } catch (error) {
  //     console.log("error is : ", error);
  //   }
  // };
  // useEffect(() => getExpenses(), []);

  const handleEdit = (expense) => {
    // if (confirm("are u sure to edit")) {
    setEditingExpense(expense);
    // }
  };

  const handleDelete = async (expenseId) => {
    if (confirm("are u sure to delete")) {
      try {
        const response = await axios.delete(
          // becuase if do not make await then promises state will be pending and result will be undefined so it will go to
          "http://localhost:8080/expenses/" + expenseId,
        );
        if (response.status === 204) {
          getExpenses();
        } else {
          console.log("something went wrong!!!!");
        }
      } catch (error) {
        console.log(error);
      }
    }
  };

  return (
    <div className="bg-white rounded-2xl shadow-md p-6 mv-6">
      <h2 className="text-xl font-semibold text-gray-700 mb-4">Expense List</h2>

      <div className="overflow-x-auto">
        <table className="w-full text-sm text-left">
          <thead>
            <tr className="bg-gray-100 text-gray-600 uppercase text-xs font-semibold">
              <td className="px-4 py-3">#</td>
              <td className="px-4 py-3">title</td>
              <td className="px-4 py-3">Category</td>
              <td className="px-4 py-3">Price</td>
              <td className="px-4 py-3">Date</td>
              <td className="px-4 py-3 text-center">Action</td>
            </tr>
          </thead>
          <tbody>
            {!expense.length ? (
              <tr>
                <td>no record</td>
              </tr>
            ) : (
              expense.map((exp, idx) => {
                return (
                  <tr
                    key={idx}
                    className="border-b border-gray-200 hover:bg-gray-50 transition-colors"
                  >
                    <td className="px-4 py-3 text-gray-400">{idx + 1}</td>
                    <td className="px-4 py-3 text-gray-700 font-medium">
                      {exp.title}
                    </td>
                    <td className=" px-4 py-3">
                      <span
                        className="bg-blue-100 text-blue-900 font-semibold rounded-full px-2 py-1
                text-xs"
                      >
                        {exp.category}
                      </span>{" "}
                    </td>
                    <td className="px-4 py-3 font-semibold text-gray-700">
                      {exp.price}
                    </td>
                    <td className="px-4 py-3 font-semibold text-gray-600">
                      {exp.expense_date}
                    </td>
                    <td className="px-4 py-3">
                      <div className="flex gap-2 justify-center">
                        <button
                          onClick={() => handleEdit(exp)}
                          className="bg-yellow-400 hover:bg-yellow-500 text-white font-semibold rounded-lg px-3 py-1.5 transition-colors duration-200 text-xs"
                        >
                          Edit
                        </button>

                        <button
                          onClick={() => handleDelete(exp.id)}
                          className="bg-red-400 hover:bg-red-500 text-white font-semibold rounded-lg px-3 py-1.5 transition-colors duration-200 text-xs"
                        >
                          Delete
                        </button>
                      </div>
                    </td>
                  </tr>
                );
              })
            )}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default ExpenseList;
