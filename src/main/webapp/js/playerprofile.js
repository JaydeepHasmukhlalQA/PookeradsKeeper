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

function getJsonPlayerFromSession() {
    getAllInput();

    let fakeJson = '{"draws":0,"firstname":"Jaydeep","fullBalledEnemy":0,"gotFullBalled":0,"id":3,"lastname":"Hasmukhlal","loses":0,"lossStreakCounter":0,"lossStreaks":0,"username":"jaydeeph","winStreakCounter":0,"winStreaks":0,"wins":0}';
    //let player = JSON.parse(sessionStorage.getItem("playerJson"));
    let player = JSON.parse(fakeJson);
    console.log(player);
    let {firstname, lastname} = player;

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

function updateMeButtonPressed() {

}