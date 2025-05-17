<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html class="h-full bg-white" lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Sign Up</title>
  <link href="${pageContext.request.contextPath}/css/tailwind-powered_stylesheet.css" rel="stylesheet">
</head>
<body class="h-screen flex flex-col">
<!-- Content Wrapper -->
<div class="flex-grow flex flex-col justify-center px-6 py-13 lg:px-8">
  <div class="sm:mx-auto sm:w-full sm:max-w-sm">
    <a href="${pageContext.request.contextPath}">
      <img class="mx-auto h-10 w-auto" src="${pageContext.request.contextPath}/assets/mainLogo/Medi-Help-Logo.png" alt="Medi Help">
    </a>
    <h2 class="mt-10 text-center text-2xl/9 font-bold tracking-tight text-gray-900">
      Let's Add Your Details
    </h2>
  </div>

  <div class="mt-10 sm:mx-auto sm:w-full sm:max-w-sm">
    <form class="space-y-6" action="${pageContext.request.contextPath}/register" method="POST">
      <input type="hidden" name="action" value="registerMore">

      <div class="flex relative w-full">
        <!-- First Name Input -->
        <div class="relative w-full">
          <label for="firstName" class="block text-sm/6 font-medium text-gray-900">First Name</label>
          <div class="mt-2">
            <input type="text" name="firstName" id="firstName" autocomplete="on" onkeyup="checkInputs_secondSet()" required class="block w-full rounded-md bg-white px-3 py-1.5 text-base text-gray-900 outline-1 outline-gray-300 placeholder:text-gray-400 focus:outline-2 focus:outline-indigo-600 sm:text-sm/6">
            <span id="firstName_validationMessage" class="absolute text-red-500 text-sm hidden"></span>
            <img id="firstNameTick" class="absolute right-3 top-10 hidden w-5 h-5" src="${pageContext.request.contextPath}/assets/login-and-register/tick.png" alt="First Name Valid"/>
          </div>
        </div>

        <!-- Last Name Input -->
        <div class="ml-5 relative w-full">
          <label for="lastName" class="block text-sm/6 font-medium text-gray-900">Last Name</label>
          <div class="mt-2">
            <input type="text" name="lastName" id="lastName" autocomplete="on" onkeyup="checkInputs_secondSet()" required class="block w-full rounded-md bg-white px-3 py-1.5 text-base text-gray-900 outline-1 outline-gray-300 placeholder:text-gray-400 focus:outline-2 focus:outline-indigo-600 sm:text-sm/6">
            <span id="lastName_validationMessage" class="absolute text-red-500 text-sm hidden"></span>
            <img id="lastNameTick" class="absolute right-3 top-10 hidden w-5 h-5" src="${pageContext.request.contextPath}/assets/login-and-register/tick.png" alt="Last Name Valid"/>
          </div>
        </div>
      </div>

      <!-- Username Input -->
      <div class="relative w-full">
        <label for="username" class="block text-sm/6 font-medium text-gray-900">Username</label>
        <div class="mt-2">
          <input type="text" name="username" id="username" onkeyup="checkInputs_secondSet()" required class="block w-full rounded-md bg-white px-3 py-1.5 text-base text-gray-900 outline-1 outline-gray-300 placeholder:text-gray-400 focus:outline-2 focus:outline-indigo-600 sm:text-sm/6">
          <span id="username_validationMessage" class="absolute text-red-500 text-sm hidden"></span>
          <img id="usernameTick" class="absolute right-3 top-10 hidden w-5 h-5" src="${pageContext.request.contextPath}/assets/login-and-register/tick.png" alt="Username Valid"/>
        </div>
      </div>

      <!-- Role Input -->
      <div class="relative w-full">
        <label for="role" class="block text-sm/6 font-medium text-gray-900">I am a...</label>
        <div class="mt-2">
          <select name="role" id="role" class="block w-full rounded-md bg-white px-3 py-1.5 text-base text-gray-900 outline-1 outline-gray-300 placeholder:text-gray-400 focus:outline-2 focus:outline-indigo-600 sm:text-sm/6">
            <option value="customer">Customer</option>
            <option value="pharmacist">Pharmacist</option>
          </select>
        </div>
      </div>

      <!-- Sign Up Button -->
      <div>
        <button id="continueButton" type="submit" class="flex w-full justify-center rounded-md px-3 py-1.5 text-sm font-semibold text-white shadow-xs bg-gray-400" disabled>
          Continue
        </button>
      </div>
    </form>
  </div>
</div>

<!-- Footer (Copyright Section) -->
<footer class="mt-auto">
  <%@ include file="/others/footer-onlyCopyright.jsp" %>
</footer>

<!-- JavaScript Validation -->
<script src="${pageContext.request.contextPath}/js/registerJSP.js"></script>
</body>
</html>