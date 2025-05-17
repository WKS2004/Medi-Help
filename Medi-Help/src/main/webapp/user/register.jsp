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
      Sign up a new account
    </h2>
  </div>

  <div class="mt-10 sm:mx-auto sm:w-full sm:max-w-sm">
    <form class="space-y-6" action="${pageContext.request.contextPath}/register" method="POST">
      <input type="hidden" name="action" value="register">

      <!-- Email Input -->
      <div class="relative w-full">
        <label for="email" class="block text-sm/6 font-medium text-gray-900">Email address</label>
        <div class="mt-2">
          <input type="email" name="email" id="email" autocomplete="email" onkeyup="checkInputs_firstSet()" required class="block w-full rounded-md bg-white px-3 py-1.5 text-base text-gray-900 outline-1 outline-gray-300 placeholder:text-gray-400 focus:outline-2 focus:outline-indigo-600 sm:text-sm/6">
          <span id="email_validationMessage" class="absolute text-red-500 text-sm hidden"></span>
          <img id="emailTick" class="absolute right-3 top-10 hidden w-5 h-5" src="${pageContext.request.contextPath}/assets/login-and-register/tick.png" alt="Email Valid"/>
        </div>
      </div>

      <!-- Password Inputs -->
      <div>
        <label for="newPassword" class="block text-sm/6 font-medium text-gray-900">New Password</label>
        <div class="relative w-full mt-2">

          <!-- Info Icon -->
          <img id="infoIcon" class="text-blue-500 absolute right-1 bottom-11 w-5 h-5" src="${pageContext.request.contextPath}/assets/login-and-register/info.png" alt="New Password Validation Details"/>

          <!-- Validation Messages (Hidden by Default) -->
          <div id="validationMessages" class="hidden absolute right-7 bottom-12 bg-white border border-gray-300 p-2 rounded-md shadow-md text-sm w-64">
            <span class="font-bold text-indigo-500">Hints:</span>
            <span id="newPasswordLength_validationMessage" class="block text-red-500">*Password must contain at least 8 characters!</span>
            <span id="newPasswordLowercase_validationMessage" class="block text-red-500">*Must contain at least one lowercase character!</span>
            <span id="newPasswordUppercase_validationMessage" class="block text-red-500">*Must contain at least one uppercase character!</span>
            <span id="newPasswordNumbers_validationMessage" class="block text-red-500">*Must contain at least one number!</span>
            <span id="newPasswordSymbols_validationMessage" class="block text-red-500">*Must contain at least one symbol!</span>
          </div>

          <div class="relative flex items-center">
            <input type="password" name="password" id="newPassword" onkeyup="checkInputs_firstSet()" required class="block w-full rounded-md bg-white px-3 py-1.5 text-base text-gray-900 outline-1 outline-gray-300 placeholder:text-gray-400 focus:outline-2 focus:outline-indigo-600 sm:text-sm/6">

            <!-- Tick Icon -->
            <img id="newPasswordTick" class="absolute right-3 top-2 hidden w-5 h-5" src="${pageContext.request.contextPath}/assets/login-and-register/tick.png" alt="New Password Valid"/>

          </div>
        </div>

        <label for="confirmPassword" class="block text-sm/6 font-medium text-gray-900 mt-4">Confirm Password</label>
        <div class="relative w-full mt-2">
          <input type="password" name="password" id="confirmPassword" onkeyup="checkInputs_firstSet()" required class="block w-full rounded-md bg-white px-3 py-1.5 text-base text-gray-900 outline-1 outline-gray-300 placeholder:text-gray-400 focus:outline-2 focus:outline-indigo-600 sm:text-sm/6">
          <span id="confirmPassword_validationMessage" class="absolute text-red-500 text-sm hidden"></span>
          <img id="confirmPasswordTick" class="absolute right-3 top-2 hidden w-5 h-5" src="${pageContext.request.contextPath}/assets/login-and-register/tick.png" alt="Confirm Password Valid"/>
        </div>
      </div>

      <!-- Sign Up Button -->
      <div>
        <button id="signUpButton" type="submit" class="flex w-full justify-center rounded-md px-3 py-1.5 text-sm font-semibold text-white shadow-xs bg-gray-400" disabled>
          Sign Up
        </button>
      </div>
    </form>

    <!-- Sign In Link -->
    <p class="mt-10 text-center text-sm/6 text-gray-500">
      Already a member?
      <a href="${pageContext.request.contextPath}/login" class="font-semibold text-indigo-600 hover:text-indigo-500">
        Sign In
      </a>
    </p>
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