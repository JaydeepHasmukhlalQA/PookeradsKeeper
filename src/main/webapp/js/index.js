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

    getPlayerFromAPI(this.getPlayerByNameAPIURL(), usernameInput.value).then((value) => {
        sessionStorage.setItem("playerJson", value);
        window.location.assign("playerprofile.html");
    }).catch((value) => {
        //SHOW ERROR
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

function getPlayerFromAPI(apiUrl, username) {
    return new Promise(function (resolve, reject) {
        let getUrl = apiUrl + username;
        console.log(getUrl);
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