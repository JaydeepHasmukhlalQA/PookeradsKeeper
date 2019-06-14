const alertType = {
    SUCCESS: "alert-success",
    FAIL: "alert-danger"
}

let intervalCounter = 4;

function loadRegisterUsername() {
    let username = sessionStorage.getItem("registerUsername");
    if (username === "none") return;

    let usernanameElement = document.getElementById("registerForm").elements["username"];
    usernanameElement.value = username;
}

function registerMeButtonClick() {
    let usernameInput = document.getElementById("registerForm").elements["username"];
    let firstnameInput = document.getElementById("registerForm").elements["firstname"];
    let lastnameInput = document.getElementById("registerForm").elements["lastname"];
    let alertMessage = document.getElementById("alertMessage");
    let infoMessage = document.getElementById("infoMessage");

    checkFormValidation(usernameInput, firstnameInput, lastnameInput);

    let player = new Player(usernameInput.value, firstnameInput.value, lastnameInput.value);
    let jsonObject = JSON.stringify(player);

    postPlayerToAPI(jsonObject).then((value) => {
        showAlert(alertMessage, value, alertType.SUCCESS);
        setTimeout(() => {returnToLoginPage();}, 5000)
        setInterval(() => {informUserRedirect(infoMessage);}, 1000)
    }).catch((value) => {
        showAlert(alertMessage, value, alertType.FAIL);
    });
}

function checkFormValidation(usernameInput, firstnameInput, lastnameInput) {
    if (isStringEmpty(usernameInput.value)) {
        usernameInput.classList.add("is-invalid");
        return;
    } else {
        usernameInput.classList.add("is-valid");
    }

    if (isStringEmpty(firstnameInput.value)) {
        firstnameInput.classList.add("is-invalid");
        return;
    } else {
        firstnameInput.classList.add("is-valid");
    }

    if (isStringEmpty(lastnameInput.value)) {
        lastnameInput.classList.add("is-invalid");
        return;
    } else {
        lastnameInput.classList.add("is-valid");
    }
}

function showAlert(alertBox, message, alertType) {
    alertBox.innerHTML = message;

    alertBox.classList.remove("alert-success");
    alertBox.classList.remove("alert-danger");

    alertBox.classList.toggle("fade");
    alertBox.classList.add("show", alertType);
}

function hideAlert(alertBox) {
    alertBox.classList.remove("show");
    alertBox.classList.add("show");
}

function informUserRedirect(infoMessage) {
    if (intervalCounter != 0) {
        showAlert(infoMessage, "Taking you to login page in " + intervalCounter + "  seconds", "alert-info");
        intervalCounter--;
    }
}

function returnToLoginPage() {
    console.log("worked mate");
    window.location.assign("index.html");
}

function postPlayerToAPI(jsonObject) {
    return new Promise(function (resolve, reject) {
        let postUrl = "http://127.0.0.1:8080/PookeradsKeeper-1.0/api/player/";
        const XHR = new XMLHttpRequest();

        XHR.onreadystatechange = function () {
            if (XHR.readyState === 4) {
                if (XHR.status === 201) {
                    resolve("Successfully registered. Please login.");
                } else {
                    reject("Error: Could not create account. Try again.");
                }
            }
        }

        XHR.open('POST', postUrl, true);
        XHR.setRequestHeader('Content-Type', 'application/json');
        XHR.send(jsonObject);

    });
}

function isStringEmpty(string) {
    if (string == "") {
        return true
    } else {
        return false
    }
}

