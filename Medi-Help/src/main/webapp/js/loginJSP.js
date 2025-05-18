function validateUsernameOrEmail() {
    let usernameOrEmail = document.getElementById("usernameOrEmail").value;

    return (usernameOrEmail !== "");
}

function validatePassword() {
    let password = document.getElementById("password").value;

    return (password !== "");
}

function checkInputs() {
    let signUpButton = document.getElementById("signUpButton");

    // Enable/Disable Sign In Button
    if (validateUsernameOrEmail() && validatePassword()) {
        signUpButton.disabled = false;
        signUpButton.classList.remove("bg-gray-400");
        signUpButton.classList.add("bg-indigo-600", "hover:bg-indigo-500");
    } else {
        signUpButton.disabled = true;
        signUpButton.classList.remove("bg-indigo-600", "hover:bg-indigo-500");
        signUpButton.classList.add("bg-gray-400");
    }
}