function searchButtonActivate()
{
    let searchBar = document.getElementById("searchBar").value;
    let searchButton = document.getElementById("searchButton");

    searchButton.disabled = (searchBar === "");
}


function productsMedicalDevices()
{
    let productsMedicalDevices = document.getElementById("productsMedicalDevices");
    let productsMedicines = document.getElementById("productsMedicines");

    let productsMedicalDevicesContent = document.getElementById("productsMedicalDevicesContent");
    let productsMedicinesContent = document.getElementById("productsMedicinesContent");

    productsMedicalDevices.classList.add("border-l-4", "border-indigo-400");

    productsMedicines.classList.remove("border-l-4", "border-indigo-400");

    productsMedicalDevicesContent.classList.remove("hidden");
    productsMedicinesContent.classList.add("hidden");
}
document.getElementById("productsMedicalDevices").addEventListener("click", productsMedicalDevices);


function productsMedicines()
{
    let productsMedicalDevices = document.getElementById("productsMedicalDevices");
    let productsMedicines = document.getElementById("productsMedicines");

    let productsMedicalDevicesContent = document.getElementById("productsMedicalDevicesContent");
    let productsMedicinesContent = document.getElementById("productsMedicinesContent");

    productsMedicalDevices.classList.remove("border-l-4", "border-indigo-400");

    productsMedicines.classList.add("border-l-4", "border-indigo-400");

    productsMedicalDevicesContent.classList.add("hidden");
    productsMedicinesContent.classList.remove("hidden");
}
document.getElementById("productsMedicines").addEventListener("click", productsMedicines);


function productsMenuFullToggle()
{
    let body = document.getElementById("body");
    let productsFull = document.getElementById("productsFull");
    let productsMenuFull = document.getElementById("productsMenuFull");

    if (productsMenuFull.classList.contains("max-h-0"))
    {
        productsFull.classList.add("border-b-2", "border-indigo-400");

        productsMenuFull.classList.remove("max-h-0", "opacity-0");
        productsMenuFull.classList.add("block", "opacity-100", "max-h-125");

        // body.classList.remove("bg-white")
        // body.classList.add("bg-gray-300");
    } else {
        productsFull.classList.remove("border-b-2", "border-indigo-400");

        productsMenuFull.classList.remove("block", "opacity-100", "max-h-125");
        productsMenuFull.classList.add("max-h-0", "opacity-0");

        // body.classList.remove("bg-gray-300");
        // body.classList.add("bg-white");
    }

    // let productsMedicalDevices = document.getElementById("productsMedicalDevices");
    // let productsMedicalDevicesContent = document.getElementById("productsMedicalDevicesContent");
    //
    // productsMedicalDevices.classList.add("border-l-4", "border-indigo-400");
    // productsMedicalDevicesContent.classList.remove("hidden");

    productsMedicalDevices();

}
document.getElementById("productsFull").addEventListener("click", productsMenuFullToggle);


function searchBarOutlineFocusIn()
{
    let searchBar = document.getElementById("searchBar");
    let searchBarForm = document.getElementById("searchBarForm");

    searchBarForm.classList.remove("border-1", "border-gray-300");
    searchBarForm.classList.add("border-2", "border-indigo-600");

    searchBar.classList.remove("border-y-1", "border-gray-300");
    searchBar.classList.add("focus:border-y-2", "focus:border-indigo-600");
}
document.getElementById("searchBar").addEventListener("focusin", searchBarOutlineFocusIn);


function searchBarOutlineFocusOut()
{
    let searchBar = document.getElementById("searchBar");
    let searchBarForm = document.getElementById("searchBarForm");

    searchBarForm.classList.add("border-1", "border-gray-300");
    searchBarForm.classList.remove("border-2", "border-indigo-600");

    searchBar.classList.add("border-y-1", "border-gray-300");
    searchBar.classList.remove("focus:border-y-2", "focus:border-indigo-600");
}
document.getElementById("searchBar").addEventListener("focusout", searchBarOutlineFocusOut);