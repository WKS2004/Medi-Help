<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html class="h-full bg-white" lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Sign In</title>
  <link href="${pageContext.request.contextPath}/css/tailwind-powered_stylesheet.css" rel="stylesheet">
</head>
<body class="h-screen flex flex-col">
<!-- Content Wrapper -->
<div class="flex-grow flex flex-col justify-center px-6 py-12 lg:px-8">
  <div class="sm:mx-auto sm:w-full sm:max-w-sm">
    <a href="${pageContext.request.contextPath}">
      <img class="mx-auto h-10 w-auto" src="${pageContext.request.contextPath}/assets/mainLogo/Medi-Help-Logo.png" alt="Medi Help">
    </a>
    <h2 class="mt-10 text-center text-2xl/9 font-bold tracking-tight text-gray-900">
      Sign In
    </h2>
  </div>

  <div class="mt-10 sm:mx-auto sm:w-full sm:max-w-sm">
    <form class="space-y-6" action="${pageContext.request.contextPath}/login" method="POST">

      <!-- Email Input -->
      <div class="relative w-full">
        <label for="email" class="block text-sm/6 font-medium text-gray-900">Email address</label>
        <div class="mt-2">
          <input type="email" name="email" id="email" autocomplete="email" onkeyup="checkInputs()" required class="block w-full rounded-md bg-white px-3 py-1.5 text-base text-gray-900 outline-1 outline-gray-300 placeholder:text-gray-400 focus:outline-2 focus:outline-indigo-600 sm:text-sm/6">
          <span id="email_validationMessage" class="absolute text-red-500 text-sm hidden"></span>
          <img id="emailTick" class="absolute right-3 top-10 hidden w-5 h-5" src="${pageContext.request.contextPath}/assets/login-and-register/tick.png" alt="Email Valid"/>
        </div>
      </div>

      <!-- Password Inputs -->
      <div>
        <label for="password" class="block text-sm/6 font-medium text-gray-900">Password</label>
        <div class="relative w-full mt-2">
          <div class="relative flex items-center">
            <input type="password" name="password" id="password" onkeyup="checkInputs()" required class="block w-full rounded-md bg-white px-3 py-1.5 text-base text-gray-900 outline-1 outline-gray-300 placeholder:text-gray-400 focus:outline-2 focus:outline-indigo-600 sm:text-sm/6">
          </div>
        </div>

      </div>

      <!-- Sign Up Button -->
      <div>
        <button id="signUpButton" type="submit" class="flex w-full justify-center rounded-md px-3 py-1.5 text-sm font-semibold text-white shadow-xs bg-gray-400" disabled>
          Sign In
        </button>
      </div>
    </form>

    <!-- Sign In Link -->
    <p class="mt-10 text-center text-sm/6 text-gray-500">
      Not a member yet?
      <a href="${pageContext.request.contextPath}/register" class="font-semibold text-indigo-600 hover:text-indigo-500">
        Sign Up
      </a>
    </p>
  </div>
</div>
<!-- Footer (Copyright Section) -->
<footer class="mt-auto">
  <%@ include file="/others/footer-onlyCopyright.jsp" %>
</footer>

<!-- JavaScript Validation -->
<script src="${pageContext.request.contextPath}/js/loginJSP.js"></script>
</body>
</html>
