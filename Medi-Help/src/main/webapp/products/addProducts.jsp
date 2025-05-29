<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<form action="${pageContext.request.contextPath}/products/add" method="POST" class="mx-auto mt-16 max-w-xl sm:mt-20">
    <div class="grid grid-cols-1 gap-x-8 gap-y-6 sm:grid-cols-2">
        <div>
            <label class="block text-sm/6 font-semibold text-gray-900">Product Name</label>
            <div class="mt-2.5">
                <input type="text" id="productName" class="block w-full rounded-md bg-white px-3.5 py-2 text-base text-gray-900 outline-1 -outline-offset-1 outline-gray-300 placeholder:text-gray-400 focus:outline-2 focus:-outline-offset-2 focus:outline-indigo-600">
            </div>
        </div>
        <div>
            <label class="block text-sm/6 font-semibold text-gray-900">Product Brand</label>
            <div class="mt-2.5">
                <input type="text" id="productBrand" class="block w-full rounded-md bg-white px-3.5 py-2 text-base text-gray-900 outline-1 -outline-offset-1 outline-gray-300 placeholder:text-gray-400 focus:outline-2 focus:-outline-offset-2 focus:outline-indigo-600">
            </div>
        </div>
        <div>
            <label class="block text-sm/6 font-semibold text-gray-900">Product Category</label>
            <div class="mt-2.5">
                <input type="text" id="productCategory" class="block w-full rounded-md bg-white px-3.5 py-2 text-base text-gray-900 outline-1 -outline-offset-1 outline-gray-300 placeholder:text-gray-400 focus:outline-2 focus:-outline-offset-2 focus:outline-indigo-600">
            </div>
        </div>
        <div>
            <label class="block text-sm/6 font-semibold text-gray-900">Image Path</label>
            <div class="mt-2.5">
                <input type="text" id="productImagePath" class="block w-full rounded-md bg-white px-3.5 py-2 text-base text-gray-900 outline-1 -outline-offset-1 outline-gray-300 placeholder:text-gray-400 focus:outline-2 focus:-outline-offset-2 focus:outline-indigo-600">
            </div>
        </div>
        <div>
            <label class="block text-sm/6 font-semibold text-gray-900">Price</label>
            <div class="mt-2.5">
                <input type="text" id="productPrice" class="block w-full rounded-md bg-white px-3.5 py-2 text-base text-gray-900 outline-1 -outline-offset-1 outline-gray-300 placeholder:text-gray-400 focus:outline-2 focus:-outline-offset-2 focus:outline-indigo-600">
            </div>
        </div>
        <div>
            <label class="block text-sm/6 font-semibold text-gray-900">Quantity</label>
            <div class="mt-2.5">
                <input type="text" id="productQuantity" class="block w-full rounded-md bg-white px-3.5 py-2 text-base text-gray-900 outline-1 -outline-offset-1 outline-gray-300 placeholder:text-gray-400 focus:outline-2 focus:-outline-offset-2 focus:outline-indigo-600">
            </div>
        </div>
        <div class="sm:col-span-2">
            <label for="comment" class="block text-sm/6 font-semibold text-gray-900">Product Description</label>
            <div class="mt-2.5">
                <textarea id="productDescription" rows="4" class="block w-full rounded-md bg-white px-3.5 py-2 text-base text-gray-900 outline-1 -outline-offset-1 outline-gray-300 placeholder:text-gray-400 focus:outline-2 focus:-outline-offset-2 focus:outline-indigo-600 sm:text-sm/6"></textarea>
            </div>
        </div>
    </div>
    <div class="mt-10">
        <button id="finalSubmit" type="submit" class="block w-full rounded-md bg-gray-400 px-3.5 py-2.5 text-center text-sm font-semibold text-white shadow-xs focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-indigo-600">Submit</button>
    </div>
</form>
</body>
</html>
