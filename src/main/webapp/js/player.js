class Player {
    _id;
    _username;
    _firstname;
    _lastname;
    _wins = 0;
    _winStreaks = 0;
    _winStreakCounter = 0;
    _loses = 0;
    _lossStreaks = 0;
    _lossStreakCounter = 0;
    _draws = 0;
    _fullBalledEnemy = 0;
    _gotFullBalled = 0;

    constructor(username, firstname, lastname) {
        this._username = username;
        this._firstname = firstname;
        this._lastname = lastname;
    }

    get getId() {
        return this._id;
    }

    get getUsername() {
        return this._username;
    }

    set setFirstname(value) {
        this._firstname = value;
    }

    get getFirstname() {
        return this._firstname;
    }

    set setLastname(value) {
        this._lastname = value;
    }

    get getLastname() {
        return this._lastname;
    }

    set addWins() {
        this._wins++;
        this._winStreakCounter++;
        if (this._winStreakCounter > this._winStreaks) {
            this._winStreaks++;
            this._lossStreakCounter = 0;
        }
    }

    get getWins() {
        return this._wins;
    }

    set setLoses() {
        this._loses++;
        this._lossStreakCounter++;
        if (this._lossStreakCounter > this._lossStreaks) {
            this._lossStreaks++;
            this._winStreakCounter = 0;
        }
    }

    get getLoses() {
        return this._loses;
    }

    set setDraws(value) {
        this._draws = value;
    }

    get getDraws() {
        return this._draws;
    }

    get getWinStreaks() {
        return this._winStreaks;
    }

    get getLossesStreak() {
        return this._lossStreaks;
    }

    set setFullBalledEnemy(value) {
        this._fullBalledEnemy = value;
    }

    get getFullBalledEnemy() {
        return this._fullBalledEnemy;
    }

    set setGotFullBalled(value) {
        this._gotFullBalled = value;
    }

    get getGotFullBalled() {
        return this._gotFullBalled;
    }
}