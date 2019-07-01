
function loadAllPlayers() {
    getAllPlayerFromAPI(this.getPlayerApiUrl()).then((value) => {
        let players = JSON.parse(value);
        generatePlayerCards(players);
    }).catch((value) => {
        //Do something.
    });
}

function generatePlayerCards(players) {
    let container = document.getElementById("mainContainer");
    container.innerHTML = "SOMETHING";

    console.log(container);
    players.forEach(player => {

        console.log(player.firstname)

        let cardImage = document.createElement("img");
        cardImage.classList.add("card-img-top");
        cardImage.src = "img/default_profile.jpg";

        let cardHeaderTitle = document.createElement("h5");
        cardHeaderTitle.classList.add("card-title");
        let fullnameText = document.createTextNode(player.firstname + " " + player.lastname);
        cardHeaderTitle.append(fullnameText);

        let usernameCardText = document.createElement("p");
        usernameCardText.classList.add("card-text");
        let usernameText = document.createTextNode("Username: " + player.username);
        usernameCardText.append(usernameText);

        let winsCardText = document.createElement("p");
        winsCardText.classList.add("card-text");
        let winsText = document.createTextNode("Wins: " + player.wins);
        winsCardText.append(winsText);

        let lossesCardText = document.createElement("p");
        lossesCardText.classList.add("card-text");
        let lossesText = document.createTextNode("Losses: " + player.loses);
        lossesCardText.append(lossesText) 

        let drawsCardText = document.createElement("p");
        drawsCardText.classList.add("card-text");
        let drawsText = document.createTextNode("Draws: " + player.draws);
        drawsCardText.append(drawsText);

        let cardFooterDiv = document.createElement("div");
        cardFooterDiv.classList.add("card-footer");

        let cardSmall = document.createElement("small");
        cardSmall.classList.add("text-muted");
        let footerText = document.createTextNode("Last updated 3 hours ago");
        cardSmall.append(footerText);

        cardFooterDiv.append(cardSmall);

        let cardDiv = document.createElement("div");
        cardDiv.classList.add("card");
        cardDiv.classList.add("align-items-center");
        cardDiv.classList.add("justify-content-around");
        cardDiv.append(cardImage);
        cardDiv.append(cardHeaderTitle);
        cardDiv.append(usernameCardText);
        cardDiv.append(winsCardText);
        cardDiv.append(lossesCardText);
        cardDiv.append(drawsCardText);
        
        let cardDeckDiv = document.createElement("div");
        cardDeckDiv.classList.add("card-deck");
        cardDeckDiv.append(cardDiv);
        
        let rowDiv = document.createElement("div");
        rowDiv.classList.add("row");
        rowDiv.classList.add("align-items-center");
        rowDiv.classList.add("justify-content-around");
        rowDiv.append(cardDeckDiv);

        container.append(rowDiv);

    });
}

function NOTUSING() {
    let counter = 0;
    const cardsInRow = 3;
    let container = document.getElementById("mainContainer"); //Append to last.

    players.forEach(element => {

        let row = document.createElement("div");
        row.classList.add("row align-items-center justify-content-around");

        let cardDeck = document.createElement("div");
        cardDeck.classList.add("card-deck");

        let card = document.createElement("div");
        card.classList.add("card");

        let image = document.createElement("img");
        image.classList.add("card-img-top");
        image.src = "img/default_profile.jpg";

        let cardBody = document.createElement("div");
        cardBody.classList.add("card-body");
        
        let cardTitle = document.createElement("h5");
        cardTitle.classList.add("card-title");
        let cardTitleTextNode = document.createTextNode(element.firstname + " " + element.surname);
        cardTitle.append(cardTitleTextNode);

        let cardTextUsername = document.createElement("p");
        cardTextUsername.classList.add("card-text");
        let cardUsernameTextNode = document.createTextNode(element.username);
        cardTextUsername.append(cardUsernameTextNode);

        let cardTextWins = document.createElement("p");
        cardTextWins.classList.add("card-text");
        let cardWinsTextNode = document.createTextNode(element.wins);
        cardTextWins.append(cardWinsTextNode);

        let cardTextLosses = document.createElement("p");
        cardTextLosses.classList.add("card-text");
        let cardLossTextNode = document.createTextNode(element.loses);
        cardTextLosses.append(cardLossTextNode);

        let cardTextDraws = document.createElement("p");
        cardTextDraws.classList.add("card-text");
        let cardDrawTextNode = document.createTextNode(element.draws);
        cardTextDraws.append(cardDrawTextNode);

        let cardFooter = document.createElement("div");
        cardFooter.classList.add("card-footer");

        let cardFooterText = document.createElement("small");
        cardFooterText.classList.add("text-muted");
        let cardFooterTextNode = document.createTextNode("Created 3 mins ago.");
        cardFooterText.append(cardFooterTextNode);
        
        cardBody.append(cardTitle);
        cardBody.append(cardTextUsername);
        cardBody.append(cardTextWins);
        cardBody.append(cardTextLosses);
        cardBody.append(cardTextDraws);

        cardFooter.append(cardFooterText);

        card.append(image);
        card.append(cardBody);
        card.append(cardFooter);

        cardDeck.append(card);

        row.append(cardDeck);

        container.append(row);

    });
}

function getAllPlayerFromAPI(apiUrl) {
    return new Promise(function (resolve, reject) {
        let getUrl = apiUrl;
        const XHR = new XMLHttpRequest();

        XHR.onreadystatechange = function () {
            if (XHR.readyState === 4) {
                if (XHR.status === 200) {
                    resolve(XHR.response);
                } else {
                    reject("Error: No user's found. Please register.");
                }
            }
        }

        XHR.open('GET', getUrl, true);
        XHR.send();
    });
}