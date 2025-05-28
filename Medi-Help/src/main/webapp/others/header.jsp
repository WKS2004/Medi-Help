<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<nav class="fixed top-0 left-0 bg-white items-center justify-between">
  <div class="lg:flex hidden items-center justify-between p-5">

    <div class="flex items-center justify-between">
      <a href="${pageContext.request.contextPath}" class="flex items-center justify-between px-4 focus-visible:outline focus-visible:outline-2 focus-visible:outline-indigo-500 focus-visible:rounded-md">
        <img class="mx-auto h-10 w-auto" src="${pageContext.request.contextPath}/assets/mainLogo/Medi-Help-Logo.png" alt="Medi Help">
      </a>
    </div>

    <div class="flex items-center justify-between">

      <a href="${pageContext.request.contextPath}">
        <div class="hover:cursor-pointer pl-20 pr-4">
          <span>Home</span>
        </div>
      </a>
      <a href="${pageContext.request.contextPath}/feedback">
        <div class="hover:cursor-pointer px-4">
          <span>Feedback</span>
        </div>
      </a>

      <button id="productsFull" class="h-10 w-20 hover:cursor-pointer px-4 focus-visible:outline focus-visible:outline-2 focus-visible:outline-indigo-500 focus-visible:rounded-md">
        Products
      </button>

    </div>

    <div class="flex pl-15 items-center justify-between">

      <form action="/searchServlet" method="GET" id="searchBarForm" class="flex items-center justify-between px-4 border-1 border-gray-300 rounded-xl w-90 h-10">
        <div>
          <label for="searchBar"></label>
          <input type="hidden" name="type" value="products"/>
          <input id="searchBar" type="search" name="search" onkeyup="searchButtonActivate()" placeholder="Search" autocomplete="off" class="border-y-1 border-gray-300 outline-none w-70 h-10 text-gray-900 placeholder:text-gray-400"/>
        </div>

        <div>
          <button id="searchButton" type="submit" disabled>&#128269;</button>
        </div>
      </form>

      <div class="relative pl-5 w-21 h-10">
        <img src="${pageContext.request.contextPath}/assets/header/cart/cart.png" alt="Cart" class="h-10 w-10"/>
        <div class="absolute flex left-13 bottom-7">
          <div class="relative bottom-1">
            <%--                            <img src="${pageContext.request.contextPath}/assets/header/cart/cart-1.png" alt="Cart-1" id="cart-1" class="hidden h-5 w-5"/>--%>
            <%--                            <img src="${pageContext.request.contextPath}/assets/header/cart/cart-2.png" alt="Cart-2" id="cart-2" class="hidden h-5 w-5"/>--%>
            <%--                            <img src="${pageContext.request.contextPath}/assets/header/cart/cart-3.png" alt="Cart-3" id="cart-3" class="hidden h-5 w-5"/>--%>
            <%--                            <img src="${pageContext.request.contextPath}/assets/header/cart/cart-4.png" alt="Cart-4" id="cart-4" class="hidden h-5 w-5"/>--%>
            <%--                            <img src="${pageContext.request.contextPath}/assets/header/cart/cart-5.png" alt="Cart-5" id="cart-5" class="hidden h-5 w-5"/>--%>
            <%--                            <img src="${pageContext.request.contextPath}/assets/header/cart/cart-6.png" alt="Cart-6" id="cart-6" class="hidden h-5 w-5"/>--%>
            <%--                            <img src="${pageContext.request.contextPath}/assets/header/cart/cart-7.png" alt="Cart-7" id="cart-7" class="hidden h-5 w-5"/>--%>
            <%--                            <img src="${pageContext.request.contextPath}/assets/header/cart/cart-8.png" alt="Cart-8" id="cart-8" class="hidden h-5 w-5"/>--%>
            <%--                            <img src="${pageContext.request.contextPath}/assets/header/cart/cart-9.png" alt="Cart-9" id="cart-9" class="h-5 w-5"/>--%>
            <%--                            <img src="${pageContext.request.contextPath}/assets/header/cart/cart-0.png" alt="Cart-0" id="cart-0" class="hidden h-5 w-5"/>--%>
          </div>
          <div class="relative">
            <%--                            <img src="${pageContext.request.contextPath}/assets/header/cart/cart-plus.png" alt="Cart-Plus" id="cart-plus" class="h-3 w-3"/>--%>
          </div>
        </div>
      </div>

      <div class="flex items-center justify-between h-10 w-15">
        <% if (session.getAttribute("loggedUser") == null) {%>
        <a href="${pageContext.request.contextPath}/login" class="flex items-center justify-between px-4 focus-visible:outline focus-visible:outline-2 focus-visible:outline-indigo-500 focus-visible:rounded-md">
          <div class="h-10 w-10">
            <img src="${pageContext.request.contextPath}/assets/header/user/not-logged-in/no-user.png" alt="Login/Sign Up" class="mx-auto h-10 w-10"/>
          </div>
        </a>
        <% } else { %>
        <a href="${pageContext.request.contextPath}/profile" class="flex items-center justify-between px-4 focus-visible:outline focus-visible:outline-2 focus-visible:outline-indigo-500 focus-visible:rounded-md">
          <div class="h-10 w-10">
            <img src="${pageContext.request.contextPath}/assets/header/user/logged-in/no-profile-picture.png" alt="Profile" class="mx-auto h-10 w-10"/>
          </div>
        </a>
        <% }%>
      </div>

    </div>
  </div>

  <div id="productsMenuFull" class="flex w-screen justify-between transition-all duration-300 ease-in-out overflow-hidden z-15 max-h-0 opacity-0 border-b-2 border-gray-400">

    <!-- Products Content -->
    <div id="products" class="justify-between p-5 w-52">

      <div id="productsMedicalDevices" class="pl-2 py-3 hover:bg-gray-100 hover:cursor-pointer">
        <span class="pl-1 font-semibold">Medical Devices</span>
      </div>

      <div id="productsMedicines" class="pl-2 py-3 hover:bg-gray-100 hover:cursor-pointer">
        <span class="pl-1 font-semibold">Medicines</span>
      </div>

    </div>

    <div class="w-screen border-l-2 border-gray-400 bg-gray-100">

      <!-- Products-Medical_Devices -->
      <div id="productsMedicalDevicesContent" class="hidden items-center justify-between p-5">

        <div class="pt-5 pl-5">
          <span class="text-2xl font-bold">Medical Devices</span>
        </div>

        <div class="items-center justify-between">

          <div class="flex items-center justify-between h-20 w-full">

            <a href="${pageContext.request.contextPath}/products/blood-pressure-meters" class="items-center w-40 p-2.5 hover:bg-gray-200">
              <span class="text-base font-semibold">Blood Pressure Meters</span>
            </a>

            <a href="${pageContext.request.contextPath}/products/blood-glucose-meters-and-strips" class="items-center w-40 p-2.5 hover:bg-gray-200">
              <span class="text-base font-semibold">Blood Glucose Meters & Strips</span>
            </a>

            <a href="${pageContext.request.contextPath}/products/thermometer" class="items-center w-40 p-2.5 hover:bg-gray-200">
              <span class="text-base font-semibold">Thermometer</span>
            </a>

            <a href="${pageContext.request.contextPath}/products/other-devices" class="items-center w-40 p-2.5 hover:bg-gray-200">
              <span class="text-base font-semibold">Other Devices</span>
            </a>

          </div>

        </div>

      </div>

      <!-- Products-Medicines -->
      <div id="productsMedicinesContent" class="hidden items-center justify-between p-5">

        <div class="pt-5 pl-5">
          <span class="text-2xl font-bold">Medicines</span>
        </div>

        <div class="items-center justify-between">

          <div class="flex items-center justify-between h-20 w-full">

            <a href="#" class="items-center w-40 p-2.5 hover:bg-gray-200">
              <span class="text-base font-semibold">Asthma</span>
            </a>

            <a href="#" class="items-center w-40 p-2.5 hover:bg-gray-200">
              <span class="text-base font-semibold">Antibiotics</span>
            </a>

            <a href="#" class="items-center w-40 p-2.5 hover:bg-gray-200">
              <span class="text-base font-semibold">Cream & Lotion</span>
            </a>

            <a href="#" class="items-center w-40 p-2.5 hover:bg-gray-200">
              <span class="text-base font-semibold">Diabetics</span>
            </a>

            <a href="#" class="items-center w-40 p-2.5 hover:bg-gray-200">
              <span class="text-base font-semibold">Eye Drops & Ear Drops</span>
            </a>

          </div>

          <div class="flex items-center justify-between h-20 w-full">

            <a href="#" class="items-center w-40 p-2.5 hover:bg-gray-200">
              <span class="text-base font-semibold">Gastritis</span>
            </a>

            <a href="#" class="items-center w-40 p-2.5 hover:bg-gray-200">
              <span class="text-base font-semibold">Hormones</span>
            </a>

            <a href="#" class="items-center w-40 p-2.5 hover:bg-gray-200">
              <span class="text-base font-semibold">Medicated Shampoo & Soap</span>
            </a>

            <a href="#" class="items-center w-40 p-2.5 hover:bg-gray-200">
              <span class="text-base font-semibold">Nerves</span>
            </a>

            <a href="#" class="items-center w-40 p-2.5 hover:bg-gray-200">
              <span class="text-base font-semibold">Pain Killers</span>
            </a>

          </div>

          <div class="flex items-center justify-between h-20 w-full">

            <a href="#" class="items-center w-40 p-2.5 hover:bg-gray-200">
              <span class="text-base font-semibold">Pressure</span>
            </a>

            <a href="#" class="items-center w-40 p-2.5 hover:bg-gray-200">
              <span class="text-base font-semibold">Urinary</span>
            </a>

            <a href="#" class="items-center w-40 p-2.5 hover:bg-gray-200">
              <span class="text-base font-semibold">Veterinary</span>
            </a>

            <a href="#" class="items-center w-40 p-2.5 hover:bg-gray-200">
              <span class="text-base font-semibold">Vitamins</span>
            </a>

            <a href="#" class="items-center w-40 p-2.5 hover:bg-gray-200">
              <span class="text-base font-semibold">Worm Treatments</span>
            </a>

          </div>

        </div>

      </div>

    </div>
  </div>

  <script src="${pageContext.request.contextPath}/js/headerJSP.js" ></script>
</nav>