

function logMeInButtonClicked() {

}

function registerMeButtonClick() {
    let usernameValue = document.getElementById("loginForm").elements["username"].value;

    if (!isStringEmpty(usernameValue)) {
        sessionStorage.setItem("registerUsername", usernameValue);
    } else {
        sessionStorage.setItem("registerUsername", "none");
    }

    window.location.assign("register.html");
}

function isStringEmpty(string) {
    if (string == "") {
        return true
    } else {
        return false
    }
}