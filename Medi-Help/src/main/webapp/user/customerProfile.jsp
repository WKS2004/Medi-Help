<%@ page import="lk.sliit.project.onlinemedicalstore.medihelp.models.User" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<% User user = (User) session.getAttribute("loggedUser"); %>
<!DOCTYPE html>
<html class="h-full bg-white" lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
    <link href="${pageContext.request.contextPath}/css/tailwind-powered_stylesheet.css" rel="stylesheet">
    <link href="https://keenthemes.com/static/metronic/tailwind/dist/assets/css/styles.css" rel="stylesheet">
</head>

<body>

<header class="fixed top-0 left-0 w-full z-50 bg-white">
    <%@ include file="/others/header.jsp"%>
</header>

<div class="pt-20 h-screen w-full flex overflow-hidden">
    <nav class="flex flex-col bg-gray-200 w-64 px-12 pt-4 pb-6">
        <!-- SideNavBar -->

        <div class="flex flex-row border-b items-center justify-between pb-2">
            <!-- Header -->
            <span class="text-lg font-semibold capitalize">
                    My Profile
                </span>

            <div class="relative">
                <a class="hover:text-green-500 text-gray-600" href="/">
                    <svg width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                        <path
                                d="M18 8A6 6 0 0 0 6 8c0 7-3 9-3 9h18s-3-2-3-9"></path>
                        <path d="M13.73 21a2 2 0 0 1-3.46 0"></path>
                    </svg>
                </a>
                <span class="absolute w-2 h-2 rounded-full bg-green-500 right-0 mb-5 bottom-0"></span>
            </div>

        </div>

        <%--            <div class="mt-8">--%>
        <%--                <!-- User info -->--%>
        <%--                <h2 class="mt-4 text-xl font-extrabold capitalize">--%>
        <%--                    Hello Nilupul!--%>
        <%--                </h2>--%>
        <%--                <span class="text-sm">--%>
        <%--                    <span class="font-semibold text-green-600">--%>
        <%--                        Customer--%>
        <%--                    </span>--%>
        <%--                </span>--%>
        <%--            </div>--%>

        <ul class="mt-2 text-gray-600">
            <!-- Links -->
            <li class="mt-8 shadow py-2 bg-white rounded-lg -ml-4">
                <a href="#home" class="flex pl-4">
                    <svg class="fill-current h-5 w-5" viewBox="0 0 24 24">
                        <path d="M16 20h4v-4h-4m0-2h4v-4h-4m-6-2h4V4h-4m6
                                4h4V4h-4m-6 10h4v-4h-4m-6 4h4v-4H4m0 10h4v-4H4m6
                                4h4v-4h-4M4 8h4V4H4v4z"></path>
                    </svg>
                    <span class="ml-2 capitalize font-medium">
                            dashboard
                        </span>
                </a>
            </li>

            <li class="mt-8">
                <a href="#home" class="flex">
                    <svg class="fill-current h-5 w-5" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                        <path d="M11.9973 8.56851C11.3345 8.56851 10.7973 9.10576 10.7973 9.76851C10.7973 10.4312 11.3345 10.9685 11.9973 10.9685C12.66 10.9685 13.1973 10.4312 13.1973 9.76851C13.1973 9.10576 12.66 8.56851 11.9973 8.56851Z" class="my-path"></path>
                        <path fill-rule="evenodd" clip-rule="evenodd" d="M9.58303 3.34105C10.4207 2.96158 11.1771 2.74146 12.0005 2.74146C12.8239 2.74146 13.5802 2.96158 14.4179 3.34105C15.2314 3.70956 16.1749 4.2543 17.3646 4.94117L18.2265 5.43881C18.6874 5.70489 19.0825 5.93297 19.3923 6.155C19.7235 6.39238 20.0088 6.65764 20.2196 7.02265C20.4303 7.38766 20.5174 7.76739 20.5574 8.17291C20.5947 8.55222 20.5947 9.00842 20.5947 9.54062V13.9953C20.5947 14.5275 20.5947 14.9837 20.5574 15.363C20.5174 15.7685 20.4303 16.1482 20.2196 16.5133C20.0088 16.8783 19.7235 17.1435 19.3923 17.3809C19.0825 17.6029 18.6874 17.831 18.2265 18.0971L14.3686 20.3245C13.9078 20.5906 13.5127 20.8187 13.1655 20.9759C12.7943 21.1441 12.422 21.2585 12.0005 21.2585C11.579 21.2585 11.2066 21.1441 10.8354 20.9759C10.4883 20.8187 10.0932 20.5906 9.63232 20.3245L5.77443 18.0971C5.31352 17.831 4.91844 17.6029 4.60865 17.3809C4.27745 17.1435 3.99212 16.8783 3.78138 16.5133C3.57064 16.1482 3.48358 15.7685 3.44361 15.363C3.40622 14.9837 3.40623 14.5275 3.40625 13.9953V9.54057C3.40623 9.0084 3.40622 8.5522 3.44361 8.17291C3.48358 7.76739 3.57064 7.38766 3.78138 7.02265C3.99212 6.65764 4.27745 6.39238 4.60865 6.155C4.91844 5.93297 5.31353 5.70488 5.77443 5.4388L6.63637 4.94116C7.82603 4.2543 8.76955 3.70955 9.58303 3.34105ZM14.7973 9.76851C14.7973 11.0369 13.9539 12.1083 12.7973 12.4526V15.7685C12.7973 16.2103 12.4391 16.5685 11.9973 16.5685C11.5554 16.5685 11.1973 16.2103 11.1973 15.7685V12.4526C10.0407 12.1083 9.19727 11.0369 9.19727 9.76851C9.19727 8.22211 10.4509 6.96851 11.9973 6.96851C13.5437 6.96851 14.7973 8.22211 14.7973 9.76851Z" class="my-path"></path>
                    </svg>
                    <span class="ml-2 capitalize font-medium text-black">
                            Security
                        </span>
                </a>
            </li>

            <li class="mt-8">
                <a href="#home" class="flex">
                    <svg class="fill-current h-5 w-5" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                        <path d="M3.7898 2.86467C3.71515 2.42919 3.30161 2.13669 2.86613 2.21134C2.43065 2.28599 2.13815 2.69953 2.2128 3.13501L2.727 6.13502L4.18502 13.9301C4.32338 14.67 4.44054 15.2965 4.59805 15.7919C4.76565 16.319 5.00524 16.7889 5.445 17.1541C5.88477 17.5192 6.39076 17.6683 6.93969 17.7361C7.45556 17.7999 8.09288 17.7999 8.8456 17.7998H15.6717C16.4245 17.7999 17.0619 17.7999 17.5778 17.7361C18.1267 17.6683 18.6327 17.5192 19.0725 17.154C19.5123 16.7888 19.7519 16.3189 19.9194 15.7917C20.0769 15.2963 20.1941 14.6698 20.3324 13.9298L20.9134 10.8223C21.109 9.77641 21.2716 8.90725 21.3016 8.21136C21.3332 7.48019 21.228 6.79061 20.7469 6.21112C20.2657 5.63163 19.6072 5.40151 18.8827 5.29815C18.1931 5.19977 17.3088 5.1998 16.2448 5.19983L4.19011 5.19984L3.7898 2.86467Z" class="my-path"></path>
                        <path d="M8.43008 19.5C8.43008 19.0581 8.07191 18.7 7.63008 18.7C7.18825 18.7 6.83008 19.0581 6.83008 19.5C6.83008 20.7913 7.9004 21.8 9.17294 21.8C10.4455 21.8 11.5158 20.7913 11.5158 19.5C11.5158 19.0581 11.1576 18.7 10.7158 18.7C10.274 18.7 9.91579 19.0581 9.91579 19.5C9.91579 19.8655 9.6046 20.2 9.17294 20.2C8.74127 20.2 8.43008 19.8655 8.43008 19.5Z" class="my-path"></path>
                        <path d="M14.602 19.5C14.602 19.0581 14.2438 18.7 13.802 18.7C13.3601 18.7 13.002 19.0581 13.002 19.5C13.002 20.7913 14.0723 21.8 15.3448 21.8C16.6173 21.8 17.6877 20.7913 17.6877 19.5C17.6877 19.0581 17.3295 18.7 16.8877 18.7C16.4458 18.7 16.0877 19.0581 16.0877 19.5C16.0877 19.8655 15.7765 20.2 15.3448 20.2C14.9131 20.2 14.602 19.8655 14.602 19.5Z" class="my-path"></path>
                    </svg>
                    <span class="ml-2 capitalize font-medium text-black">
                            My Cart
                        </span>
                </a>
            </li>

            <li class="mt-8">
                <a href="#home" class="flex">
                    <svg class="fill-current h-5 w-5" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                        <path d="M3.15135 4.1185C5.56782 1.73784 9.38479 1.57302 11.9952 3.62405C14.6065 1.57302 18.4304 1.73784 20.8469 4.1185L20.8478 4.11942C23.4493 6.69074 23.4493 10.852 20.8563 13.4234L20.8534 13.4263L12.5555 21.5711C12.244 21.8769 11.745 21.8765 11.4339 21.5703L3.15135 13.4179C0.548507 10.8536 0.548507 6.68278 3.15135 4.1185Z" class="my-path"></path>
                    </svg>
                    <span class="ml-2 capitalize font-medium text-black">
                            My Wishlist
                        </span>
                </a>
            </li>

        </ul>

        <div class="mt-auto flex items-center text-red-700">
            <!-- important action -->
            <a href="${pageContext.request.contextPath}/logout" class="flex items-center">
                <svg class="fill-current h-5 w-5" viewBox="0 0 24 24">
                    <path
                            d="M16 17v-3H9v-4h7V7l5 5-5 5M14 2a2 2 0 012
                            2v2h-2V4H5v16h9v-2h2v2a2 2 0 01-2 2H5a2 2 0 01-2-2V4a2 2
                            0 012-2h9z"></path>
                </svg>
                <span class="ml-2 capitalize font-medium">Log Out</span>
            </a>

        </div>
    </nav>

    <main class="flex-1 flex flex-col bg-gray-100 transition duration-500 ease-in-out overflow-y-auto">
        <%--            <div class="mx-10 my-2">--%>
        <%--                <h2 class="my-4 text-4xl font-semibold">--%>
        <%--                    Dashboard--%>
        <%--                </h2>--%>
        <%--                <div class="pb-2 flex items-center justify-between text-gray-600">--%>

        <%--                </div>--%>
        <%--                <div class="mt-6 flex justify-between text-gray-600">--%>

        <style>
            .hero-bg {
                background-image: url('/assets/profile/customer/bg-1.png');
            }
            .dark .hero-bg {
                background-image: url('/assets/profile/customer/bg-1-dark.png');
            }
        </style>
        <div class="bg-center bg-cover bg-no-repeat hero-bg">
            <!-- Container -->
            <div class="kt-container-fixed">
                <div class="flex flex-col items-center gap-2 lg:gap-3.5 py-4 lg:pt-5 lg:pb-10">
                    <img class="rounded-full border-3 border-green-500 size-[100px] shrink-0" src="${pageContext.request.contextPath}/assets/header/user/logged-in/no-profile-picture.png" alt="No Profile Picture">
                    <div class="flex items-center gap-1.5">
                        <div class="text-lg leading-5 font-semibold text-mono">
                            ${sessionScope.loggedUser.displayName}
                        </div>
                        <%--                                    <svg class="text-primary" fill="none" height="16" viewBox="0 0 15 16" width="15" xmlns="http://www.w3.org/2000/svg">--%>
                        <%--                                        <path d="M14.5425 6.89749L13.5 5.83999C13.4273 5.76877 13.3699 5.6835 13.3312 5.58937C13.2925 5.49525 13.2734 5.39424 13.275 5.29249V3.79249C13.274 3.58699 13.2324 3.38371 13.1527 3.19432C13.0729 3.00494 12.9565 2.83318 12.8101 2.68892C12.6638 2.54466 12.4904 2.43073 12.2998 2.35369C12.1093 2.27665 11.9055 2.23801 11.7 2.23999H10.2C10.0982 2.24159 9.99722 2.22247 9.9031 2.18378C9.80898 2.1451 9.72371 2.08767 9.65249 2.01499L8.60249 0.957487C8.30998 0.665289 7.91344 0.50116 7.49999 0.50116C7.08654 0.50116 6.68999 0.665289 6.39749 0.957487L5.33999 1.99999C5.26876 2.07267 5.1835 2.1301 5.08937 2.16879C4.99525 2.20747 4.89424 2.22659 4.79249 2.22499H3.29249C3.08699 2.22597 2.88371 2.26754 2.69432 2.34731C2.50494 2.42709 2.33318 2.54349 2.18892 2.68985C2.04466 2.8362 1.93073 3.00961 1.85369 3.20013C1.77665 3.39064 1.73801 3.5945 1.73999 3.79999V5.29999C1.74159 5.40174 1.72247 5.50275 1.68378 5.59687C1.6451 5.691 1.58767 5.77627 1.51499 5.84749L0.457487 6.89749C0.165289 7.19 0.00115967 7.58654 0.00115967 7.99999C0.00115967 8.41344 0.165289 8.80998 0.457487 9.10249L1.49999 10.16C1.57267 10.2312 1.6301 10.3165 1.66878 10.4106C1.70747 10.5047 1.72659 10.6057 1.72499 10.7075V12.2075C1.72597 12.413 1.76754 12.6163 1.84731 12.8056C1.92709 12.995 2.04349 13.1668 2.18985 13.3111C2.3362 13.4553 2.50961 13.5692 2.70013 13.6463C2.89064 13.7233 3.0945 13.762 3.29999 13.76H4.79999C4.90174 13.7584 5.00275 13.7775 5.09687 13.8162C5.191 13.8549 5.27627 13.9123 5.34749 13.985L6.40499 15.0425C6.69749 15.3347 7.09404 15.4988 7.50749 15.4988C7.92094 15.4988 8.31748 15.3347 8.60999 15.0425L9.65999 14C9.73121 13.9273 9.81647 13.8699 9.9106 13.8312C10.0047 13.7925 10.1057 13.7734 10.2075 13.775H11.7075C12.1212 13.775 12.518 13.6106 12.8106 13.3181C13.1031 13.0255 13.2675 12.6287 13.2675 12.215V10.715C13.2659 10.6132 13.285 10.5122 13.3237 10.4181C13.3624 10.324 13.4198 10.2387 13.4925 10.1675L14.55 9.10999C14.6953 8.96452 14.8104 8.79176 14.8887 8.60164C14.9671 8.41152 15.007 8.20779 15.0063 8.00218C15.0056 7.79656 14.9643 7.59311 14.8847 7.40353C14.8051 7.21394 14.6888 7.04197 14.5425 6.89749ZM10.635 6.64999L6.95249 10.25C6.90055 10.3026 6.83864 10.3443 6.77038 10.3726C6.70212 10.4009 6.62889 10.4153 6.55499 10.415C6.48062 10.4139 6.40719 10.3982 6.33896 10.3685C6.27073 10.3389 6.20905 10.2961 6.15749 10.2425L4.37999 8.44249C4.32532 8.39044 4.28169 8.32793 4.25169 8.25867C4.22169 8.18941 4.20593 8.11482 4.20536 8.03934C4.20479 7.96387 4.21941 7.88905 4.24836 7.81934C4.27731 7.74964 4.31999 7.68647 4.37387 7.63361C4.42774 7.58074 4.4917 7.53926 4.56194 7.51163C4.63218 7.484 4.70726 7.47079 4.78271 7.47278C4.85816 7.47478 4.93244 7.49194 5.00112 7.52324C5.0698 7.55454 5.13148 7.59935 5.18249 7.65499L6.56249 9.05749L9.84749 5.84749C9.95296 5.74215 10.0959 5.68298 10.245 5.68298C10.394 5.68298 10.537 5.74215 10.6425 5.84749C10.6953 5.90034 10.737 5.96318 10.7653 6.03234C10.7935 6.1015 10.8077 6.1756 10.807 6.25031C10.8063 6.32502 10.7908 6.39884 10.7612 6.46746C10.7317 6.53608 10.6888 6.59813 10.635 6.64999Z" fill="currentColor">--%>
                        <%--                                        </path>--%>
                        <%--                                    </svg>--%>
                    </div>
                    <%--                                <div class="flex flex-wrap justify-center gap-1 lg:gap-4.5 text-sm">--%>
                    <%--                                    <div class="flex gap-1.25 items-center">--%>
                    <%--                                        <i class="ki-filled ki-abstract-41 text-muted-foreground text-sm">--%>
                    <%--                                        </i>--%>
                    <%--                                        <span class="text-secondary-foreground font-medium">--%>
                    <%--                                            KeenThemes--%>
                    <%--                                        </span>--%>
                    <%--                                    </div>--%>
                    <%--                                    <div class="flex gap-1.25 items-center">--%>
                    <%--                                        <i class="ki-filled ki-geolocation text-muted-foreground text-sm">--%>
                    <%--                                        </i>--%>
                    <%--                                        <span class="text-secondary-foreground font-medium">--%>
                    <%--                                            SF, Bay Area--%>
                    <%--                                        </span>--%>
                    <%--                                    </div>--%>
                    <%--                                    <div class="flex gap-1.25 items-center">--%>
                    <%--                                        <i class="ki-filled ki-sms text-muted-foreground text-sm">--%>
                    <%--                                        </i>--%>
                    <%--                                        <a class="text-secondary-foreground font-medium hover:text-primary" href="mailto: jenny@kteam.com">--%>
                    <%--                                            jenny@kteam.com--%>
                    <%--                                        </a>--%>
                    <%--                                    </div>--%>
                    <%--                                </div>--%>
                </div>
                <!-- End of Container -->
            </div>

        </div>

        <div class="grid grid-cols-1 x1:grid-cols-3 gap-5 lg:gap-7.5">
            <div class="col-span-1">
                <div class="grid gap-5 lg:gap-7.5">

                    <div class="kt-card">
                        <div class="kt-card-header">
                            <h3 class="kt-card-title">
                                About
                            </h3>
                        </div>
                        <div class="kt-card-content pt-4 pb-3">
                            <table class="kt-table-auto">
                                <tbody>
                                <tr>
                                    <td class="text-sm text-secondary-foreground pb-3.5 pe-3">
                                        First Name:
                                    </td>
                                    <td class="text-sm text-mono pb-3.5">
                                        ${sessionScope.loggedUser.firstName}
                                    </td>
                                </tr>
                                <tr>
                                    <td class="text-sm text-secondary-foreground pb-3.5 pe-3">
                                        Last Name:
                                    </td>
                                    <td class="text-sm text-mono pb-3.5">
                                        ${sessionScope.loggedUser.lastName}
                                    </td>
                                </tr>
                                <tr>
                                    <td class="text-sm text-secondary-foreground pb-3.5 pe-3">
                                        Age:
                                    </td>
                                    <td class="text-sm text-mono pb-3.5">
                                        26
                                    </td>
                                </tr>
                                <tr>
                                    <td class="text-sm text-secondary-foreground pb-3.5 pe-3">
                                        Address:
                                    </td>
                                    <td class="text-sm text-mono pb-3.5">
                                        <% if (user.getAddress() == null) { %>${sessionScope.loggedUser.address}<% } else { %>-<% } %>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="text-sm text-secondary-foreground pb-3.5 pe-3">
                                        Phone:
                                    </td>
                                    <td class="text-sm text-mono pb-3.5">
                                        <% if (user.getPhoneNumber() == null) { %>${sessionScope.loggedUser.phoneNumber}<% } else { %>-<% } %>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="text-sm text-secondary-foreground pb-3.5 pe-3">
                                        Email:
                                    </td>
                                    <td class="text-sm text-mono pb-3.5">
                                        <a class="text-foreground hover:text-primary" href="#">
                                            ${sessionScope.loggedUser.email}
                                        </a>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
</div>

</body>
</html>
