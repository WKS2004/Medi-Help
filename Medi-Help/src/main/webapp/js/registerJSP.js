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

function validateNewPassword() {
    let newPassword = document.getElementById("newPassword").value;

    let newPasswordLength_validationMessage = document.getElementById("newPasswordLength_validationMessage");
    let newPasswordLowercase_validationMessage = document.getElementById("newPasswordLowercase_validationMessage");
    let newPasswordUppercase_validationMessage = document.getElementById("newPasswordUppercase_validationMessage");
    let newPasswordNumbers_validationMessage = document.getElementById("newPasswordNumbers_validationMessage");
    let newPasswordSymbols_validationMessage = document.getElementById("newPasswordSymbols_validationMessage");

    let patternFinal = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[~!@#$%^&*+\u002D/.,\u005C{}\u005B\u005D();:?<>"'])[A-Za-z\d~!@#$%^&*+\u002D/.,\u005C{}\u005B\u005D();:?<>"']{8,}$/;
    let patternLength = /^.{8,}$/;
    let patternLowercase = /^(?=.*[a-z]).*$/;
    let patternUppercase = /^(?=.*[A-Z]).*$/;
    let patternNumbers = /^(?=.*\d).*$/;
    let patternSymbols = /^(?=.*[~!@#$%^&*+\u002D/.,\u005C{}\u005B\u005D();:?<>"']).*$/;

    if (!patternFinal.test(newPassword)) {
        if (!patternLength.test(newPassword)) {
            newPasswordLength_validationMessage.textContent = "*Password must contain at least 8 characters!";
            newPasswordLength_validationMessage.classList.add("text-red-500");
            newPasswordLength_validationMessage.classList.remove("text-green-500");
        } else {
            newPasswordLength_validationMessage.textContent = "Password must contain at least 8 characters!";
            newPasswordLength_validationMessage.classList.add("text-green-500");
            newPasswordLength_validationMessage.classList.remove("text-red-500");
        }
        if (!patternLowercase.test(newPassword)) {
            newPasswordLowercase_validationMessage.textContent = "*Must contain at least one lowercase character!";
            newPasswordLowercase_validationMessage.classList.add("text-red-500");
            newPasswordLowercase_validationMessage.classList.remove("text-green-500");
        } else {
            newPasswordLowercase_validationMessage.textContent = "Must contain at least one lowercase character!";
            newPasswordLowercase_validationMessage.classList.add("text-green-500");
            newPasswordLowercase_validationMessage.classList.remove("text-red-500");
        }
        if (!patternUppercase.test(newPassword)) {
            newPasswordUppercase_validationMessage.textContent = "*Must contain at least one uppercase character!";
            newPasswordUppercase_validationMessage.classList.add("text-red-500");
            newPasswordUppercase_validationMessage.classList.remove("text-green-500");
        } else {
            newPasswordUppercase_validationMessage.textContent = "Must contain at least one uppercase character!";
            newPasswordUppercase_validationMessage.classList.add("text-green-500");
            newPasswordUppercase_validationMessage.classList.remove("text-red-500");
        }
        if (!patternNumbers.test(newPassword)) {
            newPasswordNumbers_validationMessage.textContent = "*Must contain at least one number!";
            newPasswordNumbers_validationMessage.classList.add("text-red-500");
            newPasswordNumbers_validationMessage.classList.remove("text-green-500");
        } else {
            newPasswordNumbers_validationMessage.textContent = "Must contain at least one number!";
            newPasswordNumbers_validationMessage.classList.add("text-green-500");
            newPasswordNumbers_validationMessage.classList.remove("text-red-500");
        }
        if (!patternSymbols.test(newPassword)) {
            newPasswordSymbols_validationMessage.textContent = "*Must contain at least one symbol!";
            newPasswordSymbols_validationMessage.classList.add("text-red-500");
            newPasswordSymbols_validationMessage.classList.remove("text-green-500");
        } else {
            newPasswordSymbols_validationMessage.textContent = "Must contain at least one symbol!";
            newPasswordSymbols_validationMessage.classList.add("text-green-500");
            newPasswordSymbols_validationMessage.classList.remove("text-red-500");
        }
        return false;
    } else {
        newPasswordLength_validationMessage.textContent = "Password must contain at least 8 characters!";
        newPasswordLength_validationMessage.classList.add("text-green-500");
        newPasswordLength_validationMessage.classList.remove("text-red-500");

        newPasswordLowercase_validationMessage.textContent = "Must contain at least one lowercase character!";
        newPasswordLowercase_validationMessage.classList.add("text-green-500");
        newPasswordLowercase_validationMessage.classList.remove("text-red-500");

        newPasswordUppercase_validationMessage.textContent = "Must contain at least one uppercase character!";
        newPasswordUppercase_validationMessage.classList.add("text-green-500");
        newPasswordUppercase_validationMessage.classList.remove("text-red-500");

        newPasswordNumbers_validationMessage.textContent = "Must contain at least one number!";
        newPasswordNumbers_validationMessage.classList.add("text-green-500");
        newPasswordNumbers_validationMessage.classList.remove("text-red-500");

        newPasswordSymbols_validationMessage.textContent = "Must contain at least one symbol!";
        newPasswordSymbols_validationMessage.classList.add("text-green-500");
        newPasswordSymbols_validationMessage.classList.remove("text-red-500");
    }
    return true;
}

document.addEventListener("DOMContentLoaded", function () {
    let infoIcon = document.getElementById("infoIcon");
    let validationMessages = document.getElementById("validationMessages");

    // Show messages on hover
    infoIcon.addEventListener("mouseover", function () {
        validationMessages.classList.remove("hidden");
    });

    // Hide messages when mouse leaves
    infoIcon.addEventListener("mouseleave", function () {
        validationMessages.classList.add("hidden");
    });

    // Toggle visibility on click
    infoIcon.addEventListener("click", function () {
        validationMessages.classList.toggle("hidden");
    });
});

function validateConfirmPassword() {
    let newPassword = document.getElementById("newPassword").value;
    let confirmPassword = document.getElementById("confirmPassword").value;

    let confirmPassword_validationMessage = document.getElementById("confirmPassword_validationMessage");

    if (confirmPassword !== "") {
        if (newPassword !== confirmPassword) {
            confirmPassword_validationMessage.textContent = "*This is not matching with the given password!";
            confirmPassword_validationMessage.classList.remove("hidden");
            return false;
        } else {
            confirmPassword_validationMessage.textContent = "";
            confirmPassword_validationMessage.classList.add("hidden");
        }
    } else {
        confirmPassword_validationMessage.classList.add("hidden");
        return false;
    }
    return true;
}

function checkInputs_firstSet() {
    let signUpButton = document.getElementById("signUpButton");

    let email = document.getElementById("email").value;
    let newPassword = document.getElementById("newPassword").value;
    let confirmPassword = document.getElementById("confirmPassword").value;

    let emailTick = document.getElementById("emailTick");
    let newPasswordTick = document.getElementById("newPasswordTick");
    let confirmPasswordTick = document.getElementById("confirmPasswordTick");


    // Email Validation
    if (validateEmail()) {
        emailTick.classList.remove("hidden");
    } else {
        emailTick.classList.add("hidden");
    }

    // Password Validation
    if (validateNewPassword()) {
        newPasswordTick.classList.remove("hidden");
    } else {
        newPasswordTick.classList.add("hidden");
    }

    // Confirm Password Validation
    if (validateConfirmPassword()) {
        confirmPasswordTick.classList.remove("hidden");
    } else {
        confirmPasswordTick.classList.add("hidden");
    }

    // Enable/Disable Sign Up Button
    if (newPassword !== "" && confirmPassword !== "" && email !== "" && validateEmail() && validateNewPassword() && validateConfirmPassword()) {
        signUpButton.disabled = false;
        signUpButton.classList.remove("bg-gray-400");
        signUpButton.classList.add("bg-indigo-600", "hover:bg-indigo-500");
    } else {
        signUpButton.disabled = true;
        signUpButton.classList.remove("bg-indigo-600", "hover:bg-indigo-500");
        signUpButton.classList.add("bg-gray-400");
    }
}

function validateFirstName() {
    let firstName = document.getElementById("firstName").value;

    return (firstName !== "");
}

function validateLastName() {
    let lastName = document.getElementById("lastName").value;

    return (lastName !== "");
}

function validateUsername() {
    let username = document.getElementById("username").value;

    return (username !== "");
}

function checkInputs_secondSet() {
    let continueButton = document.getElementById("continueButton");
    let lastName = document.getElementById("lastName").value;
    let username = document.getElementById("username").value;

    let firstName = document.getElementById("firstName").value;

    let firstNameTick = document.getElementById("firstNameTick");
    let lastNameTick = document.getElementById("lastNameTick");
    let userNameTick = document.getElementById("usernameTick");

    // First Name Validation
    if (validateFirstName()) {
        firstNameTick.classList.remove("hidden");
    } else {
        firstNameTick.classList.add("hidden");
    }

    // Last Name Validation
    if (validateLastName()) {
        lastNameTick.classList.remove("hidden");
    } else {
        lastNameTick.classList.add("hidden");
    }

    // Username Validation
    if (validateUsername()) {
        userNameTick.classList.remove("hidden");
    } else {
        userNameTick.classList.add("hidden");
    }

    // Enable/Disable Continue Button
    if (validateFirstName() && validateLastName() && validateUsername()) {
        continueButton.disabled = false;
        continueButton.classList.remove("bg-gray-400");
        continueButton.classList.add("bg-indigo-600", "hover:bg-indigo-500");
    } else {
        continueButton.disabled = true;
        continueButton.classList.remove("bg-indigo-600", "hover:bg-indigo-500");
        continueButton.classList.add("bg-gray-400");
    }
}