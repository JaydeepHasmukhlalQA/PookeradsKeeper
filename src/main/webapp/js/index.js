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

    checkFormValidation(usernameInput);

    getPlayerFromAPI(usernameInput.value).then((value) => {
        console.log(value);
        sessionStorage.setItem("playerJson", value);
        window.location.assign("playerprofile.html");
    }).catch((value) => {
        console.log(value);
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

function getPlayerFromAPI(username) {
    return new Promise(function (resolve, reject) {
        let getUrl = "http://127.0.0.1:8080/PookeradsKeeper-1.0/api/player/user/" + username;
        const XHR = new XMLHttpRequest();

        XHR.onreadystatechange = function () {
            if (XHR.readyState === 4) {
                if (XHR.status === 200) {
                    resolve(XHR.response);
                } else {
                    reject("Error: Account" + username + " not found. Please register.");
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