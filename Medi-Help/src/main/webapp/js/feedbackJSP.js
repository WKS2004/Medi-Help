function validateFirstName() {
    let firstName = document.getElementById("firstName").value;

    return (firstName !== "");
}

function validateLastName() {
    let lastName = document.getElementById("lastName").value;

    return (lastName !== "");
}

function validateEmail() {
    let email = document.getElementById("email").value;
    return (lastName !== "");
}

function validatePhoneNumber() {
    let phoneNumber = document.getElementById("phoneNumber").value;

    return (phoneNumber.length === 10);
}

function validateMessage() {
    let comment = document.getElementById("comment").value;

    return (comment !== "");
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

        // Call validation on switch toggle
        checkInputs();
    });

    // Attach listeners to call checkInputs
    const inputs = ["firstName", "lastName", "email", "phoneNumber", "message"];
    inputs.forEach(id => {
        const input = document.getElementById(id);
        if (input) {
            input.addEventListener("keyup", checkInputs);
            input.addEventListener("change", checkInputs);
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
