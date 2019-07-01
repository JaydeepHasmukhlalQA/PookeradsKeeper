let alertMessage;

function findAndHideAlertBox() {
    if (alertMessage !== null) {
        alertMessage = document.getElementById("alertMessage");
    }
    hideAlert();
}

function showAlert(message, alertType) {
    alertMessage.style.display = "block";

    alertMessage.innerHTML = message;

    alertMessage.classList.remove("alert-success");
    alertMessage.classList.remove("alert-danger");

    alertMessage.classList.toggle("fade");
    alertMessage.classList.add("show", alertType);
}

function hideAlert() {
    alertMessage.classList.remove("show");
    alertMessage.classList.add("fade");
    alertMessage.style.display = "none";
}