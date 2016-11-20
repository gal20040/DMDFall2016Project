function _ReserveUtil(){
    this.reserveRoom = function(hotelroomid) {
        if (confirm("Are you sure?")) {
            window.location = "/reserveRoom/" + hotelroomid;
        }
    }
}

var reserveUtil = new _ReserveUtil();