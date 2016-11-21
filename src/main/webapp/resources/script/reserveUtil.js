function _ReserveUtil(){
    this.reserveRoom = function(hrID) {
        window.location = "/reserveRoom/" + hrID;
    }
}

var reserveUtil = new _ReserveUtil();