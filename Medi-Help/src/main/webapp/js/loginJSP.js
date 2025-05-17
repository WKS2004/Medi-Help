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

function validatePassword() {
    let password = document.getElementById("password").value;

    return (password !== "");
}

function checkInputs() {
    let email = document.getElementById("email").value;
    let password = document.getElementById("password").value;

    let signUpButton = document.getElementById("signUpButton");

    // Enable/Disable Sign In Button
    if (validateEmail() && validatePassword()) {
        signUpButton.disabled = false;
        signUpButton.classList.remove("bg-gray-400");
        signUpButton.classList.add("bg-indigo-600", "hover:bg-indigo-500");
    } else {
        signUpButton.disabled = true;
        signUpButton.classList.remove("bg-indigo-600", "hover:bg-indigo-500");
        signUpButton.classList.add("bg-gray-400");
    }
}