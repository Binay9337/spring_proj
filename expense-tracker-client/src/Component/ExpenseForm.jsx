import React from "react";

function ExpenseForm() {
  return (
    <div className="bg-white rounded-2xl shadow-md p-6 mb-6">
      <h2 className="text-xl font-semibold text-gray-700 mb-4">Add Expense</h2>

      <form action="#" className="grid grid-cols-1 md:grid-cols-2 gap-4">
        {/* Title */}
        <div>
          <label
            htmlFor="title"
            className="block font-medium text-gray-600 mb-2"
          >
            Title
          </label>

          <input
            type="text"
            id="title"
            name="title"
            className="border w-full border-gray-300 rounded-lg px-3 py-2 focus:outline-none focus:border-blue-700"
          />
        </div>

        {/* Category */}
        <div>
          <label
            htmlFor="category"
            className="block font-medium text-gray-600 mb-2"
          >
            Category
          </label>

          <select
            name="category"
            id="category"
            className="border w-full border-gray-300 rounded-lg px-3 py-2 focus:outline-none focus:border-blue-700"
          >
            <option value="">--Select Category--</option>
            <option value="Food">Food</option>
            <option value="Travel">Travel</option>
            <option value="Utilities">Utilities</option>
            <option value="Shopping">Shopping</option>
            <option value="Entertainment">Entertainment</option>
            <option value="Health">Health</option>
            <option value="Education">Education</option>
            <option value="Others">Others</option>
          </select>
        </div>
        {/* price */}
        <div>
          <label
            htmlFor="title"
            className="block font-medium text-gray-600 mb-2"
          >
            Price
          </label>

          <input
            type="text"
            id=""
            name="price"
            className="border w-full border-gray-300 rounded-lg px-3 py-2 focus:outline-none focus:border-blue-700"
          />
        </div>
        <div>
          <label
            htmlFor="title"
            className="block font-medium text-gray-600 mb-2"
          >
            Date
          </label>

          <input
            type="date"
            id="title"
            name="title"
            className="border w-full border-gray-300 rounded-lg px-3 py-2 focus:outline-none focus:border-blue-700"
          />
        </div>
        {/* add expense button */}

        <div className="mt-6">
          <button className="bg-green-400 hover:bg-green-600 p-3 rounded-lg text-white text-lg font-medium transition-all">
            Add Expense
          </button>
        </div>
      </form>
    </div>
  );
}

export default ExpenseForm;
