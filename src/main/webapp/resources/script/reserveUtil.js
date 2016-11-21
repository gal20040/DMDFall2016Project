function _ReserveUtil(){
    this.reserveRoom = function(hrID) {
        if (confirm("Are you sure?")) {
            window.location = "/reserveRoom/" + hrID;
        }
    }
}

var reserveUtil = new _ReserveUtil();