import React from "react";

function Summary({ expense }) {
  const totalExpense = expense.reduce((acc, exp) => exp.price + acc, 0);
  return (
    <div className="bg-white rounded-2xl shadow-md p-6 mb-4">
      <h2 className="text-xl font-semibold text-gray-700 mb-4">Summary</h2>

      <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
        {/* Total expenses */}
        <div className="bg-blue-50 border-blue-200 rounded-xl p-4 flex gap-2">
          <div className="text-3xl">💰</div>
          <div>
            {" "}
            <p className=" font-medium text-gray-500">Total Expenses</p>
            <p className="text-3xl  text-blue-600 font-bold">{totalExpense}</p>
          </div>
        </div>
        {/* Total entries */}
        <div className="bg-green-50 border-green-200 rounded-xl p-4 flex gap-2">
          <div className="text-3xl">📋</div>
          <div>
            {" "}
            <p className=" font-medium text-gray-500">Total Entries</p>
            <p className="text-2xl  text-green-600 font-bold">
              {expense.length}
            </p>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Summary;
