//удаление не работает почему-то - вроде бы починилось
function _BookUtil(){
    this.delete = function(id) { //deleteB ook
        if (confirm("Are you sure?")) {
            window.location = "/delete/" + id; //deleteB ook
        }
    }
}

var BookUtil = new _BookUtil();