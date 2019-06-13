let fullnameHeader;
let usernameInput;
let firstnameInput;
let lastnameInput;
let winsInput;
let winStreaksInput;
let lossesInput;
let lossStreakInput;
let drawsInput;
let fullBalledEnemyInput;
let gotFullBalledInput;
let player;

function getJsonPlayerFromSession() {
    getAllInput();
    let jsonPlayer = sessionStorage.getItem("playerJson");
    player = JSON.parse(jsonPlayer);

    let { firstname, lastname } = player;

    fullnameHeader.innerHTML = firstname + " " + lastname;
    usernameInput.value = player.username;
    firstnameInput.value = player.firstname;
    lastnameInput.value = player.lastname;
    winsInput.value = player.wins;
    winStreaksInput.value = player.winStreaks;
    lossesInput.value = player.loses;
    lossStreakInput.value = player.lossStreaks;
    drawsInput.value = player.draws;
    fullBalledEnemyInput.value = player.fullBalledEnemy;
    gotFullBalledInput.value = player.gotFullBalled;
}

function getAllInput() {
    fullnameHeader = document.getElementById("playerFullnameTag");
    usernameInput = document.getElementById("playerProfileForm").elements["username"];
    firstnameInput = document.getElementById("playerProfileForm").elements["firstname"];
    lastnameInput = document.getElementById("playerProfileForm").elements["lastname"];
    winsInput = document.getElementById("playerProfileForm").elements["wins"];
    winStreaksInput = document.getElementById("playerProfileForm").elements["winStreaks"];
    lossesInput = document.getElementById("playerProfileForm").elements["losses"];
    lossStreakInput = document.getElementById("playerProfileForm").elements["lossStreaks"];
    drawsInput = document.getElementById("playerProfileForm").elements["draws"];
    fullBalledEnemyInput = document.getElementById("playerProfileForm").elements["fullBalledEnemy"];
    gotFullBalledInput = document.getElementById("playerProfileForm").elements["gotFullBalled"];
}

function updateDetailsButtonPressed() {
    let updateDetailsButton = document.getElementById("updateDetailsButton");

    if (updateDetailsButton.textContent === "Edit Details") {

        updateDetailsButton.textContent = "Update Details";
        firstnameInput.readOnly = false;
        lastnameInput.readOnly = false;

    } else if (updateDetailsButton.textContent === "Update Details") {

        updateDetailsButton.textContent = "Edit Details";
        firstnameInput.readOnly = true;
        lastnameInput.readOnly = true;

        updatePlayer();

        let id = player.id;
        let jsonPlayer = JSON.stringify(player);

        updatePlayerToAPI(id, jsonPlayer).then((value) => {
            console.log(value)
        }).catch((value) => {
            console.log(value)
        });
    }
}

function deleteMeButtonPressed() {
    let id = player.id;

    deletePlayerFromAPI(id).then((value) => {
        console.log(value);
    }).catch((value) => {
        console.log(value);
    });
}

function updatePlayer() {
    player.firstname = firstnameInput.value;
    player.lastname = lastnameInput.value;
}

function updatePlayerToAPI(id, jsonPlayer) {
    return new Promise(function (resolve, reject) {
        let putUrl = "http://127.0.0.1:8080/PookeradsKeeper-1.0/api/player/" + id;
        const XHR = new XMLHttpRequest();

        XHR.onreadystatechange = function() {
            if (XHR.readyState === 4) {
                if (XHR.status === 200) {
                    resolve("Successfully updated account.");
                } else {
                    reject("Error: Could not update account. Try again.");
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

        XHR.onreadystatechange = function() {
            if (XHR.readyState === 4) {
                if (XHR.status === 204) {
                    resolve("Successfully deleted your account.");
                } else {
                    reject("Error: Could not delete account. Please try again.");
                }
            }
        }

        XHR.open('DELETE', deleteUrl, true);
        XHR.send();
    });
}