let alertMessage;

function registerMeButtonClick() {
    let usernameValue = document.getElementById("loginForm").elements["username"].value;

    if (!isStringEmpty(usernameValue)) {
        sessionStorage.setItem("registerUsername", usernameValue);
    } else {
        sessionStorage.setItem("registerUsername", "none");
    }

    window.location.assign("register.html");
}

function logMeInButtonClicked() {
    let usernameInput = document.getElementById("loginForm").elements["username"];
    alertMessage = document.getElementById("alertMessage");

    checkFormValidation(usernameInput);

    getPlayerFromAPI(this.getPlayerByNameApiUrl(), usernameInput.value).then((value) => {
        showAlert(value, alertType.SUCCESS);
        setTimeout(() => {hideAlert();}, 5000)
        sessionStorage.setItem("playerJson", value);
        window.location.assign("playerprofile.html");
    }).catch((value) => {
        showAlert(value, alertType.FAIL);
        setTimeout(() => {hideAlert();}, 5000)
    });
}

function checkFormValidation(usernameInput) {
    if (isStringEmpty(usernameInput.value)) {
        usernameInput.classList.add("is-invalid");
        return;
    } else {
        usernameInput.classList.add("is-valid");
    }
}

function showAlert(message, alertType) {
    alertMessage.innerHTML = message;

    alertMessage.classList.remove("alert-success");
    alertMessage.classList.remove("alert-danger");

    alertMessage.classList.toggle("fade");
    alertMessage.classList.add("show", alertType);
}

function hideAlert() {
    alertMessage.classList.remove("show");
    alertMessage.classList.add("fade");
}

function getPlayerFromAPI(apiUrl, username) {
    return new Promise(function (resolve, reject) {
        let getUrl = apiUrl + username;
        const XHR = new XMLHttpRequest();

        XHR.onreadystatechange = function () {
            if (XHR.readyState === 4) {
                if (XHR.status === 200) {
                    resolve(XHR.response);
                } else {
                    reject("Error: Account " + username + " not found. Please register.");
                }
            }
        }

        XHR.open('GET', getUrl, true);
        XHR.send();
    });
}

function isStringEmpty(string) {
    if (string == "") {
        return true
    } else {
        return false
    }
}