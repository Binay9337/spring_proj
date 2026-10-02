import React from "react";

function Header() {
  return (
    <>
      <header className="bg-blue-600 text-white py-6 shadow-md text-center">
        <div className="px-4">
          <h1 className="font-bold text-3xl">Personal Expense Tracker</h1>
          <p className="text-blue-300 text-lg mt-1">
            Track daily expenses with ease
          </p>
        </div>
      </header>
    </>
  );
}

export default Header;
