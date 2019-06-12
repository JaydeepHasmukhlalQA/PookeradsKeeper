function createPlayerAPI(jsonPlayer) {
    return new Promise(function (resolve, reject) {
        let postUrl = "http://127.0.0.1:8080/PookeradsKeeper-1.0/api/player/";
        const XHR = new XMLHttpRequest();

        XHR.onreadystatechange = function () {
            if (XHR.readyState === 4) {
                if (XHR.status === 201) {
                    resolve("Successfully registered. Please login.");
                } else {
                    reject("Error: Cannot create account. Try again.");
                }
            }
        }

        XHR.open('POST', postUrl, true);
        XHR.setRequestHeader('Content-Type', 'application/json');
        XHR.send(jsonPlayer);

    });
}

function getPlayerByUsernameAPI(username) {
    return new Promise(function (resolve, reject) {
        let getUrl = "http://127.0.0.1:8080/PookeradsKeeper-1.0/api/player/" + username;
        const XHR = new XMLHttpRequest();

        XHR.onreadystatechange = function () {
            if (XHR.readyState === 4) {
                if (XHR.status === 200) {
                    resolve(XHR.response);
                } else {
                    reject("Error: Player " + username + " not found. Please register.");
                }
            }
        }

        XHR.open('GET', getUrl, true);
        XHR.send();
    });
}

function createPlayer() {
    let form = document.getElementById("loginForm");
    let username = form.elements["username"].value;

    if (isStringEmpty(username)) {
    }

    let player = new Player(username, "jaydeep", "hasmukhlal");
    let jsonString = JSON.stringify(player);

    createPlayerAPI(jsonString).then((value) => {
		console.log(value);
    });
}

function getPlayerByUsername() {
    if (isStringEmpty(username)) {
    }

    let retrievedJson = getPlayerByUsernameAPI(username).then((value) => {
        sessionStorage.setItem("player", value);
        window.location.assign("playerprofile.html");
    });
}

function isStringEmpty(string) {
    if (string == "") {
        return true
    } else {
        return false
    }
}