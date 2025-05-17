<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html class="h-full bg-white" lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Medi Help</title>
  <link href="${pageContext.request.contextPath}/css/tailwind-powered_stylesheet.css" rel="stylesheet">
</head>

<body id="body" class="h-screen w-full bg-white transition-all duration-300">

<header class="fixed top-0 left-0 w-full z-50 bg-white">
  <%@ include file="/others/header.jsp" %>
</header>

<main class="pt-25 p-5 w-full">

  <section id="heroSlider-1" class="relative w-full h-[500px] overflow-hidden">
    <!-- Slides -->
    <div style="background-image:url('${pageContext.request.contextPath}/assets/home/hero-slide-1/copy-space-tablets-with-daily-pills-desk.jpg')" class="hero-slide-1 absolute inset-0 transition-opacity duration-1000 opacity-100 z-10 flex items-center justify-center bg-blue-50 px-6 bg-top-left bg-cover bg-local rounded-xl">
      <div class="justify-start lg:translate-x-60 translate-y-5 text-center">
        <h2 class="text-4xl font-bold text-teal-100 mb-4">Explore Our Medicines</h2>
        <p class="text-white mb-6">We provide a wide range of prescription and non-prescription medicines from trusted brands.</p>
        <img src="${pageContext.request.contextPath}/assets/home/hero-slide-1/hero-slide-1-slide-1-main.png" alt="Medicines" class="mx-auto h-60 w-auto max-w-lg rounded-md">
      </div>
    </div>

    <div style="background-image:url('${pageContext.request.contextPath}/assets/home/hero-slide-1/What Are the Various Types of Medical Equipment.jpg')" class="hero-slide-1 absolute inset-0 transition-opacity duration-1000 opacity-0 z-0 flex items-center px-6 bg-top-right bg-cover bg-local rounded-xl">
      <div class="justify-start md:translate-x-20 text-center">
        <h2 class="text-4xl font-bold text-blue-700 mb-4">Healthcare Devices</h2>
        <p class="text-gray-700 mb-6">From thermometers to BP monitors, find reliable health devices here.</p>
        <img src="${pageContext.request.contextPath}/assets/home/hero-slide-1/hero-slide-1-slide-2-main.png" alt="Devices" class="mx-auto h-40 w-auto max-w-lg rounded-md">
      </div>
    </div>

    <div class="hero-slide-1 absolute inset-0 transition-opacity duration-1000 opacity-0 z-0 flex items-center justify-center bg-yellow-50 px-6 bg-top bg-right bg-fixed rounded-xl">
      <div class="text-center">
        <h2 class="text-4xl font-bold text-yellow-700 mb-4">Top Brands We Offer</h2>
        <p class="text-gray-700 mb-6">Partnered with global pharmaceutical brands like Cipla, GSK, and Himalaya.</p>
        <img src="${pageContext.request.contextPath}/assets/home/hero-slide-1/hero-slide-1-slide-3-main.png" alt="Brands" class="pt-10 mx-auto h-50 w-auto max-w-lg rounded-md">
      </div>

      <img src="${pageContext.request.contextPath}/assets/home/hero-slide-2/cipla-logo.png" alt="Brands" class="absolute top-20 left-20 mx-auto w-25 h-auto max-w-lg -rotate-30 rounded-md">
      <img src="${pageContext.request.contextPath}/assets/home/hero-slide-2/spc-logo.png" alt="Brands" class="absolute top-20 right-20 mx-auto w-25 h-auto max-w-lg -rotate-30 rounded-md">
      <img src="${pageContext.request.contextPath}/assets/home/hero-slide-2/gsk-logo.png" alt="Brands" class="absolute bottom-20 left-20 mx-auto w-35 h-auto max-w-lg -rotate-30 rounded-md">
      <img src="${pageContext.request.contextPath}/assets/home/hero-slide-2/hemas-logo.png" alt="Brands" class="absolute bottom-20 right-20 mx-auto w-25 h-auto max-w-lg -rotate-30 rounded-md">
      <img src="${pageContext.request.contextPath}/assets/home/hero-slide-2/george-steuart-health-logo.png" alt="Brands" class="absolute align-middle left-80 mx-auto w-35 h-auto max-w-lg -rotate-30 rounded-md">
      <img src="${pageContext.request.contextPath}/assets/home/hero-slide-2/himalaya-logo.png" alt="Brands" class="absolute align-middle right-80 mx-auto w-25 h-auto max-w-lg -rotate-30 rounded-md">
    </div>

    <!-- Arrows -->
    <button onclick="changeHeroSlide2(-1)" class="absolute left-4 top-1/2 -translate-y-1/2 bg-white shadow p-2 rounded-full hover:bg-gray-200 transition z-20">
      <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6 text-indigo-600" fill="none" viewBox="0 0 24 24" stroke="currentColor">
        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15 19l-7-7 7-7"></path>
      </svg>
    </button>

    <button onclick="changeHeroSlide2(1)" class="absolute right-4 top-1/2 -translate-y-1/2 bg-white shadow p-2 rounded-full hover:bg-gray-200 transition z-20">
      <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6 text-indigo-600" fill="none" viewBox="0 0 24 24" stroke="currentColor">
        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 5l7 7-7 7"></path>
      </svg>
    </button>
  </section>

  <section class="relative overflow-hidden w-full px-4 py-20 bg-white">
    <div class="w-full text-center">

      <h2 class="text-4xl font-bold text-gray-900 mb-6"><span class="text-indigo-500">Top</span> Product Categories</h2>
      <p class="text-gray-600 text-lg mb-10">Explore our most popular categories for all your healthcare needs.</p>

      <!-- Slider Container -->
      <div id="categorySliderContainer" class="relative w-full">
        <!-- Slider Wrapper -->
        <div id="categorySliderTrack-1" class="flex transition-transform duration-700 ease-in-out w-max" style="transform: translateX(0);">

          <a href="#" class="category-slide-1 flex-none w-70 h-40 px-2">
            <div class="bg-white p-6 rounded-lg shadow hover:shadow-lg transition">
              <img src="${pageContext.request.contextPath}/assets/home/top-category-section/oriental-massage-products-equipment-including-spa-accessories-isolated-transparent-background_191095-21040-Photoroom.png" alt="Ayurvedic Products" class="w-full h-40 object-contain mb-4 rounded-xl">
              <p class="text-lg text-gray-800 font-semibold text-center">Ayurvedic Products</p>
            </div>
          </a>

          <a href="#" class="category-slide-1 flex-none w-70 h-40 px-2">
            <div class="bg-white p-6 rounded-lg shadow hover:shadow-lg transition">
              <img src="${pageContext.request.contextPath}/assets/home/top-category-section/beauty-concept-with-basket_23-2147817623.jpg" alt="Baby Accessories" class="w-full h-40 object-contain mb-4 rounded-xl">
              <p class="text-lg text-gray-800 font-semibold text-center">Baby Accessories</p>
            </div>
          </a>

          <a href="#" class="category-slide-1 flex-none w-70 px-2">
            <div class="bg-white p-6 rounded-lg shadow hover:shadow-lg transition">
              <img src="${pageContext.request.contextPath}/assets/home/top-category-section/purple-flower-herb-plant-nature-generative-ai_188544-9628.jpg" alt="Cream & Lotion" class="w-full h-40 object-contain mb-4 rounded-xl">
              <p class="text-lg text-gray-800 font-semibold text-center">Cream & Lotion</p>
            </div>
          </a>

          <a href="#" class="category-slide-1 flex-none w-70 px-2">
            <div class="bg-white p-6 rounded-lg shadow hover:shadow-lg transition">
              <img src="${pageContext.request.contextPath}/assets/home/top-category-section/16693168_5786315.jpg" alt="Medical Devices" class=" w-full h-40 object-contain mb-4 rounded-xl">
              <p class="text-lg text-gray-800 font-semibold text-center bottom-0">Medical Devices</p>
            </div>
          </a>

          <a href="#" class="category-slide-1 flex-none w-70 h-40 px-2">
            <div class="bg-white p-6 rounded-lg shadow hover:shadow-lg transition">
              <img src="${pageContext.request.contextPath}/assets/home/top-category-section/pet-accessory-isolated_23-2151307130.jpg" alt="Pet Essentials" class="w-full h-40 object-contain mb-4 rounded-xl">
              <p class="text-lg text-gray-800 font-semibold text-center">Pet Essentials</p>
            </div>
          </a>

          <a href="#" class="category-slide-1 flex-none w-70 px-2">
            <div class="bg-white p-6 rounded-lg shadow hover:shadow-lg transition">
              <img src="${pageContext.request.contextPath}/assets/home/top-category-section/197160130_10803275.jpg" alt="Vitamins" class="w-full h-40 object-contain mb-4 rounded-xl">
              <p class="text-lg text-gray-800 font-semibold text-center">Vitamins</p>
            </div>
          </a>

          <!-- Add more <a class="category-slide">...</a> up to 6 or more -->
        </div>

        <!-- Arrow Controls -->
        <button onclick="prevCategorySlide1()"
                class="absolute left-0 top-1/2 transform -translate-y-1/2 bg-indigo-600 text-white shadow p-2 rounded-full hover:bg-indigo-700 transition z-20">
          &#8592;
        </button>
        <button onclick="nextCategorySlide1()"
                class="absolute right-0 top-1/2 transform -translate-y-1/2 bg-indigo-600 text-white shadow p-2 rounded-full hover:bg-indigo-700 transition z-20">
          &#8594;
        </button>
      </div>
    </div>
  </section>

  <section>
    <div id="heroSlider-2" class="relative w-full h-[700px] md:h-125 border-x-2 border-y-5 rounded-xl border-indigo-500">

      <!-- Slide 1: Medical Store -->
      <div class="hero-slide-2 absolute inset-0 transition-opacity duration-1000 opacity-100 z-10 flex items-center justify-center px-6">
        <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-20 grid grid-cols-1 md:grid-cols-2 items-center gap-10">

          <!-- Left Content -->
          <div class="text-center md:text-left">
            <h1 class="text-4xl sm:text-5xl font-bold text-gray-900 mb-6">
              Your Trusted Online <span class="text-indigo-600">Medical Store</span>
            </h1>
            <p class="text-gray-600 text-lg mb-8">
              Explore a wide range of medicines, devices, and healthcare essentials delivered to your doorstep.
            </p>
            <div class="flex flex-col sm:flex-row gap-4 justify-center md:justify-start">
              <a href="products.jsp" class="px-6 py-3 bg-indigo-600 text-white rounded-md hover:bg-indigo-700 transition focus-visible:outline focus-visible:outline-2 focus-visible:outline-indigo-500 focus-visible:rounded-md">Shop Now</a>
              <a href="#about" class="px-6 py-3 border border-indigo-600 text-indigo-600 rounded-md hover:bg-indigo-50 transition focus-visible:outline focus-visible:outline-2 focus-visible:outline-indigo-500 focus-visible:rounded-md">Learn More</a>
            </div>
          </div>

          <!-- Right Image -->
          <div class="flex justify-center md:justify-end">
            <img src="${pageContext.request.contextPath}/assets/home/hero-slide-1/Pharmacy-Illustration-AI-1024x631.jpg" alt="Medical Illustration" class="w-70 md:w-120 h-auto" />
          </div>
        </div>
      </div>

      <!-- Slide 2: Delivery Service -->
      <div class="hero-slide-2 absolute inset-0 transition-opacity duration-1000 opacity-0 z-0 flex items-center justify-center px-6">
        <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8 py-20 grid grid-cols-1 md:grid-cols-2 items-center gap-10">

          <!-- Left Content -->
          <div class="text-center md:text-left">
            <h1 class="text-4xl sm:text-5xl font-bold text-gray-900 mb-6">
              Fast & Reliable <span class="text-indigo-600">Delivery Service</span>
            </h1>
            <p class="text-gray-600 text-lg mb-8">
              Get your medical needs delivered safely and swiftly to your doorstep with our 24/7 delivery support.
            </p>
            <div class="flex flex-col sm:flex-row gap-4 justify-center md:justify-start">
              <a href="delivery.jsp" class="px-6 py-3 bg-indigo-600 text-white rounded-md hover:bg-indigo-700 transition focus-visible:outline focus-visible:outline-2 focus-visible:outline-indigo-500 focus-visible:rounded-md">Check Delivery</a>
              <a href="#contact" class="px-6 py-3 border border-indigo-600 text-indigo-600 rounded-md hover:bg-indigo-50 transition focus-visible:outline focus-visible:outline-2 focus-visible:outline-indigo-500 focus-visible:rounded-md">Contact Us</a>
            </div>
          </div>

          <!-- Right Image -->
          <div class="flex justify-center md:justify-end">
            <img src="${pageContext.request.contextPath}/assets/home/hero-slide-1/delivery-of-medicines-vector-free-illustration.jpg" alt="Medical Illustration" class="w-70 md:w-120 h-auto" />
          </div>
        </div>
      </div>

      <!-- Slide Buttons -->
      <div class="absolute bottom-5 z-20 left-1/2 transform -translate-x-1/2 flex space-x-3">
        <button id="heroSlider-2-slide1" onclick="showSlide1(0)" class="w-3 h-3 rounded-full bg-indigo-400 hover:bg-indigo-600 transition focus-visible:outline focus-visible:outline-2 focus-visible:outline-indigo-500 focus-visible:rounded-md"></button>
        <button id="heroSlider-2-slide2" onclick="showSlide1(1)" class="w-3 h-3 rounded-full bg-gray-400 hover:bg-indigo-600 transition focus-visible:outline focus-visible:outline-2 focus-visible:outline-indigo-500 focus-visible:rounded-md"></button>
      </div>
    </div>
  </section>

  <section class="relative overflow-hidden w-full px-4 py-20 bg-white">
    <div class="w-full">

      <h2 class="text-4xl font-bold text-gray-900 mb-6 text-center"><span class="text-indigo-500">Most Viewed</span> Products</h2>
      <p class="text-gray-600 text-lg mb-10 text-center">All your healthcare needs at one place.</p>

      <!-- Slider Container -->
      <div id="categorySliderContainer" class="relative w-full">
        <!-- Slider Wrapper -->
        <div id="categorySliderTrack-2" class="flex flex-wrap items-center transition-transform duration-700 ease-in-out w-max" style="transform: translateX(0);">

          <a href="#" class="category-slide-2 flex-none w-70 h-60 px-2">
            <div class="flex-shrink-0 m-6 relative overflow-hidden bg-teal-500 rounded-lg max-w-xs shadow-lg">
              <svg class="absolute bottom-0 left-0 mb-8" viewBox="0 0 375 283" fill="none" style="transform: scale(1.5); opacity: 0.1;">
                <rect x="159.52" y="175" width="152" height="152" rx="8" transform="rotate(-45 159.52 175)" fill="white"></rect>
                <rect y="107.48" width="152" height="152" rx="8" transform="rotate(-45 0 107.48)" fill="white"></rect>
              </svg>
              <div class="relative pt-10 px-10 flex items-center justify-center">
                <div class="block absolute w-48 h-48 bottom-0 left-0 -mb-24 ml-3" style="background: radial-gradient(black, transparent 60%); transform: rotate3d(0, 0, 1, 20deg) scale3d(1, 0.6, 1); opacity: 0.2;"></div>
                <img class="relative w-40" src="${pageContext.request.contextPath}/assets/home/top-category-section/pet-accessory-isolated_23-2151307130.jpg" alt="">
              </div>
              <div class="relative text-white px-6 pb-6 mt-6">
                <span class="block opacity-75 -mb-1">Pet Essentials</span>
                <div class="flex justify-between">
                  <span class="block font-semibold text-xl">Collar</span>
                  <span class="block bg-white rounded-full text-teal-500 text-xs font-bold px-3 py-2 leading-none flex items-center">$10.00</span>
                </div>
              </div>
            </div>
          </a>

          <a href="#" class="category-slide-2 flex-none w-70 h-60 px-2">
            <div class="flex-shrink-0 m-6 relative overflow-hidden bg-teal-500 rounded-lg max-w-xs shadow-lg">
              <svg class="absolute bottom-0 left-0 mb-8" viewBox="0 0 375 283" fill="none" style="transform: scale(1.5); opacity: 0.1;">
                <rect x="159.52" y="175" width="152" height="152" rx="8" transform="rotate(-45 159.52 175)" fill="white"></rect>
                <rect y="107.48" width="152" height="152" rx="8" transform="rotate(-45 0 107.48)" fill="white"></rect>
              </svg>
              <div class="relative pt-10 px-10 flex items-center justify-center">
                <div class="block absolute w-48 h-48 bottom-0 left-0 -mb-24 ml-3" style="background: radial-gradient(black, transparent 60%); transform: rotate3d(0, 0, 1, 20deg) scale3d(1, 0.6, 1); opacity: 0.2;"></div>
                <img class="relative w-40" src="${pageContext.request.contextPath}/assets/home/top-category-section/pet-accessory-isolated_23-2151307130.jpg" alt="">
              </div>
              <div class="relative text-white px-6 pb-6 mt-6">
                <span class="block opacity-75 -mb-1">Pet Essentials</span>
                <div class="flex justify-between">
                  <span class="block font-semibold text-xl">Collar</span>
                  <span class="block bg-white rounded-full text-teal-500 text-xs font-bold px-3 py-2 leading-none flex items-center">$10.00</span>
                </div>
              </div>
            </div>
          </a>

          <a href="#" class="category-slide-2 flex-none w-70 h-60 px-2">
            <div class="flex-shrink-0 m-6 relative overflow-hidden bg-teal-500 rounded-lg max-w-xs shadow-lg">
              <svg class="absolute bottom-0 left-0 mb-8" viewBox="0 0 375 283" fill="none" style="transform: scale(1.5); opacity: 0.1;">
                <rect x="159.52" y="175" width="152" height="152" rx="8" transform="rotate(-45 159.52 175)" fill="white"></rect>
                <rect y="107.48" width="152" height="152" rx="8" transform="rotate(-45 0 107.48)" fill="white"></rect>
              </svg>
              <div class="relative pt-10 px-10 flex items-center justify-center">
                <div class="block absolute w-48 h-48 bottom-0 left-0 -mb-24 ml-3" style="background: radial-gradient(black, transparent 60%); transform: rotate3d(0, 0, 1, 20deg) scale3d(1, 0.6, 1); opacity: 0.2;"></div>
                <img class="relative w-40" src="${pageContext.request.contextPath}/assets/home/top-category-section/pet-accessory-isolated_23-2151307130.jpg" alt="">
              </div>
              <div class="relative text-white px-6 pb-6 mt-6">
                <span class="block opacity-75 -mb-1">Pet Essentials</span>
                <div class="flex justify-between">
                  <span class="block font-semibold text-xl">Collar</span>
                  <span class="block bg-white rounded-full text-teal-500 text-xs font-bold px-3 py-2 leading-none flex items-center">$10.00</span>
                </div>
              </div>
            </div>
          </a>

          <a href="#" class="category-slide-2 flex-none w-70 h-60 px-2">
            <div class="flex-shrink-0 m-6 relative overflow-hidden bg-teal-500 rounded-lg max-w-xs shadow-lg">
              <svg class="absolute bottom-0 left-0 mb-8" viewBox="0 0 375 283" fill="none" style="transform: scale(1.5); opacity: 0.1;">
                <rect x="159.52" y="175" width="152" height="152" rx="8" transform="rotate(-45 159.52 175)" fill="white"></rect>
                <rect y="107.48" width="152" height="152" rx="8" transform="rotate(-45 0 107.48)" fill="white"></rect>
              </svg>
              <div class="relative pt-10 px-10 flex items-center justify-center">
                <div class="block absolute w-48 h-48 bottom-0 left-0 -mb-24 ml-3" style="background: radial-gradient(black, transparent 60%); transform: rotate3d(0, 0, 1, 20deg) scale3d(1, 0.6, 1); opacity: 0.2;"></div>
                <img class="relative w-40" src="${pageContext.request.contextPath}/assets/home/top-category-section/pet-accessory-isolated_23-2151307130.jpg" alt="">
              </div>
              <div class="relative text-white px-6 pb-6 mt-6">
                <span class="block opacity-75 -mb-1">Pet Essentials</span>
                <div class="flex justify-between">
                  <span class="block font-semibold text-xl">Collar</span>
                  <span class="block bg-white rounded-full text-teal-500 text-xs font-bold px-3 py-2 leading-none flex items-center">$10.00</span>
                </div>
              </div>
            </div>
          </a>

          <a href="#" class="category-slide-2 flex-none w-70 h-60 px-2">
            <div class="flex-shrink-0 m-6 relative overflow-hidden bg-teal-500 rounded-lg max-w-xs shadow-lg">
              <svg class="absolute bottom-0 left-0 mb-8" viewBox="0 0 375 283" fill="none" style="transform: scale(1.5); opacity: 0.1;">
                <rect x="159.52" y="175" width="152" height="152" rx="8" transform="rotate(-45 159.52 175)" fill="white"></rect>
                <rect y="107.48" width="152" height="152" rx="8" transform="rotate(-45 0 107.48)" fill="white"></rect>
              </svg>
              <div class="relative pt-10 px-10 flex items-center justify-center">
                <div class="block absolute w-48 h-48 bottom-0 left-0 -mb-24 ml-3" style="background: radial-gradient(black, transparent 60%); transform: rotate3d(0, 0, 1, 20deg) scale3d(1, 0.6, 1); opacity: 0.2;"></div>
                <img class="relative w-40" src="${pageContext.request.contextPath}/assets/home/top-category-section/pet-accessory-isolated_23-2151307130.jpg" alt="">
              </div>
              <div class="relative text-white px-6 pb-6 mt-6">
                <span class="block opacity-75 -mb-1">Pet Essentials</span>
                <div class="flex justify-between">
                  <span class="block font-semibold text-xl">Collar</span>
                  <span class="block bg-white rounded-full text-teal-500 text-xs font-bold px-3 py-2 leading-none flex items-center">$10.00</span>
                </div>
              </div>
            </div>
          </a>

          <a href="#" class="category-slide-2 flex-none w-70 h-60 px-2">
            <div class="flex-shrink-0 m-6 relative overflow-hidden bg-teal-500 rounded-lg max-w-xs shadow-lg">
              <svg class="absolute bottom-0 left-0 mb-8" viewBox="0 0 375 283" fill="none" style="transform: scale(1.5); opacity: 0.1;">
                <rect x="159.52" y="175" width="152" height="152" rx="8" transform="rotate(-45 159.52 175)" fill="white"></rect>
                <rect y="107.48" width="152" height="152" rx="8" transform="rotate(-45 0 107.48)" fill="white"></rect>
              </svg>
              <div class="relative pt-10 px-10 flex items-center justify-center">
                <div class="block absolute w-48 h-48 bottom-0 left-0 -mb-24 ml-3" style="background: radial-gradient(black, transparent 60%); transform: rotate3d(0, 0, 1, 20deg) scale3d(1, 0.6, 1); opacity: 0.2;"></div>
                <img class="relative w-40" src="${pageContext.request.contextPath}/assets/home/top-category-section/pet-accessory-isolated_23-2151307130.jpg" alt="">
              </div>
              <div class="relative text-white px-6 pb-6 mt-6">
                <span class="block opacity-75 -mb-1">Pet Essentials</span>
                <div class="flex justify-between">
                  <span class="block font-semibold text-xl">Collar</span>
                  <span class="block bg-white rounded-full text-teal-500 text-xs font-bold px-3 py-2 leading-none flex items-center">$10.00</span>
                </div>
              </div>
            </div>
          </a>

        </div>

        <!-- Arrow Controls -->
        <button onclick="prevCategorySlide2()" class="absolute left-0 top-1/2 transform -translate-y-1/2 bg-indigo-600 text-white shadow p-2 rounded-full hover:bg-indigo-700 transition z-20">
          &#8592;
        </button>
        <button onclick="nextCategorySlide2()" class="absolute right-0 top-1/2 transform -translate-y-1/2 bg-indigo-600 text-white shadow p-2 rounded-full hover:bg-indigo-700 transition z-20">
          &#8594;
        </button>
      </div>
    </div>
  </section>

</main>

<footer>
  <%@include file="/others/footer.jsp"%>
</footer>

<script src="${pageContext.request.contextPath}/js/indexJSP.js"></script>
</body>
</html>