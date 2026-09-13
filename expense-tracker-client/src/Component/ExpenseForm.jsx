import axios from "axios";
import React, { useEffect, useState } from "react";

function ExpenseForm({ getExpenses, editingExpense, seteditingExpense }) {
  const [title, setTitle] = useState("");
  const [category, setcategory] = useState("");
  const [price, setprice] = useState("");
  const [date, setdate] = useState("");

  const handleCancel = () => {
    seteditingExpense(null);
    clearForm();
  };

  useEffect(() => {
    if (editingExpense) {
      setError({})

      setTitle(editingExpense.title);
      setcategory(editingExpense.category);
      setprice(editingExpense.price);
      setdate(editingExpense.expense_date);
      window.scrollTo({ top: 0, behavior: "smooth" });
    }
  }, [editingExpense]);

  const handleChnage = (e) => {
    // console.log(e.target.name, "->", e.target.value);
    const { name, value } = e.target;

    switch (name) {
      case "title":
        setTitle(value);
        setError((prev) => ({ ...prev, title: "" }));
        break;
      case "category":
        setcategory(value);
        setError((prev) => ({ ...prev, category: "" }));
        break;
      case "price":
        setprice(value);
        setError((prev) => ({ ...prev, price: "" }));
        break;
      case "date":
        setdate(value);
        setError((prev) => ({ ...prev, date: "" }));
        break;
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    // console.log("title", title);
    // console.log("category", category);
    // console.log("price", price);
    // console.log("date", date);

    if (!validate()) {
      return;
    }

    const expense = {
      id: editingExpense ? editingExpense.id : 0,
      title,
      category,
      price,
      expense_date: date,
    };

    if (editingExpense) {
      await updateExpense(expense);
    }
    await createExprense(expense);
  };

  async function updateExpense(expense) {
    try {
      const response = await axios.put(
        "http://localhost:8080/expenses",
        expense,
      );
      if (response.status === 202) {
        getExpenses();
        clearForm();
        seteditingExpense(null);
      } else {
        alert("something went wrong");
      }
    } catch (error) {
      console.log("err occured", error);
    }
  }
  

    async function createExprense(expense) {
      const response = await axios.post(
        "http://localhost:8080/expenses",
        expense,
      );

      try {
        if (response.status === 201) {
          getExpenses();
          clearForm();
        } else {
          alert("something wait wrong");
        }
      } catch (error) {
        console.log("some error occured", error);
      }
    }
    // const handleTitleChange = (e) =>

    const clearForm = () => {
      setTitle("");
      setcategory("");
      setprice("");
      setdate("");
    };
    const [errors, setError] = useState({});
    const newErrors = {};

    const validate = () => {
      if (!title) {
        newErrors.title = "title is missing";
      } else if (title.length <= 3) {
        newErrors.title = "title must have 3 characters";
      }

      if (!category) {
        newErrors.category = "please choose a valid category";
      }

      if (!price || isNaN(price) || price <= 0) {
        newErrors.price = "price must be greater than 0";
      }

      if (!date) {
        newErrors.date = "date is required";
      }
      setError(newErrors);

      return Object.keys(newErrors).length === 0;
    };

    return (
      <div className="bg-white rounded-2xl shadow-md p-6 mb-6">
        <h2 className="text-xl font-semibold text-gray-700 mb-4">
          {editingExpense ? "edit " : "add "} Expense
        </h2>

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
              placeholder="e.g house rent"
              value={title}
              onChange={handleChnage}
            />
            {errors.title && <p className="text-red-500">{errors.title}</p>}
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
              onChange={handleChnage}
              value={category}
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
            {errors.category && (
              <p className="text-red-500">{errors.category}</p>
            )}
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
              value={price}
              placeholder="e.g: 5000"
              onChange={handleChnage}
            />
            {errors.price && <p className="text-red-500">{errors.price}</p>}
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
              name="date"
              className="border w-full border-gray-300 rounded-lg px-3 py-2 focus:outline-none focus:border-blue-700"
              value={date}
              onChange={handleChnage}
            />
            {errors.date && <p className="text-red-500">{errors.date}</p>}
          </div>
          {/* add expense button */}

          <div className="mt-6">
            {editingExpense ? (
              <div className="flex gap-4">
                {" "}
                <button
                  className="bg-green-400 hover:bg-green-600 p-3 rounded-lg text-white text-lg font-medium transition-all"
                  onClick={handleSubmit}
                >
                  update Expense{" "}
                </button>{" "}
                <button
                  className="bg-yellow-400 hover:bg-yellow-600 p-3 rounded-lg text-white text-lg font-medium transition-all"
                  onClick={handleCancel}
                >
                  cancel
                </button>
              </div>
            ) : (
              <button
                className="bg-green-400 hover:bg-green-600 p-3 rounded-lg text-white text-lg font-medium transition-all"
                onClick={handleSubmit}
              >
                Add Expense
              </button>
            )}
          </div>
        </form>
      </div>
    )
  }

export default ExpenseForm;
