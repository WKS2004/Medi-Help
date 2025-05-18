function validateFirstName() {
    let firstName = document.getElementById("first-name").value;

    return (firstName !== "");
}

function validateLastName() {
    let lastName = document.getElementById("last-name").value;

    return (lastName !== "");
}

function validateEmail() {
    let email = document.getElementById("email").value;
    let email_validationMessage = document.getElementById("email_validationMessage");

    let validEmailPattern = /^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$/;
    let invalidEmailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;

    if (email !== "") {
        if ((!validEmailPattern.test(email))) {
            if (invalidEmailPattern.test(email)) {
                email_validationMessage.textContent = "*All characters must be lowercase!";
            } else {
                email_validationMessage.textContent = "*Invalid Email Address!";
            }
            email_validationMessage.classList.remove("hidden")
            return false;
        } else {
            email_validationMessage.textContent = "";
            email_validationMessage.classList.add("hidden")
        }
    } else {
        email_validationMessage.classList.add("hidden")
        return false;
    }
    return true;
}

function validatePhoneNumber() {
    let phoneNumber = document.getElementById("phone-number").value;

    return (phoneNumber.length === 10);
}

function validateMessage() {
    let message = document.getElementById("message").value;

    return (message !== "");
}


let agreed = false;

document.addEventListener("DOMContentLoaded", function () {
    const agreementToggle = document.getElementById("agreeSwitch");
    const agreementDot = document.getElementById("agreeSwitchDot");

    agreementToggle.addEventListener("click", () => {
        agreed = !agreed;

        // Toggle background
        if (agreed) {
            agreementToggle.classList.remove("bg-gray-200");
            agreementToggle.classList.add("bg-indigo-600");
            agreementDot.classList.remove("translate-x-0");
            agreementDot.classList.add("translate-x-3.5");
        } else {
            agreementToggle.classList.remove("bg-indigo-600");
            agreementToggle.classList.add("bg-gray-200");
            agreementDot.classList.remove("translate-x-3.5");
            agreementDot.classList.add("translate-x-0");
        }
    });
});


function checkInputs() {
    const finalSubmit = document.getElementById("finalSubmit");

    // Enable/Disable Sign In Button
    if (validateFirstName() && validateLastName() && validateEmail() && validatePhoneNumber() && validateMessage() && agreed) {
        finalSubmit.disabled = false;
        finalSubmit.classList.remove("bg-gray-400");
        finalSubmit.classList.add("bg-indigo-600", "hover:bg-indigo-500");
    } else {
        finalSubmit.disabled = true;
        finalSubmit.classList.remove("bg-indigo-600", "hover:bg-indigo-500");
        finalSubmit.classList.add("bg-gray-400");
    }
}
