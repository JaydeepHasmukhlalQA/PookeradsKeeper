const windowLocation = window.location.href;

function getProtocol() {
    return windowLocation.split("/").slice(0, 1);
}

function getDomainAndPort() {
    return windowLocation.split("/").slice(2, 3);
}

function getWarFileName() {
    return windowLocation.split("/").slice(3, 4);
}

function getAPILocation() {
    return windowLocation.split("/").splice(0, 4).join("/") + "/api/";
}

function getPlayerByNameApiUrl() {
    return getAPILocation() + "player/user/";
}

function getPlayerApiUrl() {
    return getAPILocation() + "player/";
}