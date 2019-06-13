function getJsonPlayerFromSession() {
    let fakeJson = '{"draws":0,"firstname":"Jaydeep","fullBalledEnemy":0,"gotFullBalled":0,"id":3,"lastname":"Hasmukhlal","loses":0,"lossStreakCounter":0,"lossStreaks":0,"username":"jaydeeph","winStreakCounter":0,"winStreaks":0,"wins":0}';
    //let player = JSON.parse(sessionStorage.getItem("playerJson"));
    let player = JSON.parse(fakeJson);
    console.log(player);
    let {firstname, lastname} = player;

    document.getElementById("playerFullnameTag").innerHTML = firstname + " " + lastname;
    document.getElementById("playerProfileForm").elements["username"].value = player.username;
    document.getElementById("playerProfileForm").elements["firstname"].value = player.firstname;
    document.getElementById("playerProfileForm").elements["lastname"].value = player.lastname;
    document.getElementById("playerProfileForm").elements["wins"].value = player.wins;
    document.getElementById("playerProfileForm").elements["winStreaks"].value = player.winStreaks;
    document.getElementById("playerProfileForm").elements["losses"].value = player.loses;
    document.getElementById("playerProfileForm").elements["lossStreaks"].value = player.lossStreaks;
    document.getElementById("playerProfileForm").elements["draws"].value = player.draws;
    document.getElementById("playerProfileForm").elements["fullBalledEnemy"].value = player.fullBalledEnemy;
    document.getElementById("playerProfileForm").elements["gotFullBalled"].value = player.gotFullBalled;

}