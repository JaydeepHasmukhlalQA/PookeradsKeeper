class Player {
    id;
    username;
    firstname;
    lastname;
    wins = 0;
    winStreaks = 0;
    winStreakCounter = 0;
    loses = 0;
    lossStreaks = 0;
    lossStreakCounter = 0;
    draws = 0;
    fullBalledEnemy = 0;
    gotFullBalled = 0;

    constructor(username, firstname, lastname) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    get getId() {
        return this.id;
    }

    get getUsername() {
        return this.username;
    }

    set setFirstname(value) {
        this.firstname = value;
    }

    get getFirstname() {
        return this.firstname;
    }

    set setLastname(value) {
        this.lastname = value;
    }

    get getLastname() {
        return this.lastname;
    }

    addWins() {
        this.wins++;
        this.winStreakCounter++;
        if (this.winStreakCounter > this.winStreaks) {
            this.winStreaks++;
            this.lossStreakCounter = 0;
        }
    }

    get getWins() {
        return this._wins;
    }

    addLoss() {
        this.loses++;
        this.lossStreakCounter++;
        if (this.lossStreakCounter > this.lossStreaks) {
            this.lossStreaks++;
            this.winStreakCounter = 0;
        }
    }

    get getLoss() {
        return this.loses;
    }

    set setDraws(value) {
        this.draws = value;
    }

    get getDraws() {
        return this.draws;
    }

    get getWinStreaks() {
        return this.winStreaks;
    }

    get getLossesStreak() {
        return this.lossStreaks;
    }

    set setFullBalledEnemy(value) {
        this.fullBalledEnemy = value;
    }

    get getFullBalledEnemy() {
        return this.fullBalledEnemy;
    }

    set setGotFullBalled(value) {
        this.gotFullBalled = value;
    }

    get getGotFullBalled() {
        return this.gotFullBalled;
    }
}