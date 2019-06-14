let fullnameLabel;
let usernameLabel;
let firstnameInput;
let lastnameInput;
let winsLabel;
let winStreaksLabel;
let lossesLabel;
let lossStreakLabel;
let drawsLabel;
let fullBalledEnemyLabel;
let gotFullBalledLabel;
let alertMessage

let deleteMeButton;

let player;

const alertType = {
    SUCCESS: "alert-success",
    FAIL: "alert-danger"
}

function getJsonPlayerFromSession() {
    getAllInput();
    let jsonPlayer = sessionStorage.getItem("playerJson");
    player = JSON.parse(jsonPlayer);

    let { firstname, lastname } = player;

    fullnameLabel.innerHTML = firstname + " " + lastname;
    usernameLabel.innerHTML = player.username;
    firstnameInput.value = player.firstname;
    lastnameInput.value = player.lastname;
    winsLabel.innerHTML = player.wins;
    winStreaksLabel.innerHTML = player.winStreaks;
    lossesLabel.innerHTML = player.loses;
    lossStreakLabel.innerHTML = player.lossStreaks;
    drawsLabel.innerHTML = player.draws;
    fullBalledEnemyLabel.innerHTML = player.fullBalledEnemy;
    gotFullBalledLabel.innerHTML = player.gotFullBalled;
}

function getAllInput() {
    fullnameLabel = document.getElementById("playerFullnameTag");
    usernameLabel = document.getElementById("usernameLabel");
    firstnameInput = document.getElementById("firstnameInput");
    lastnameInput = document.getElementById("lastnameInput");
    winsLabel = document.getElementById("winsLabel");
    winStreaksLabel = document.getElementById("winStreaksLabel");
    lossesLabel = document.getElementById("lossesLabel");
    lossStreakLabel = document.getElementById("lossStreakLabel");
    drawsLabel = document.getElementById("drawsLabel");
    fullBalledEnemyLabel = document.getElementById("fullBalledEnemyLabel");
    gotFullBalledLabel = document.getElementById("gotFullBalledLabel");

    alertMessage = document.getElementById("alertMessage");

    deleteMeButton = document.getElementById("deleteMeButton");
    deleteMeButton.style.display = "none";
}

function updateDetailsButtonPressed() {
    let updateDetailsButton = document.getElementById("updateDetailsButton");

    if (updateDetailsButton.textContent === "Edit Details") {

        updateDetailsButton.textContent = "Update Details";
        firstnameInput.readOnly = false;
        lastnameInput.readOnly = false;
        deleteMeButton.style.display = "inline";

    } else if (updateDetailsButton.textContent === "Update Details") {

        updateDetailsButton.textContent = "Edit Details";
        firstnameInput.readOnly = true;
        lastnameInput.readOnly = true;

        deleteMeButton.style.display = "none";

        updatePlayerObject();

        let id = player.id;
        let jsonPlayer = JSON.stringify(player);

        updatePlayerToAPI(id, jsonPlayer).then((value) => {
            showAlert(value, alertType.SUCCESS);
        }).catch((value) => {
            showAlert(value, alertType.FAIL);
        });
    }
}

function deleteMeButtonPressed() {
    let id = player.id;

    deletePlayerFromAPI(id).then((value) => {
        showAlert(value, alertType.SUCCESS);
    }).catch((value) => {
        showAlert(value, alertType.FAIL);
    });
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
    alertMessage.classList.add("show");
}

function updatePlayerObject() {
    player.firstname = firstnameInput.value;
    player.lastname = lastnameInput.value;
}

function updatePlayerToAPI(id, jsonPlayer) {
    return new Promise(function (resolve, reject) {
        let putUrl = "http://127.0.0.1:8080/PookeradsKeeper-1.0/api/player/" + id;
        const XHR = new XMLHttpRequest();

        XHR.onreadystatechange = function () {
            if (XHR.readyState === 4) {
                if (XHR.status === 200) {
                    resolve("Successfully updated " + player.firstname + "'s account.");
                } else {
                    reject("Error: Could not update account. Please try again later.");
                }
            }
        }

        XHR.open('PUT', putUrl, true);
        XHR.setRequestHeader('Content-Type', 'application/json');
        XHR.send(jsonPlayer);
    });
}

function deletePlayerFromAPI(id) {
    return new Promise(function (resolve, reject) {
        let deleteUrl = "http://127.0.0.1:8080/PookeradsKeeper-1.0/api/player/" + id;
        const XHR = new XMLHttpRequest();

        XHR.onreadystatechange = function () {
            if (XHR.readyState === 4) {
                if (XHR.status === 204) {
                    resolve("Successfully deleted " + player.firstname + "'s account.");
                } else {
                    reject("Error: Could not delete account. Please try again later.");
                }
            }
        }

        XHR.open('DELETE', deleteUrl, true);
        XHR.send();
    });
}